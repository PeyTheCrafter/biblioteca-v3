package controlador;

import java.awt.Component;

import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

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
		this.actualizarLista();
		this.table.setModel(this.getModel());
	}

	private void asignarEventos() {
		this.btnNuevo.addActionListener(new EventoNuevo(this));
		this.btnAlta.addActionListener(new EventoAlta(this));
		this.btnBaja.addActionListener(new EventoBaja(this));
		this.table.addMouseListener(new EventoTabla(this));
	}

	public void limpiarPantalla() {
		this.txtAutor.setText("");
		this.txtISBN.setText("");
		this.txtPaginas.setText("");
		this.txtTitulo.setText("");
		this.chkCartone.setSelected(false);
		this.chkRustica.setSelected(false);
		this.chkTapaDura.setSelected(false);
		this.radialNovedad.setSelected(false);
		this.radialReedicion.setSelected(false);
	}

	private TableModel getModel() {
		return new DefaultTableModel(new Object[][] {}, new String[] { "Titulo", "Autor" }) {
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] { false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
	}

	public void actualizarLista() {
		this.table.setModel(this.getModel());
		for (int i = 0; i < this.TAMANO; i++) {
			this.insertarTable(this.almacenamiento.getLibros()[i]);
		}
	}

	private void insertarTable(Libro libro) {
		if (libro != null) {
			DefaultTableModel modelo = (DefaultTableModel) this.table.getModel();
			modelo.addRow(introducirRejilla(libro));
		}
	}

	private Object[] introducirRejilla(Libro libro) {
		Object[] obj = { libro.getTitulo().toString(), libro.getIsbn().toString() };
		return obj;
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
			this.txtPaginas.setText(libro.getNumPaginas());
			this.txtISBN.setText(libro.getIsbn());
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

	public void insertarLibro() {
		Libro libro = new Libro(this.txtTitulo.getText(), this.txtAutor.getText(), this.comboTema.getSelectedIndex(),
				this.txtPaginas.getText(), this.txtISBN.getText(), this.chkCartone.isSelected(),
				this.chkRustica.isSelected(), this.chkTapaDura.isSelected(), this.radialNovedad.isSelected());
		boolean respuesta = this.almacenamiento.insertarLibro(libro);
		if (!respuesta) {
			System.out.println("Error al añadir libro.");
		} else {
			this.insertarTable(libro);
		}
	}

	public void borrarLibro() {
		String isbn = this.getSeleccionado();
		int posicion = this.almacenamiento.posicionLibroISBN(isbn);
		this.almacenamiento.borrarLibroPosicion(posicion);
		this.actualizarLista();
		this.limpiarPantalla();
	}

	public Estanteria getAlmacenamiento() {
		return this.almacenamiento;
	}
}
