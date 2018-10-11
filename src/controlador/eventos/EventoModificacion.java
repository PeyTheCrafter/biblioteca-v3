package controlador.eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controlador.ParaUI;
import modelo.Estanteria;
import modelo.Libro;
import utiles.GestorAvisos;
import utiles.Mensajes;

public class EventoModificacion implements ActionListener {
	private ParaUI paraUI;
	private Estanteria almacenamiento;
	private GestorAvisos aviso;

	public EventoModificacion(ParaUI paraUI, Estanteria almacenamiento) {
		this.paraUI = paraUI;
		this.almacenamiento = almacenamiento;
		this.aviso = new GestorAvisos<>(this.paraUI);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int posicion = this.almacenamiento.posicionLibroISBN(this.paraUI.getTxtIsbn().getText());
		this.almacenamiento.borrarLibroPosicion(posicion);
		Libro libro = this.paraUI.recogerDatosLibro();
		if(this.almacenamiento.insertarLibro(libro, posicion)) {
			this.aviso.informacion(Mensajes.ExitoModificacion.toString(), "Libro modificado");
		} else {
			this.aviso.error(Mensajes.ErrorModificacion.toString(), "Error de modificación");
		}
		this.paraUI.actualizarLista();
	}

}
