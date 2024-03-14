package co.edu.unbosque.controller;

import co.edu.unbosque.model.Cancion;
import co.edu.unbosque.view.View;

public class Controller {
	
	private View objVentana;
	private Cancion objModel;
	
	public Controller() {
		objModel = new Cancion();
		objVentana = new View();
		funcionar();
	}
	
	public void funcionar() {
		objVentana.escribirDato("BIENVEND@ "
				+ "\nCREA TU CANCIÓN!!!!!");
		int opcion;
		 do {
			 opcion = objVentana.mostrarMenu();
			 switch (opcion) {
				case 1:
					int numEstrofas=objVentana.pedirNumEstrofas();
					int numFrasesPorEstrofa=objVentana.pedirNumFrasesPorEstrofa();
					objModel.gestionarPropiedades(numEstrofas, numFrasesPorEstrofa);
					break;
					
				case 2:
					String song = objModel.crearCancionYGuardarConParametros();
					objVentana.escribirDato(song);
					objModel.guardarCancionEnArchivo(song);
					break;
				case 3:
					objVentana.escribirDato(objModel.seleccionarCancionYMostrar());
					break;
				case 4:
					objVentana.escribirDato("Gracias por usar el programa");
					break;
				default:
					objVentana.escribirDato("Opción no válida");
					break;
				}
		} while (opcion != 4);
            
		
		

	}

}

