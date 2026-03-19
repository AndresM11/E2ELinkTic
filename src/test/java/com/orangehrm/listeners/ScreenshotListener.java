package com.orangehrm.listeners;

import com.orangehrm.config.DriverManager;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ScreenshotListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult resultado) {
        WebDriver driver = DriverManager.obtenerDriver();
        if (driver != null) {
            capturarPantalla(driver);
        }
    }

    @Attachment(value = "Captura de pantalla del fallo", type = "image/png")
    private byte[] capturarPantalla(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
