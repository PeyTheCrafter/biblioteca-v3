package controlador.eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controlador.ParaUI;
import modelo.Estanteria;
import modelo.Libro;
import utiles.GestorAvisos;
import utiles.Validador;

public class EventoAlta implements ActionListener {
	private ParaUI paraUI;
	private GestorAvisos aviso;
	private Estanteria almacenamiento;

	public EventoAlta(ParaUI paraUI, Estanteria almacenamiento) {
		super();
		this.paraUI = paraUI;
		this.almacenamiento = almacenamiento;
		this.aviso = new GestorAvisos(this.paraUI);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (Validador.validarISBN(this.paraUI.getTxtIsbn().getText())) {
			Libro libro = new Libro(this.paraUI.getTxtTitulo().getText(), this.paraUI.getTxtAutor().getText(),
					this.paraUI.getComboTema().getSelectedIndex(), this.paraUI.getTxtPaginas().getText(),
					this.paraUI.getTxtIsbn().getText(), this.paraUI.getChkCartone().isSelected(),
					this.paraUI.getChkRustica().isSelected(), this.paraUI.getChkTapaDura().isSelected(),
					this.paraUI.getRadialNovedad().isSelected());
			boolean respuesta = this.almacenamiento.insertarLibro(libro);
			if (!respuesta) {
				if (this.almacenamiento.getUsoMemoria() == this.almacenamiento.getTamano()) {
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
		} else {
			aviso.error("ISBN inválido.", "Error de ISBN");
		}
	}
}
