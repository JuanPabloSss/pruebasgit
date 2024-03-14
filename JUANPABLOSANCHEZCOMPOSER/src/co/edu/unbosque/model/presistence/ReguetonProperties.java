package co.edu.unbosque.model.presistence;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.io.*;
import java.util.Properties;

public class ReguetonProperties {

    private Properties properties = new Properties();
    private String archivoProperties = "C:\\data\\regueton.properties";

    public int escribirPropiedades(int numEstrofas, int numFrasesPorEstrofa) {
        try {
            properties.setProperty("Numero de Estrofas", String.valueOf(numEstrofas));
            properties.setProperty("Numero de Frases por Estrofa", String.valueOf(numFrasesPorEstrofa));
            properties.store(new FileOutputStream(archivoProperties), null);
        } catch (IOException ex) {
            ex.printStackTrace();
            return -1;
        }
        return 0;
    }

    public Properties cargarPropiedades() {
        try (FileInputStream input = new FileInputStream(archivoProperties)) {
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return properties;
    }

    public String obtenerPropiedad(String clave) {
        return properties.getProperty(clave);
    }

    public void establecerPropiedad(String clave, String valor) {
        properties.setProperty(clave, valor);
    }
}