package controlador;

import controlador.eventos.*;
import modelo.Estanteria;
import vista.UI;

public class ParaUI extends UI {
	private Estanteria almacenamiento;
	
	public ParaUI() {
		super();
		this.almacenamiento = new Estanteria();
		this.asignarEventos();
	}
	
	private void asignarEventos() {
		this.btnNuevo.addActionListener(new EventoNuevo(this));
		this.btnAlta.addActionListener(new EventoAlta(this));
		this.btnBaja.addActionListener(new EventoBaja(this));
	}
}
