package controlador.eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controlador.ParaUI;
import modelo.Estanteria;
import modelo.Libro;
import utiles.GestorAvisos;
import utiles.Mensajes;

public class EventoVentaEjemplar implements ActionListener{
	private ParaUI paraUI;
	private GestorAvisos aviso;
	private Estanteria almacenamiento;

	public EventoVentaEjemplar(ParaUI paraUI, Estanteria almacenamiento) {
		super();
		this.paraUI = paraUI;
		this.almacenamiento = almacenamiento;
		this.aviso = new GestorAvisos(this.paraUI);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.paraUI.cv.setVisible(true);
		String isbn = this.paraUI.getSeleccionado();
		int posicion = this.almacenamiento.posicionLibroISBN(isbn);
		if (posicion != -1) {
			Libro libro = this.almacenamiento.obtenerLibro(posicion);
			int ejemplares = libro.getEjemplares();
			if(ejemplares != 0) {
				libro.setEjemplares(ejemplares - 1);
			} else {
				this.aviso.error("No hay existencias.", "Error de venta");
			}
		}
		this.paraUI.actualizarLista();
	}
	
}
