package com.orangehrm.pages;

import com.orangehrm.config.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EmployeeDetailsPage {

    private final WebDriver driver;
    private final WebDriverWait espera;

    private final By contenedorFoto   = By.cssSelector(".employee-image-wrapper");
    private final By areaClickFoto    = By.cssSelector(".employee-image-wrapper .emp-picture-cell");
    private final By inputArchivo     = By.cssSelector("input[type='file']");
    private final By botonGuardarFoto = By.xpath("(//button[@type='button' and normalize-space()='Save'])[last()]");
    private final By mensajeExito     = By.cssSelector(".oxd-toast--success");

    public EmployeeDetailsPage() {
        this.driver = DriverManager.obtenerDriver();
        this.espera = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void esperarCargaDelPerfil() {
        espera.until(ExpectedConditions.presenceOfElementLocated(contenedorFoto));
    }

    public void subirFoto(String rutaArchivo) {
        WebElement contenedor = espera.until(
            ExpectedConditions.elementToBeClickable(contenedorFoto)
        );
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", contenedor);

        WebElement input = espera.until(
            ExpectedConditions.presenceOfElementLocated(inputArchivo)
        );
        ((JavascriptExecutor) driver).executeScript(
            "arguments[0].style.display='block'; arguments[0].style.visibility='visible'; arguments[0].style.opacity='1';",
            input
        );
        input.sendKeys(rutaArchivo);

        espera.until(ExpectedConditions.elementToBeClickable(botonGuardarFoto)).click();
        espera.until(ExpectedConditions.visibilityOfElementLocated(mensajeExito));
    }
}
