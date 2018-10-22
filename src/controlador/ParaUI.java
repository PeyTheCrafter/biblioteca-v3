package controlador;

import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import controlador.eventos.*;
import modelo.Estanteria;
import modelo.Libro;
import utiles.GestorUI;
import vista.ModalAnadirEjemplares;
import vista.ModalConfirmacionVenta;
import vista.UI_old;

public class ParaUI extends UI_old {
	private static ParaUI instance;
	private Estanteria almacenamiento = new Estanteria();
	public GestorUI botones = new GestorUI(this);

	private ParaUI() {
		super();
		this.table.setModel(this.getModel());
		this.crearModales();
		this.asignarEventos();
		this.actualizarLista();
	}

	private void crearModales() {
		this.mcv = new ModalConfirmacionVenta(this);
		this.mae = new ModalAnadirEjemplares(this);
	}

	/**
	 * Asigna los eventos de los componentes de la ventana.
	 */
	private void asignarEventos() {
		this.mntmNuevoLibro.addActionListener(new EventoAltaLibro(this, this.almacenamiento));
		this.mntmVenderEjemplar.addActionListener(new EventoMostrarModal(this.mcv, true));
		this.getMntmBorrarLibro().addActionListener(new EventoBajaLibro(this, almacenamiento));
		this.table.addMouseListener(new EventoTabla(this));
		this.mntmModificarEjemplar.addActionListener(new EventoModificacion(this, this.almacenamiento));
		this.txtIsbn.addKeyListener(new EventoISBN(this, this.almacenamiento));
		this.mcv.getBtnOk().addActionListener(new EventoVentaEjemplar(this, this.almacenamiento));
		this.mae.getBtnOk().addActionListener(new EventoAltaEjemplar(this, this.almacenamiento));
		this.mntmNuevoEjemplar.addActionListener(new EventoMostrarModal(this.mae, true));
	}
	
	private void mostrarModal(JFrame frame, boolean state) {
		frame.setVisible(state);
	}

	/**
	 * Vacía todos los datos de la pantalla.
	 */
	public void limpiarPantalla() {
		this.txtAutor.setText("");
		this.txtPaginas.setText("");
		this.txtTitulo.setText("");
		this.comboTema.setSelectedIndex(0);
		this.radioCartone.setSelected(false);
		this.radioRustica.setSelected(false);
		this.radioTapaDura.setSelected(false);
		this.buttonGroup.clearSelection();
		this.getTxtEjemplares().setText("");
		this.getTxtEditorial().setText("");
	}

	public void limpiarISBN() {
		this.txtIsbn.setText("");
	}

	public Libro recogerDatosLibro() {
		String titulo = this.getTxtTitulo().getText();
		String autor = this.getTxtAutor().getText();
		String editorial = this.getTxtEditorial().getText();
		int tema = this.getComboTema().getSelectedIndex();
		String paginas = this.getTxtPaginas().getText();
		String isbn = this.getTxtIsbn().getText();
		boolean cartone = this.getRadioCartone().isSelected();
		boolean rustico = this.getRadioRustica().isSelected();
		boolean tapaDura = this.getRadioTapaDura().isSelected();
		boolean espiral = this.getRadioEspiral().isSelected();
		boolean novedad = this.getRadialNovedad().isSelected();
		boolean reedicion = this.getRadialReedicion().isSelected();
		int ejemplares = Integer.parseInt(this.getTxtEjemplares().getText());

		return new Libro(titulo, autor, editorial, tema, paginas, isbn, cartone, rustico, tapaDura, espiral, novedad,
				reedicion, ejemplares);
	}

	/**
	 * Actualiza la lista de libros.
	 */
	public void actualizarLista() {
		this.table.setModel(this.getModel());
		for (int i = 0; i < this.getAlmacenamiento().getLibros().size(); i++) {
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
			Libro libro = this.almacenamiento.getLibros().get(posicion);
			mostrarDatos(libro);
		}
	}

	public void mostrarDatos(Libro libro) {
		this.txtTitulo.setText(libro.getTitulo());
		this.txtAutor.setText(libro.getAutor());
		this.comboTema.setSelectedIndex(libro.getTema());
		this.txtPaginas.setText(libro.getNumPaginas());
		this.txtIsbn.setText(libro.getIsbn());
		this.radioCartone.setSelected(libro.isCartone());
		this.radioRustica.setSelected(libro.isRustico());
		this.radioTapaDura.setSelected(libro.isTapaDura());
		this.getRadioEspiral().setSelected(libro.isEspiral());
		this.getRadialNovedad().setSelected(libro.isNovedad());
		this.getRadialReedicion().setSelected(libro.isReedicion());
		this.txtEjemplares.setText(String.valueOf(libro.getEjemplares()));
		this.txtEditorial.setText(libro.getEditorial());
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
		Object[] obj = { libro.getTitulo().toString(), libro.getIsbn().toString(),
				String.valueOf(libro.getEjemplares()) };
		return obj;
	}

	/**
	 * Método de la tabla.
	 * 
	 * @return un modelo vacío para la tabla.
	 */
	private TableModel getModel() {
		return new DefaultTableModel(new Object[][] {}, new String[] { "Titulo", "ISBN", "Ejemplares" }) {
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

	public static ParaUI getInstance() {
		if (instance == null) {
			instance = new ParaUI();
		}
		return instance;
	}
}
