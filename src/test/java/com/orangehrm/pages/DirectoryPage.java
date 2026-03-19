package com.orangehrm.pages;

import com.orangehrm.config.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DirectoryPage {

    private final WebDriver driver;
    private final WebDriverWait espera;

    private final By campoBusqueda      = By.xpath("//label[normalize-space()='Employee Name']/following::input[1]");
    private final By sugerenciaDropdown = By.cssSelector(".oxd-autocomplete-option span");
    private final By botonBuscar        = By.xpath("//button[@type='submit']");
    private final By tarjetasDeEmpleado = By.cssSelector(".orangehrm-directory-card");

    public DirectoryPage() {
        this.driver = DriverManager.obtenerDriver();
        this.espera = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void buscarPorNombreDeEmpleado(String nombre) {
        espera.until(ExpectedConditions.urlContains("directory"));
        WebElement campo = espera.until(ExpectedConditions.elementToBeClickable(campoBusqueda));
        campo.clear();
        campo.sendKeys(nombre);
        WebElement sugerencia = espera.until(
            ExpectedConditions.visibilityOfElementLocated(sugerenciaDropdown)
        );
        sugerencia.click();
        espera.until(ExpectedConditions.elementToBeClickable(botonBuscar)).click();
    }

    public boolean empleadoApareceEnResultados(String nombre) {
        List<WebElement> tarjetas = espera.until(
            ExpectedConditions.numberOfElementsToBeMoreThan(tarjetasDeEmpleado, 0)
        );
        return tarjetas.stream()
                .anyMatch(tarjeta -> tarjeta.getText().contains(nombre));
    }
}
