package com.orangehrm.actions;

import com.orangehrm.pages.LoginPage;
import io.qameta.allure.Step;

public class LoginActions {

    private final LoginPage loginPage;

    public LoginActions() {
        this.loginPage = new LoginPage();
    }

    @Step("Autenticarse como {usuario}")
    public void autenticar(String usuario, String contrasena) {
        loginPage.ingresarUsuario(usuario);
        loginPage.ingresarContrasena(contrasena);
        loginPage.clickIngresar();
    }
}
