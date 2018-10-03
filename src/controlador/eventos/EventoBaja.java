package controlador.eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controlador.ParaUI;
import utiles.GestorAvisos;

public class EventoBaja implements ActionListener {
	private ParaUI paraUI;
	private GestorAvisos aviso;

	public EventoBaja(ParaUI paraUI) {
		super();
		this.paraUI = paraUI;
		this.aviso = new GestorAvisos(this.paraUI);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String isbn = this.paraUI.getSeleccionado();
		int posicion = this.paraUI.getAlmacenamiento().posicionLibroISBN(isbn);
		if (!this.paraUI.getAlmacenamiento().borrarLibroPosicion(posicion)) {
			aviso.error("Error al borrar.", "Error de borrado");
		} else {
			aviso.informacion("Libro borrado.", "información");
		}
		this.paraUI.actualizarLista();
		this.paraUI.limpiarPantalla();
		this.paraUI.botones.btnBaja(false);
	}

}
