package controlador.eventos;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import controlador.ParaUI;
import modelo.Estanteria;
import modelo.Libro;

public class EventoISBN implements KeyListener {
	private Estanteria almacenamiento;
	private ParaUI paraUI;

	public EventoISBN(ParaUI paraUI, Estanteria almacenamiento) {
		this.paraUI = paraUI;
		this.almacenamiento = almacenamiento;
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		final int ISBN_LENGTH = 13;
		if (this.paraUI.getTxtIsbn().getText().length() == ISBN_LENGTH) {
			this.paraUI.getTxtIsbn().setForeground(Color.BLACK);
			int posicion = this.almacenamiento.posicionLibroISBN(this.paraUI.getTxtIsbn().getText());
			this.paraUI.limpiarPantalla();
			if (posicion != -1) {
				Libro libro = this.almacenamiento.obtenerLibro(posicion);
				this.paraUI.mostrarDatos(libro);
			}
		} else {
			this.paraUI.limpiarPantalla();
			this.paraUI.getTxtIsbn().setForeground(Color.RED);
		}

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
}
