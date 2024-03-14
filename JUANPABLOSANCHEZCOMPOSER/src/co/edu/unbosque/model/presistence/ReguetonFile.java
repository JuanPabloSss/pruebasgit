package co.edu.unbosque.model.presistence;

import java.io.*;

public class ReguetonFile {

    private String filePath;

    public ReguetonFile(String filePath) {
        this.filePath = filePath;
    }

    public boolean escribirCancionEnArchivo(String cancion) {
        File file = new File(this.filePath);

        try (FileWriter fileWriter = new FileWriter(file);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {

            printWriter.println(cancion);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public String leerCancionDesdeArchivo() {
        StringBuilder cancion = new StringBuilder();
        String linea = "";

        File file = new File(this.filePath);

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            linea = bufferedReader.readLine();
            while (linea != null) {
                cancion.append(linea).append("\n");
                linea = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return cancion.toString();
    }
}
