package controlador.eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controlador.ParaUI;
import modelo.Estanteria;
import modelo.Libro;
import utiles.GestorAvisos;
import utiles.Mensajes;

public class EventoVentaEjemplar implements ActionListener {
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
		this.paraUI.mcv.setVisible(true);
		int cantidad = Integer.valueOf(this.paraUI.mcv.getTxt().getText());
		String isbn = this.paraUI.getSeleccionado();
		int posicion = this.almacenamiento.posicionLibroISBN(isbn);
		if (cantidad >= 0) {
			if (posicion != -1) {
				Libro libro = this.almacenamiento.obtenerLibro(posicion);
				int ejemplares = libro.getEjemplares();
				if (ejemplares - cantidad >= 0) {
					this.almacenamiento.vender(posicion, cantidad);
					this.paraUI.mcv.setVisible(false);
				} else {
					this.aviso.error("No hay existencias.", "Error de venta");
				}
			}
		} else {
			this.aviso.error("Cantidad inválida", "Error");
		}
		this.paraUI.actualizarLista();
	}
}
