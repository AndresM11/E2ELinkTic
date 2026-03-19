package com.orangehrm.tests;

import com.orangehrm.actions.DirectoryActions;
import com.orangehrm.actions.LoginActions;
import com.orangehrm.actions.PimActions;
import com.orangehrm.config.BaseTest;
import com.orangehrm.config.DriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

import java.io.File;

public class OrangeHrmE2ETest extends BaseTest {

    private static final String URL_BASE          = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    private static final String USUARIO_ADMIN     = "Admin";
    private static final String CONTRASENA_ADMIN  = "admin123";
    private static final String NOMBRE_EMPLEADO   = "Carlos";
    private static final String APELLIDO_EMPLEADO = "Morales" + System.currentTimeMillis();
    private static final String EMPLEADO_INEXISTENTE = "Korn";

    @Test(description = "Flujo E2E: crear empleado en PIM, subir foto y validar en Directory", priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Crea un empleado con foto en el módulo PIM y valida que aparece en el módulo Directory.")
    public void flujoCreacionYValidacionDeEmpleado() {
        DriverManager.obtenerDriver().get(URL_BASE);

        LoginActions login = new LoginActions();
        login.autenticar(USUARIO_ADMIN, CONTRASENA_ADMIN);

        PimActions pim = new PimActions();
        pim.navegarAPim();
        pim.crearEmpleado(NOMBRE_EMPLEADO, APELLIDO_EMPLEADO);

        String rutaFoto = new File("src/assets/FOTOPERFIL.png").getAbsolutePath();
        pim.subirFoto(rutaFoto);

        DirectoryActions directory = new DirectoryActions();
        directory.navegarADirectory();
        directory.buscarEmpleado(APELLIDO_EMPLEADO);
        directory.validarEmpleadoEnResultados(NOMBRE_EMPLEADO);
    }

    @Test(description = "[Negativo] Buscar un empleado inexistente debe mostrar error en el reporte", priority = 2)
    @Severity(SeverityLevel.MINOR)
    @Description("Verifica el comportamiento de Allure ante un fallo: busca un empleado que no existe en el sistema y fuerza la captura de pantalla en el reporte.")
    public void busquedaDeEmpleadoInexistenteDebeFallar() {
        DriverManager.obtenerDriver().get(URL_BASE);

        LoginActions login = new LoginActions();
        login.autenticar(USUARIO_ADMIN, CONTRASENA_ADMIN);

        DirectoryActions directory = new DirectoryActions();
        directory.navegarADirectory();
        directory.buscarEmpleadoInexistente(EMPLEADO_INEXISTENTE);
        directory.validarEmpleadoInexistenteEnResultados(EMPLEADO_INEXISTENTE);
    }
}
