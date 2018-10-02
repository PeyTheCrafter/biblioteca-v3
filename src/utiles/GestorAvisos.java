package utiles;

import java.awt.Component;

import javax.swing.JOptionPane;

import controlador.ParaUI;

public class GestorAvisos<T> extends JOptionPane {
	Component padre;

	public GestorAvisos(Component padre) {
		this.padre = padre;
	}

	public void informacion(String mensaje, String titulo) {
		JOptionPane.showMessageDialog(this.padre, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
	}

	public void error(String mensaje, String titulo) {
		JOptionPane.showMessageDialog(this.padre, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
	}

	public void confirmacion(String mensaje, String titulo) {
		JOptionPane.showMessageDialog(this.padre, mensaje, titulo, JOptionPane.QUESTION_MESSAGE);
	}

}
