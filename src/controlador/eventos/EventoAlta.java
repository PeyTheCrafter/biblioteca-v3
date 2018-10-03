package controlador.eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controlador.ParaUI;
import modelo.Libro;
import utiles.GestorAvisos;

public class EventoAlta implements ActionListener {
	private ParaUI paraUI;
	private GestorAvisos aviso;

	public EventoAlta(ParaUI paraUI) {
		super();
		this.paraUI = paraUI;
		this.aviso = new GestorAvisos(this.paraUI);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Libro libro = new Libro(this.paraUI.getTxtTitulo().getText(), this.paraUI.getTxtAutor().getText(),
				this.paraUI.getComboTema().getSelectedIndex(), this.paraUI.getTxtPaginas().getText(),
				this.paraUI.getTxtISBN().getText(), this.paraUI.getChkCartone().isSelected(),
				this.paraUI.getChkRustica().isSelected(), this.paraUI.getChkTapaDura().isSelected(),
				this.paraUI.getRadialNovedad().isSelected());
		boolean respuesta = this.paraUI.getAlmacenamiento().insertarLibro(libro);
		if (!respuesta) {
			if (this.paraUI.getAlmacenamiento().getUsoMemoria() == this.paraUI.getAlmacenamiento().getTamano()) {
				aviso.error("Error al añadir el libro. Memoria llena.", "Error de inserción");
			} else {
				aviso.error("Error al añadir el libro.", "Error de inserción");
			}
		} else {
			this.paraUI.insertarTable(libro);
			aviso.informacion("Libro añadido.", "Información");
		}
		this.paraUI.botones.global(false);
		this.paraUI.limpiarPantalla();
	}
}
