package com.orangehrm.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void iniciarDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions opciones = new ChromeOptions();
        opciones.addArguments("--start-maximized");
        opciones.addArguments("--disable-notifications");
        driver.set(new ChromeDriver(opciones));
    }

    public static WebDriver obtenerDriver() {
        return driver.get();
    }

    public static void cerrarDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
