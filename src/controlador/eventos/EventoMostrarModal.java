package controlador.eventos;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import modelo.Modalable;

public class EventoMostrarModal implements ActionListener{
	private Modalable modal;
	private boolean state;
	public EventoMostrarModal(Modalable modal, boolean state) {
		this.modal = modal;
		this.state = state;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		((Window) this.modal).setVisible(this.state);
	}

}
