
package co.edu.unbosque.model;

import java.io.*;
import java.util.Properties;

import javax.swing.JFileChooser;

import co.edu.unbosque.model.presistence.ReguetonFile;
import co.edu.unbosque.model.presistence.ReguetonProperties;

public class Cancion {
	
	private CrearCancion song = new CrearCancion();
	
    public String gestionarArchivoCadena(int numEstrofas, int numFrasesPorEstrofa) {
        ReguetonFile archivo = new ReguetonFile("c:\\data\\cancionRegueton.txt");
        String cancion = song.generarCancion(numEstrofas, numFrasesPorEstrofa);
        archivo.escribirCancionEnArchivo(cancion);

        return archivo.leerCancionDesdeArchivo();
    }
    
    public void gestionarPropiedades(int numEstrofas, int numFrasesPorEstrofa) {
    	ReguetonProperties prop = new ReguetonProperties();
		
		prop.escribirPropiedades(numEstrofas, numFrasesPorEstrofa);
	}
    
    public String crearCancionYGuardarConParametros() {
        ReguetonProperties propiedades = new ReguetonProperties();
        Properties props = propiedades.cargarPropiedades();
        String cancion;
        if (props != null) {
            int numEstrofas = Integer.parseInt(props.getProperty("Numero de Estrofas"));
            int numFrasesPorEstrofa = Integer.parseInt(props.getProperty("Numero de Frases por Estrofa"));

          
             cancion = gestionarArchivoCadena(numEstrofas, numFrasesPorEstrofa);

            return cancion;
        } else {
            return "Error al cargar los parámetros. Asegúrate de definir los parámetros primero.";
        }
    }
   
    public void guardarCancionEnArchivo(String cancion) {
        JFileChooser fileChooser = new JFileChooser();
        int seleccion = fileChooser.showSaveDialog(null);

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            ReguetonFile archivo = new ReguetonFile(file.getAbsolutePath());
            gestionarArchivoGuardarCancion(cancion, archivo);
        }
    }
    public String seleccionarCancionYMostrar() {
        JFileChooser fileChooser = new JFileChooser();
        int seleccion = fileChooser.showOpenDialog(null);

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            ReguetonFile archivo = new ReguetonFile(file.getAbsolutePath());
            String cancion = leerCancionDesdeArchivo(archivo);
            return cancion;
        }
        return null;
    }

    private void gestionarArchivoGuardarCancion(String cancion, ReguetonFile archivo) {
        archivo.escribirCancionEnArchivo(cancion);
    }

    private String leerCancionDesdeArchivo(ReguetonFile archivo) {
        return archivo.leerCancionDesdeArchivo();
    }
    
    
}
