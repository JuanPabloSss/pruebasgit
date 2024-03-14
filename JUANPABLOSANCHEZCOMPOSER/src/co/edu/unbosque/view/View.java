package co.edu.unbosque.view;

import javax.swing.JOptionPane;

public class View {
	public int mostrarMenu() {
        return Integer.parseInt((JOptionPane.showInputDialog(null,"Seleccione una opción: "
        		+"\n1. Definir Parámetros"
        		+"\n2. Crear Canción"
        		+"\n3. Seleccionar Canción"
        		+"\n4. Salir","Menu",JOptionPane.INFORMATION_MESSAGE)));
    }
	public int pedirNumEstrofas() 
	{
		return  Integer.parseInt((JOptionPane.showInputDialog(null,"Ingrese Número de Estrofas","Estrofas",JOptionPane.INFORMATION_MESSAGE)));
	}
	public int pedirNumFrasesPorEstrofa() 
	{
		return  Integer.parseInt((JOptionPane.showInputDialog(null,"Ingrese Número de Frases por Estrofa","Frases por Estrofa",JOptionPane.INFORMATION_MESSAGE)));
	}
	public void escribirDato(String dato) 
	{
		JOptionPane.showMessageDialog(null, dato, "Canción", JOptionPane.INFORMATION_MESSAGE);
	}

}
