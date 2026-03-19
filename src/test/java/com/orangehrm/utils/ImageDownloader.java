package com.orangehrm.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ImageDownloader {

    private static final String URL_IMAGEN = "https://picsum.photos/200";

    public static String descargarImagenTemporal() throws IOException {
        File archivo = File.createTempFile("foto_empleado_", ".jpg");
        archivo.deleteOnExit();

        HttpURLConnection conexion = (HttpURLConnection) new URL(URL_IMAGEN).openConnection();
        conexion.setInstanceFollowRedirects(true);
        conexion.setRequestProperty("User-Agent", "Mozilla/5.0");

        try (InputStream entrada = conexion.getInputStream();
             FileOutputStream salida = new FileOutputStream(archivo)) {
            entrada.transferTo(salida);
        }

        return archivo.getAbsolutePath();
    }
}
