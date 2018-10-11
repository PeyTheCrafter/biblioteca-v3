package controlador.eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controlador.ParaUI;

public class EventoNuevo implements ActionListener {
	private ParaUI paraUI;

	public EventoNuevo(ParaUI paraUI) {
		this.paraUI = paraUI;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.paraUI.limpiarPantalla();
		this.paraUI.limpiarISBN();
		this.paraUI.botones.global(true);
	}

}
