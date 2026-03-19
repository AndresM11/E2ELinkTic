package com.orangehrm.actions;

import com.orangehrm.pages.DashboardPage;
import com.orangehrm.pages.DirectoryPage;
import io.qameta.allure.Step;
import org.testng.Assert;

public class DirectoryActions {

    private final DashboardPage dashboardPage;
    private final DirectoryPage directoryPage;

    public DirectoryActions() {
        this.dashboardPage = new DashboardPage();
        this.directoryPage = new DirectoryPage();
    }

    @Step("Navegar al módulo Directory")
    public void navegarADirectory() {
        dashboardPage.irADirectory();
    }

    @Step("Buscar empleado por nombre: {nombre}")
    public void buscarEmpleado(String nombre) {
        directoryPage.buscarPorNombreDeEmpleado(nombre);
    }

    @Step("Validar que el empleado '{nombre}' aparece en los resultados")
    public void validarEmpleadoEnResultados(String nombre) {
        Assert.assertTrue(
            directoryPage.empleadoApareceEnResultados(nombre),
            "El empleado '" + nombre + "' no fue encontrado en el módulo Directory."
        );
    }

    @Step("Buscar empleado inexistente: {nombre}")
    public void buscarEmpleadoInexistente(String nombre) {
        directoryPage.buscarNombreDirecto(nombre);
    }

    @Step("Validar que el empleado inexistente '{nombre}' aparece en los resultados")
    public void validarEmpleadoInexistenteEnResultados(String nombre) {
        Assert.assertTrue(
            directoryPage.existeEmpleadoEnResultados(nombre),
            "El empleado '" + nombre + "' no fue encontrado. No debería existir en el sistema."
        );
    }
}
