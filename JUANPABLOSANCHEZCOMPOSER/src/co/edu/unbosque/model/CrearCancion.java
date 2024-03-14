package co.edu.unbosque.model;

import java.util.Random;

public class CrearCancion {
	Random random = new Random();
	private String[] column1 = {"MAMI", "BEBE", "PRINCESS", "MOR"};
    private String[] column2 = {"YO QUIERO", "YO PUEDO", "YO VENGO A", "YO VOY A"};
    private String[] column3 = {"ENCENDELTE", "AMALTE", "LIGALTE", "JUGAL"};
    private String[] column4 = {"SUAVE", "LENTO", "RÁPIDO", "FUERTE"};
    private String[] column5 = {"HASTA SALGA EL SOL", "TODA LA NOCHE", "HASTA EL AMANECER", "TODO EL DÍA"};
    private String[] column6 = {"SIN ANESTESIA", "SIN COMPROMISO", "FEIS TO FEIS", "SIN MIEDO"};

    public String generarFrase() {
        return column1[random.nextInt(column1.length)] + " " +
                column2[random.nextInt(column2.length)] + " " +
                column3[random.nextInt(column3.length)] + " " +
                column4[random.nextInt(column4.length)] + " " +
                column5[random.nextInt(column5.length)] + " " +
                column6[random.nextInt(column6.length)];
    }
	
    public String generarCancion(int numEstrofas, int numFrasesPorEstrofa) {
    	String cancion = "";

        for (int i = 0; i < numEstrofas; i++) {
      
            for (int j = 0; j < numFrasesPorEstrofa; j++) {
                String fraseAleatoria = generarFrase();
                cancion += fraseAleatoria + "\n";
            }

            cancion += "\n";
        }

        return cancion;
    }
    
}
