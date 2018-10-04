package utiles;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JPanel;

import controlador.ParaUI;

public class GestorTemas {
	private ParaUI paraUI;

	public GestorTemas(ParaUI paraUI) {
		this.paraUI = paraUI;
	}

	public void changeForeground(Color color) {
		Component[] comps = this.paraUI.getContentPane().getComponents();
		for (Component component : comps) {
			if (component instanceof JPanel) {
				for (Component comp : ((JPanel) component).getComponents()) {
					
				}
			} else {
				component.setForeground(color);
			}
		}
	}
}
