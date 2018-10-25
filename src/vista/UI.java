package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.MenuBar;

import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import modelo.Temas;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class UI extends JFrame {

	protected JPanel contentPane;
	protected JTextField txtTitulo;
	protected JTextField txtAutor;
	protected JTextField txtIsbn;
	protected JTextField txtPaginas;
	protected final ButtonGroup buttonGroup = new ButtonGroup();
	protected final ButtonGroup buttonGroup_1 = new ButtonGroup();
	protected JTable table;
	protected JComboBox comboTema;
	protected JRadioButton radioCartone;
	protected JRadioButton radioRustica;
	protected JRadioButton radioTapaDura;
	protected JRadioButton radialNovedad;
	protected JRadioButton radialReedicion;
	protected JLabel lblEjemplares;
	protected JTextField txtEjemplares;
	protected JScrollPane scrollPane;
	protected JMenuBar menuBar;
	protected JMenu mnAltas;
	protected JMenu mnBajas;
	protected JMenu mnModificar;
	protected JMenuItem mntmNuevoEjemplar;
	protected JMenuItem mntmNuevoLibro;
	protected JMenuItem mntmModificarEjemplar;
	protected JMenuItem mntmVenderEjemplar;
	protected JMenuItem mntmBorrarLibro;
	protected JLabel lblEditorial;
	protected JTextField txtEditorial;
	protected GridBagConstraints gbc_txtEditorial;
	private JRadioButton radioEspiral;
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	public ModalConfirmacionVenta mcv;
	public ModalAnadirEjemplares mae;

	/**
	 * Create the frame.
	 */
	public UI() {		
		
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
					| UnsupportedLookAndFeelException e) {
				e.printStackTrace();
			}
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 860, 450);
		setVisible(true);
		setLocationRelativeTo(null);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnAltas = new JMenu("Altas");
		menuBar.add(mnAltas);

		mntmNuevoEjemplar = new JMenuItem("A\u00F1adir ejemplares");
		mnAltas.add(mntmNuevoEjemplar);

		mntmNuevoLibro = new JMenuItem("Nuevo libro");
		mnAltas.add(mntmNuevoLibro);

		mnBajas = new JMenu("Bajas");
		menuBar.add(mnBajas);

		mntmVenderEjemplar = new JMenuItem("Vender ejemplar");
		mnBajas.add(mntmVenderEjemplar);

		mntmBorrarLibro = new JMenuItem("Borrar Libro");
		mnBajas.add(mntmBorrarLibro);

		mnModificar = new JMenu("Modificar");
		menuBar.add(mnModificar);

		mntmModificarEjemplar = new JMenuItem("Modificar Ejemplar");
		mnModificar.add(mntmModificarEjemplar);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.setBackground(new Color(204, 204, 204));
		contentPane.setBorder(new EmptyBorder(15, 15, 15, 15));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 266, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JPanel panelDatos = new JPanel();
		panelDatos.setOpaque(false);
		panelDatos.setBackground(new Color(204, 153, 0));
		panelDatos.setForeground(new Color(0, 0, 0));
		GridBagConstraints gbc_panelDatos = new GridBagConstraints();
		gbc_panelDatos.insets = new Insets(0, 0, 5, 5);
		gbc_panelDatos.fill = GridBagConstraints.BOTH;
		gbc_panelDatos.gridx = 0;
		gbc_panelDatos.gridy = 1;
		contentPane.add(panelDatos, gbc_panelDatos);
		GridBagLayout gbl_panelDatos = new GridBagLayout();
		gbl_panelDatos.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gbl_panelDatos.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panelDatos.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_panelDatos.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panelDatos.setLayout(gbl_panelDatos);

		JLabel lblIsbn = new JLabel("ISBN");
		lblIsbn.setForeground(new Color(0, 0, 0));
		lblIsbn.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblIsbn = new GridBagConstraints();
		gbc_lblIsbn.anchor = GridBagConstraints.WEST;
		gbc_lblIsbn.insets = new Insets(0, 0, 5, 5);
		gbc_lblIsbn.gridx = 1;
		gbc_lblIsbn.gridy = 0;
		panelDatos.add(lblIsbn, gbc_lblIsbn);

		txtIsbn = new JTextField();
		txtIsbn.setDisabledTextColor(new Color(0, 0, 0));
		txtIsbn.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtIsbn.setForeground(new Color(0, 0, 0));
		txtIsbn.setBorder(new LineBorder(new Color(255, 255, 255)));
		txtIsbn.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_txtIsbn = new GridBagConstraints();
		gbc_txtIsbn.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtIsbn.insets = new Insets(0, 0, 5, 5);
		gbc_txtIsbn.gridx = 2;
		gbc_txtIsbn.gridy = 0;
		panelDatos.add(txtIsbn, gbc_txtIsbn);
		txtIsbn.setColumns(10);

		JLabel lblTtulo = new JLabel("T\u00EDtulo");
		lblTtulo.setForeground(new Color(0, 0, 0));
		lblTtulo.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblTtulo = new GridBagConstraints();
		gbc_lblTtulo.anchor = GridBagConstraints.WEST;
		gbc_lblTtulo.insets = new Insets(0, 0, 5, 5);
		gbc_lblTtulo.gridx = 1;
		gbc_lblTtulo.gridy = 1;
		panelDatos.add(lblTtulo, gbc_lblTtulo);

		txtTitulo = new JTextField();
		txtTitulo.setDisabledTextColor(new Color(0, 0, 0));
		txtTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtTitulo.setForeground(new Color(0, 0, 0));
		txtTitulo.setBorder(new LineBorder(new Color(255, 255, 255)));
		txtTitulo.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_txtTitulo = new GridBagConstraints();
		gbc_txtTitulo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTitulo.insets = new Insets(0, 0, 5, 5);
		gbc_txtTitulo.gridx = 2;
		gbc_txtTitulo.gridy = 1;
		panelDatos.add(txtTitulo, gbc_txtTitulo);
		txtTitulo.setColumns(10);

		JLabel lblAutor = new JLabel("Autor");
		lblAutor.setForeground(new Color(0, 0, 0));
		lblAutor.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblAutor = new GridBagConstraints();
		gbc_lblAutor.anchor = GridBagConstraints.WEST;
		gbc_lblAutor.insets = new Insets(0, 0, 5, 5);
		gbc_lblAutor.gridx = 1;
		gbc_lblAutor.gridy = 2;
		panelDatos.add(lblAutor, gbc_lblAutor);

		txtAutor = new JTextField();
		txtAutor.setDisabledTextColor(new Color(0, 0, 0));
		txtAutor.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtAutor.setForeground(new Color(0, 0, 0));
		txtAutor.setBorder(new LineBorder(new Color(255, 255, 255)));
		txtAutor.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_txtAUtor = new GridBagConstraints();
		gbc_txtAUtor.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAUtor.insets = new Insets(0, 0, 5, 5);
		gbc_txtAUtor.gridx = 2;
		gbc_txtAUtor.gridy = 2;
		panelDatos.add(txtAutor, gbc_txtAUtor);
		txtAutor.setColumns(10);

		lblEditorial = new JLabel("Editorial");
		lblEditorial.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblEditorial = new GridBagConstraints();
		gbc_lblEditorial.anchor = GridBagConstraints.WEST;
		gbc_lblEditorial.insets = new Insets(0, 0, 5, 5);
		gbc_lblEditorial.gridx = 1;
		gbc_lblEditorial.gridy = 3;
		panelDatos.add(lblEditorial, gbc_lblEditorial);

		txtEditorial = new JTextField();
		txtEditorial.setBorder(null);
		txtEditorial.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_textField;
		gbc_txtEditorial = new GridBagConstraints();
		gbc_txtEditorial.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEditorial.insets = new Insets(0, 0, 5, 5);
		gbc_txtEditorial.gridx = 2;
		gbc_txtEditorial.gridy = 3;
		panelDatos.add(txtEditorial, gbc_txtEditorial);
		txtEditorial.setColumns(10);

		JLabel lblTema = new JLabel("Tema");
		lblTema.setForeground(new Color(0, 0, 0));
		lblTema.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblTema = new GridBagConstraints();
		gbc_lblTema.anchor = GridBagConstraints.WEST;
		gbc_lblTema.insets = new Insets(0, 0, 5, 5);
		gbc_lblTema.gridx = 1;
		gbc_lblTema.gridy = 4;
		panelDatos.add(lblTema, gbc_lblTema);

		comboTema = new JComboBox();
		comboTema.setFont(new Font("Tahoma", Font.BOLD, 16));
		comboTema.setForeground(new Color(0, 0, 0));
		comboTema.setBorder(null);
		comboTema.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 4;
		panelDatos.add(comboTema, gbc_comboBox);
		comboTema.setModel(new DefaultComboBoxModel(Temas.values()));

		JLabel lblPginas = new JLabel("P\u00E1ginas");
		lblPginas.setForeground(new Color(0, 0, 0));
		lblPginas.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblPginas = new GridBagConstraints();
		gbc_lblPginas.anchor = GridBagConstraints.WEST;
		gbc_lblPginas.insets = new Insets(0, 0, 5, 5);
		gbc_lblPginas.gridx = 1;
		gbc_lblPginas.gridy = 5;
		panelDatos.add(lblPginas, gbc_lblPginas);

		txtPaginas = new JTextField();
		txtPaginas.setDisabledTextColor(new Color(0, 0, 0));
		txtPaginas.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtPaginas.setForeground(new Color(0, 0, 0));
		txtPaginas.setBorder(new LineBorder(new Color(255, 255, 255)));
		txtPaginas.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_txtPaginas = new GridBagConstraints();
		gbc_txtPaginas.anchor = GridBagConstraints.WEST;
		gbc_txtPaginas.insets = new Insets(0, 0, 5, 5);
		gbc_txtPaginas.gridx = 2;
		gbc_txtPaginas.gridy = 5;
		panelDatos.add(txtPaginas, gbc_txtPaginas);
		txtPaginas.setColumns(10);

		lblEjemplares = new JLabel("Ejemplares");
		lblEjemplares.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblEjemplares = new GridBagConstraints();
		gbc_lblEjemplares.anchor = GridBagConstraints.EAST;
		gbc_lblEjemplares.insets = new Insets(0, 0, 0, 5);
		gbc_lblEjemplares.gridx = 1;
		gbc_lblEjemplares.gridy = 6;
		panelDatos.add(lblEjemplares, gbc_lblEjemplares);

		txtEjemplares = new JTextField();
		txtEjemplares.setBorder(null);
		txtEjemplares.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_txtEditorial = new GridBagConstraints();
		gbc_txtEditorial.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc_txtEditorial.insets = new Insets(0, 0, 0, 5);
		gbc_txtEditorial.gridx = 2;
		gbc_txtEditorial.gridy = 6;
		panelDatos.add(txtEjemplares, gbc_txtEditorial);
		txtEjemplares.setColumns(10);

		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 2;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 1;
		contentPane.add(scrollPane, gbc_scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setOpaque(false);
		table.setFont(new Font("Tahoma", Font.BOLD, 16));
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setBackground(new Color(255, 255, 255));
		table.setForeground(new Color(0, 0, 0));

		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBackground(new Color(102, 153, 153));
		panel.setForeground(new Color(0, 0, 0));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 2;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		panel_1.setBackground(new Color(204, 153, 0));
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Formato", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 0, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 0;
		panel.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		radioCartone = new JRadioButton("Carton\u00E9");
		buttonGroup_2.add(radioCartone);
		radioCartone.setForeground(new Color(0, 0, 0));
		radioCartone.setOpaque(false);
		radioCartone.setFont(new Font("Tahoma", Font.BOLD, 16));
		radioCartone.setBackground(new Color(102, 153, 153));
		GridBagConstraints gbc_chkCartone = new GridBagConstraints();
		gbc_chkCartone.anchor = GridBagConstraints.WEST;
		gbc_chkCartone.insets = new Insets(0, 0, 5, 0);
		gbc_chkCartone.gridx = 0;
		gbc_chkCartone.gridy = 0;
		panel_1.add(radioCartone, gbc_chkCartone);

		radioRustica = new JRadioButton("R\u00FAstica");
		buttonGroup_2.add(radioRustica);
		radioRustica.setForeground(new Color(0, 0, 0));
		radioRustica.setOpaque(false);
		radioRustica.setFont(new Font("Tahoma", Font.BOLD, 16));
		radioRustica.setBackground(new Color(102, 153, 153));
		GridBagConstraints gbc_chkRustica = new GridBagConstraints();
		gbc_chkRustica.anchor = GridBagConstraints.WEST;
		gbc_chkRustica.insets = new Insets(0, 0, 5, 0);
		gbc_chkRustica.gridx = 0;
		gbc_chkRustica.gridy = 1;
		panel_1.add(radioRustica, gbc_chkRustica);

		radioTapaDura = new JRadioButton("Tapa dura");
		buttonGroup_2.add(radioTapaDura);
		radioTapaDura.setForeground(new Color(0, 0, 0));
		radioTapaDura.setOpaque(false);
		radioTapaDura.setFont(new Font("Tahoma", Font.BOLD, 16));
		radioTapaDura.setBackground(new Color(102, 153, 153));
		GridBagConstraints gbc_chkTapaDura = new GridBagConstraints();
		gbc_chkTapaDura.insets = new Insets(0, 0, 5, 0);
		gbc_chkTapaDura.anchor = GridBagConstraints.WEST;
		gbc_chkTapaDura.gridx = 0;
		gbc_chkTapaDura.gridy = 2;
		panel_1.add(radioTapaDura, gbc_chkTapaDura);

		radioEspiral = new JRadioButton("Espiral");
		buttonGroup_2.add(radioEspiral);
		radioEspiral.setFont(new Font("Tahoma", Font.BOLD, 16));
		radioEspiral.setOpaque(false);
		GridBagConstraints gbc_chkEspiral = new GridBagConstraints();
		gbc_chkEspiral.anchor = GridBagConstraints.WEST;
		gbc_chkEspiral.gridx = 0;
		gbc_chkEspiral.gridy = 3;
		panel_1.add(radioEspiral, gbc_chkEspiral);

		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		panel_2.setBackground(new Color(204, 153, 0));
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Estado", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 0, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 3;
		gbc_panel_2.gridy = 0;
		panel.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] { 0, 0 };
		gbl_panel_2.rowHeights = new int[] { 0, 0, 0 };
		gbl_panel_2.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_panel_2.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panel_2.setLayout(gbl_panel_2);

		radialNovedad = new JRadioButton("Novedad");
		radialNovedad.setForeground(new Color(0, 0, 0));
		radialNovedad.setOpaque(false);
		radialNovedad.setFont(new Font("Tahoma", Font.BOLD, 16));
		radialNovedad.setBackground(new Color(102, 153, 153));
		buttonGroup_1.add(radialNovedad);
		GridBagConstraints gbc_radialNovedad = new GridBagConstraints();
		gbc_radialNovedad.anchor = GridBagConstraints.WEST;
		gbc_radialNovedad.insets = new Insets(0, 0, 5, 0);
		gbc_radialNovedad.gridx = 0;
		gbc_radialNovedad.gridy = 0;
		panel_2.add(radialNovedad, gbc_radialNovedad);

		radialReedicion = new JRadioButton("Reedici\u00F3n");
		radialReedicion.setForeground(new Color(0, 0, 0));
		radialReedicion.setOpaque(false);
		radialReedicion.setFont(new Font("Tahoma", Font.BOLD, 16));
		radialReedicion.setBackground(new Color(102, 153, 153));
		buttonGroup_1.add(radialReedicion);
		GridBagConstraints gbc_radialReedicion = new GridBagConstraints();
		gbc_radialReedicion.anchor = GridBagConstraints.WEST;
		gbc_radialReedicion.gridx = 0;
		gbc_radialReedicion.gridy = 1;
		panel_2.add(radialReedicion, gbc_radialReedicion);
	}

	public JTextField getTxtTitulo() {
		return txtTitulo;
	}

	public JTextField getTxtAutor() {
		return txtAutor;
	}

	public JTextField getTxtIsbn() {
		return txtIsbn;
	}

	public JTextField getTxtPaginas() {
		return txtPaginas;
	}

	public JTextField getTxtEjemplares() {
		return this.txtEjemplares;
	}

	public JTable getTable() {
		return table;
	}

	public JComboBox getComboTema() {
		return comboTema;
	}

	public JRadioButton getRadialNovedad() {
		return radialNovedad;
	}

	public JRadioButton getRadialReedicion() {
		return radialReedicion;
	}

	public JMenu getMnAltas() {
		return mnAltas;
	}

	public JMenu getMnBajas() {
		return mnBajas;
	}

	public JMenu getMnModificar() {
		return mnModificar;
	}

	public JMenuItem getMntmNuevoEjemplar() {
		return mntmNuevoEjemplar;
	}

	public JMenuItem getMntmNuevoLibro() {
		return mntmNuevoLibro;
	}

	public JMenuItem getMntmModificarEjemplar() {
		return mntmModificarEjemplar;
	}

	public JMenuItem getMntmVenderEjemplar() {
		return mntmVenderEjemplar;
	}

	public JMenuItem getMntmBorrarLibro() {
		return mntmBorrarLibro;
	}

	public JRadioButton getRadioCartone() {
		return radioCartone;
	}

	public JRadioButton getRadioRustica() {
		return radioRustica;
	}

	public JRadioButton getRadioTapaDura() {
		return radioTapaDura;
	}

	public JTextField getTxtEditorial() {
		return txtEditorial;
	}

	public JRadioButton getRadioEspiral() {
		return radioEspiral;
	}
}
