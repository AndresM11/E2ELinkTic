package com.orangehrm.pages;

import com.orangehrm.config.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage {

    private final WebDriver driver;
    private final WebDriverWait espera;

    private final By enlacePim       = By.xpath("//span[text()='PIM']");
    private final By enlaceDirectory = By.xpath("//span[text()='Directory']");

    public DashboardPage() {
        this.driver = DriverManager.obtenerDriver();
        this.espera = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void irAPim() {
        espera.until(ExpectedConditions.elementToBeClickable(enlacePim)).click();
    }

    public void irADirectory() {
        espera.until(ExpectedConditions.elementToBeClickable(enlaceDirectory)).click();
    }
}
