package com.orangehrm.pages;

import com.orangehrm.config.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private final WebDriver driver;
    private final WebDriverWait espera;

    private final By campoUsuario    = By.name("username");
    private final By campoContrasena = By.name("password");
    private final By botonIngresar   = By.cssSelector("button[type='submit']");

    public LoginPage() {
        this.driver = DriverManager.obtenerDriver();
        this.espera = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void ingresarUsuario(String usuario) {
        espera.until(ExpectedConditions.visibilityOfElementLocated(campoUsuario)).sendKeys(usuario);
    }

    public void ingresarContrasena(String contrasena) {
        driver.findElement(campoContrasena).sendKeys(contrasena);
    }

    public void clickIngresar() {
        driver.findElement(botonIngresar).click();
    }
}
