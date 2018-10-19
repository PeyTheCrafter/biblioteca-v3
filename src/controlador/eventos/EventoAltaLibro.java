package controlador.eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controlador.ParaUI;
import modelo.Estanteria;
import modelo.Libro;
import utiles.GestorAvisos;
import utiles.Mensajes;
import utiles.Validador;

public class EventoAltaLibro implements ActionListener {
	private ParaUI paraUI;
	private GestorAvisos aviso;
	private Estanteria almacenamiento;

	public EventoAltaLibro(ParaUI paraUI, Estanteria almacenamiento) {
		super();
		this.paraUI = paraUI;
		this.almacenamiento = almacenamiento;
		this.aviso = new GestorAvisos(this.paraUI);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (Validador.validarISBN(this.paraUI.getTxtIsbn().getText())) {
			Libro libro = this.paraUI.recogerDatosLibro();
			boolean respuesta = this.almacenamiento.insertarLibro(libro);
			if (respuesta) {
				this.paraUI.insertarTable(libro);
				this.aviso.informacion(Mensajes.ExitoInsercion.toString(), "Información");
			} else {
				this.aviso.informacion(Mensajes.ErrorIsbnRepetido.toString(), "Error de ISBN");
			}
			this.paraUI.limpiarPantalla();
			this.paraUI.limpiarISBN();
		} else {
			aviso.error(Mensajes.ErrorIsbnInvalido.toString(), "Error de ISBN");
		}
	}
}
