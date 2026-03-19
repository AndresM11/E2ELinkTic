package com.orangehrm.actions;

import com.orangehrm.pages.DashboardPage;
import com.orangehrm.pages.EmployeeDetailsPage;
import com.orangehrm.pages.PimPage;
import io.qameta.allure.Step;

import java.util.Random;

public class PimActions {

    private final DashboardPage dashboardPage;
    private final PimPage pimPage;
    private final EmployeeDetailsPage employeeDetailsPage;

    public PimActions() {
        this.dashboardPage = new DashboardPage();
        this.pimPage = new PimPage();
        this.employeeDetailsPage = new EmployeeDetailsPage();
    }

    @Step("Navegar al módulo PIM")
    public void navegarAPim() {
        dashboardPage.irAPim();
    }

    @Step("Crear empleado: {nombre} {apellido}")
    public void crearEmpleado(String nombre, String apellido) {
        String idAleatorio = String.valueOf(10000 + new Random().nextInt(89999));
        pimPage.clickAgregarEmpleado();
        pimPage.ingresarNombre(nombre);
        pimPage.ingresarApellido(apellido);
        pimPage.ingresarIdEmpleado(idAleatorio);
        pimPage.guardarEmpleado();
    }

    @Step("Subir foto de perfil al empleado")
    public void subirFoto(String rutaArchivo) {
        employeeDetailsPage.esperarCargaDelPerfil();
        employeeDetailsPage.subirFoto(rutaArchivo);
    }
}
