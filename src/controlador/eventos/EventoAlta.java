package controlador.eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controlador.ParaUI;

public class EventoAlta implements ActionListener {
	private ParaUI paraUI;

	public EventoAlta(ParaUI paraUI) {
		super();
		this.paraUI = paraUI;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.paraUI.insertarLibro();
		this.paraUI.botones.global(false);
	}
}
