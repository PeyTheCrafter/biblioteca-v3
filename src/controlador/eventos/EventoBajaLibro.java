package controlador.eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controlador.ParaUI;
import modelo.Estanteria;
import modelo.Libro;
import utiles.GestorAvisos;
import utiles.Mensajes;

public class EventoBajaLibro implements ActionListener {
	private ParaUI paraUI;
	private GestorAvisos aviso;
	private Estanteria almacenamiento;

	public EventoBajaLibro(ParaUI paraUI, Estanteria almacenamiento) {
		super();
		this.paraUI = paraUI;
		this.almacenamiento = almacenamiento;
		this.aviso = new GestorAvisos(this.paraUI);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String isbn = this.paraUI.getSeleccionado();
		int posicion = this.almacenamiento.posicionLibroISBN(isbn);
		if (posicion != -1) {
			Libro libro = this.almacenamiento.obtenerLibro(posicion);
			int ejemplares = libro.getEjemplares();
			if (this.almacenamiento.borrarLibroPosicion(posicion)) {
				this.aviso.informacion(Mensajes.ExitoBorrar.toString(), "Información");
				this.paraUI.limpiarISBN();
				this.paraUI.limpiarPantalla();
			} else {
				this.aviso.error(Mensajes.ErrorBorrar.toString(), "Error al borrar");
			}
		}
		this.paraUI.actualizarLista();
	}

	// @Override
	public void actionPerformed_old(ActionEvent e) {
		String isbn = this.paraUI.getSeleccionado();
		int posicion = this.almacenamiento.posicionLibroISBN(isbn);
		if (!this.almacenamiento.borrarLibroPosicion(posicion)) {
			aviso.error(Mensajes.ErrorBorrar.toString(), "Error de borrado");
		} else {
			aviso.informacion(Mensajes.ExitoBorrar.toString(), "información");
		}
		this.paraUI.actualizarLista();
		this.paraUI.limpiarPantalla();
	}

}
