package com.orangehrm.tests;

import com.orangehrm.actions.DirectoryActions;
import com.orangehrm.actions.LoginActions;
import com.orangehrm.actions.PimActions;
import com.orangehrm.config.BaseTest;
import com.orangehrm.config.DriverManager;
import com.orangehrm.utils.ImageDownloader;
import org.testng.annotations.Test;

import java.io.IOException;

public class OrangeHrmE2ETest extends BaseTest {

    private static final String URL_BASE          = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    private static final String USUARIO_ADMIN     = "Admin";
    private static final String CONTRASENA_ADMIN  = "admin123";
    private static final String NOMBRE_EMPLEADO   = "Carlos";
    private static final String APELLIDO_EMPLEADO = "Morales" + System.currentTimeMillis();

    @Test(description = "Flujo E2E: crear empleado en PIM, subir foto y validar en Directory")
    public void flujoCreacionYValidacionDeEmpleado() throws IOException {
        DriverManager.obtenerDriver().get(URL_BASE);

        LoginActions login = new LoginActions();
        login.autenticar(USUARIO_ADMIN, CONTRASENA_ADMIN);

        PimActions pim = new PimActions();
        pim.navegarAPim();
        pim.crearEmpleado(NOMBRE_EMPLEADO, APELLIDO_EMPLEADO);

        String rutaFoto = ImageDownloader.descargarImagenTemporal();
        pim.subirFoto(rutaFoto);

        DirectoryActions directory = new DirectoryActions();
        directory.navegarADirectory();
        directory.buscarEmpleado(APELLIDO_EMPLEADO);
        directory.validarEmpleadoEnResultados(NOMBRE_EMPLEADO);
    }
}
