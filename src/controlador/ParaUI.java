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

	// TODO: gestionar combobox, radial y checkbox.
	public void limpiarPantalla() {
		this.txtAutor.setText("");
		this.txtISBN.setText("");
		this.txtPaginas.setText("");
		this.txtTitulo.setText("");
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

	}

	private void insertarTable(Libro libro) {
		// this.table.setModel(this.prepararTabla());
		DefaultTableModel modelo = (DefaultTableModel) this.table.getModel();
		modelo.addRow(introducirRejilla(libro));
	}

	protected Object[] introducirRejilla(Libro libro) {
		Object[] obj = { libro.getTitulo().toString(), libro.getAutor().toString() };
		return obj;
	}

	public String obtenerDatos() {
		String titulo = "";
		int colIndex = 0;
		int[] rowIndex = this.table.getSelectedRows();
		for (int i : rowIndex) {
			titulo = this.table.getModel().getValueAt(i, colIndex).toString();
		}
		System.out.println(titulo);
		return titulo;
	}

	public void insertarLibro() {
		Libro libro = new Libro(this.txtTitulo.getText(), this.txtAutor.getText(), "", this.txtPaginas.getText(),
				this.txtISBN.getText(), "", "", "", "", "");
		boolean respuesta = this.almacenamiento.insertarLibro(libro);
		if (!respuesta) {
			System.out.println("Error al añadir libro.");
		} else {
			this.insertarTable(libro);
		}
	}

	public Estanteria getAlmacenamiento() {
		return this.almacenamiento;
	}
}
