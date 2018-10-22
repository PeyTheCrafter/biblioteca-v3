package controlador.eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controlador.ParaUI;
import modelo.Estanteria;
import modelo.Libro;
import utiles.GestorAvisos;

public class EventoAltaEjemplar implements ActionListener {
	private ParaUI paraUI;
	private Estanteria almacenamiento;
	private GestorAvisos aviso;

	public EventoAltaEjemplar(ParaUI paraUI, Estanteria almacenamiento) {
		super();
		this.paraUI = paraUI;
		this.almacenamiento = almacenamiento;
		this.aviso = new GestorAvisos<>(this.paraUI);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.paraUI.mae.setVisible(true);
		String isbn = this.paraUI.getSeleccionado();
		int posicion = this.almacenamiento.posicionLibroISBN(isbn);
		int cantidad = Integer.valueOf(this.paraUI.mae.getTxt().getText());
		if (posicion != -1) {
			Libro libro = this.almacenamiento.obtenerLibro(posicion);
			if (cantidad >= 0) {
				libro.setEjemplares(libro.getEjemplares() + cantidad);
				this.almacenamiento.borrarLibroPosicion(posicion);
				this.almacenamiento.insertarLibro(libro, posicion);
				this.aviso.informacion("Stock actualizado.", "Stock");
				this.paraUI.mae.setVisible(false);
			} else {
				this.aviso.error("Cantidad inválida", "Error");
			}
		}
		this.paraUI.actualizarLista();
	}

}
