package controlador;

import controlador.eventos.*;
import modelo.Estanteria;
import modelo.Libro;
import vista.UI;

public class ParaUI extends UI {
	private Estanteria almacenamiento;
	private static int TAMANO = 10;

	public ParaUI() {
		super();
		this.almacenamiento = new Estanteria(this.TAMANO);
		this.asignarEventos();
	}

	private void asignarEventos() {
		this.btnNuevo.addActionListener(new EventoNuevo(this));
		this.btnAlta.addActionListener(new EventoAlta(this));
		this.btnBaja.addActionListener(new EventoBaja(this));
	}

	// TODO: gestionar combobox, radial y checkbox.
	public void limpiarPantalla() {
		this.txtAutor.setText("");
		this.txtISBN.setText("");
		this.txtPaginas.setText("");
		this.txtTitulo.setText("");
	}

	public void insertarLibro() {
		Libro libro = new Libro(this.txtTitulo.getText(), this.txtAutor.getText(), "", this.txtPaginas.getText(),
				this.txtISBN.getText(), "", "", "", "", "");
		boolean respuesta = this.almacenamiento.insertarLibro(libro);
		if (!respuesta) {
			System.out.println("Error al añadir libro.");
		}
	}

	public Estanteria getAlmacenamiento() {
		return this.almacenamiento;
	}
}
