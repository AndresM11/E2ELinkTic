package com.orangehrm.pages;

import com.orangehrm.config.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PimPage {

    private final WebDriver driver;
    private final WebDriverWait espera;

    private final By botonAgregar  = By.xpath("//button[normalize-space()='Add']");
    private final By campoNombre   = By.name("firstName");
    private final By campoApellido = By.name("lastName");
    private final By botonGuardar  = By.xpath("//button[@type='submit']");

    public PimPage() {
        this.driver = DriverManager.obtenerDriver();
        this.espera = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void clickAgregarEmpleado() {
        espera.until(ExpectedConditions.elementToBeClickable(botonAgregar)).click();
    }

    public void ingresarNombre(String nombre) {
        WebElement campo = espera.until(ExpectedConditions.visibilityOfElementLocated(campoNombre));
        campo.clear();
        campo.sendKeys(nombre);
    }

    public void ingresarApellido(String apellido) {
        WebElement campo = driver.findElement(campoApellido);
        campo.clear();
        campo.sendKeys(apellido);
    }

    public void guardarEmpleado() {
        espera.until(ExpectedConditions.elementToBeClickable(botonGuardar)).click();
    }
}
