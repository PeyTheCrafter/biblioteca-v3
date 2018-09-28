package Utiles;

import java.awt.Component;

import javax.swing.JComponent;
import javax.swing.JTextField;

public class Validador {
	public boolean comprobarCampoVacio(JTextField componente) {
		return !componente.getText().isEmpty();
	}
}
