package com.orangehrm.config;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod
    public void antes() {
        DriverManager.iniciarDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void despues() {
        DriverManager.cerrarDriver();
    }
}
