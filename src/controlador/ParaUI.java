package controlador;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import controlador.eventos.*;
import modelo.Estanteria;
import modelo.Libro;
import utiles.GestorAvisos;
import utiles.GestorBotones;
import vista.UI;

public class ParaUI extends UI {
	private Estanteria almacenamiento;
	private static int TAMANO = 3;
	public GestorBotones botones = new GestorBotones(this);

	public ParaUI() {
		super();
		this.almacenamiento = new Estanteria(this.TAMANO);
		this.getTable().setModel(this.getModel());
		this.asignarEventos();
		this.botones.global(false);
	}

	/**
	 * Asigna los eventos de los componentes de la ventana.
	 */
	private void asignarEventos() {
		this.btnNuevo.addActionListener(new EventoNuevo(this));
		this.btnAlta.addActionListener(new EventoAlta(this));
		this.btnBaja.addActionListener(new EventoBaja(this));
		this.table.addMouseListener(new EventoTabla(this));
	}

	/**
	 * Vacía todos los datos de la pantalla.
	 */
	public void limpiarPantalla() {
		this.txtAutor.setText("");
		this.txtIsbn.setText("");
		this.txtPaginas.setText("");
		this.txtTitulo.setText("");
		this.comboTema.setSelectedIndex(0);
		this.chkCartone.setSelected(false);
		this.chkRustica.setSelected(false);
		this.chkTapaDura.setSelected(false);
		this.buttonGroup.clearSelection();
	}

	/**
	 * Actualiza la lista de libros.
	 */
	public void actualizarLista() {
		this.table.setModel(this.getModel());
		for (int i = 0; i < this.TAMANO; i++) {
			this.insertarTable(this.almacenamiento.obtenerLibro(i));
		}
	}

	/**
	 * Obtiene el isbn del libro seleccionado en la tabla.
	 * 
	 * @return el isbn.
	 */
	public String getSeleccionado() {
		String dato = "";
		int colIndex = 1;
		int[] rowIndex = this.table.getSelectedRows();
		for (int i : rowIndex) {
			dato = this.table.getModel().getValueAt(i, colIndex).toString();
		}
		return dato;
	}

	/**
	 * Muestra los datos del libro seleccionado en la tabla.
	 */
	public void mostrarDatos() {
		this.limpiarPantalla();
		String isbn = this.getSeleccionado();
		int posicion = this.almacenamiento.posicionLibroISBN(isbn);
		if (posicion != -1) {
			Libro libro = this.almacenamiento.getLibros()[posicion];
			this.txtTitulo.setText(libro.getTitulo());
			this.txtAutor.setText(libro.getAutor());
			this.comboTema.setSelectedIndex(libro.getTema());
			this.txtPaginas.setText(libro.getNumPaginas());
			this.txtIsbn.setText(libro.getIsbn());
			this.chkCartone.setSelected(libro.isCartone());
			this.chkRustica.setSelected(libro.isRustico());
			this.chkTapaDura.setSelected(libro.isTapaDura());
			if (libro.isNovedad()) {
				this.radialNovedad.setSelected(true);
			} else {
				this.radialReedicion.setSelected(true);
			}
		}
	}

	/*
	 * MÉTODOS DE TABLA.
	 */

	/**
	 * Método de la tabla. Inserta un libro en la tabla.
	 * 
	 * @param libro
	 *            el libro para extraer los datos e introducirlos en la tabla.
	 */
	public void insertarTable(Libro libro) {
		if (libro != null) {
			DefaultTableModel modelo = (DefaultTableModel) this.table.getModel();
			modelo.addRow(introducirRejilla(libro));
		}
	}

	/**
	 * Método de la tabla. Selecciona los datos del libro para introducirlos.
	 * 
	 * @param libro
	 *            libro del que se extraen los datos.
	 * @return los datos extraídos del libro.
	 */
	private Object[] introducirRejilla(Libro libro) {
		Object[] obj = { libro.getTitulo().toString(), libro.getIsbn().toString() };
		return obj;
	}

	/**
	 * Método de la tabla.
	 * 
	 * @return un modelo vacío para la tabla.
	 */
	private TableModel getModel() {
		return new DefaultTableModel(new Object[][] {}, new String[] { "Titulo", "ISBN" }) {
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] { false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
	}

	/*
	 * GETTERS / SETTERS
	 */

	public Estanteria getAlmacenamiento() {
		return this.almacenamiento;
	}
}
