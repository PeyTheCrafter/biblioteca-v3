package controlador.eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controlador.ParaUI;

public class EventoBaja implements ActionListener {
	private ParaUI paraUI;

	public EventoBaja(ParaUI paraUI) {
		super();
		this.paraUI = paraUI;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.paraUI.borrarLibro();
	}

}
