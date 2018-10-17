package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
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

public class UI_old extends JFrame {

	protected JPanel contentPane;
	protected JTextField txtTitulo;
	protected JTextField txtAutor;
	protected JTextField txtIsbn;
	protected JTextField txtPaginas;
	protected final ButtonGroup buttonGroup = new ButtonGroup();
	protected final ButtonGroup buttonGroup_1 = new ButtonGroup();
	protected JTable table;
	protected JComboBox comboTema;
	protected JCheckBox chkCartone;
	protected JCheckBox chkRustica;
	protected JCheckBox chkTapaDura;
	protected JRadioButton radialNovedad;
	protected JRadioButton radialReedicion;
	protected JButton btnAlta;
	protected JButton btnBaja;
	protected JButton btnNuevo;
	protected JLabel lblEjemplares;
	protected JTextField txtEjemplares;
	protected JButton btnModificar;
	private JScrollPane scrollPane;
	private JMenuBar menuBar;
	private JMenu mnAltas;
	private JMenu mnBajas;
	private JMenu mnModificar;
	private JMenu mnSAL;

	/**
	 * Create the frame.
	 */
	public UI_old() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 860, 450);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnAltas = new JMenu("Altas");
		menuBar.add(mnAltas);
		
		mnBajas = new JMenu("Bajas");
		menuBar.add(mnBajas);
		
		mnModificar = new JMenu("Modificar");
		menuBar.add(mnModificar);
		
		mnSAL = new JMenu("S   A   L   I   R");
		menuBar.add(mnSAL);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.setBackground(new Color(204, 204, 204));
		contentPane.setBorder(new EmptyBorder(15, 15, 15, 15));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 266, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
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
		gbl_panelDatos.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panelDatos.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panelDatos.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panelDatos.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
		
		JLabel lblTema = new JLabel("Tema");
		lblTema.setForeground(new Color(0, 0, 0));
		lblTema.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblTema = new GridBagConstraints();
		gbc_lblTema.anchor = GridBagConstraints.WEST;
		gbc_lblTema.insets = new Insets(0, 0, 5, 5);
		gbc_lblTema.gridx = 1;
		gbc_lblTema.gridy = 3;
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
		gbc_comboBox.gridy = 3;
		panelDatos.add(comboTema, gbc_comboBox);
		comboTema.setModel(new DefaultComboBoxModel(Temas.values()));
		
		JLabel lblPginas = new JLabel("P\u00E1ginas");
		lblPginas.setForeground(new Color(0, 0, 0));
		lblPginas.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblPginas = new GridBagConstraints();
		gbc_lblPginas.anchor = GridBagConstraints.WEST;
		gbc_lblPginas.insets = new Insets(0, 0, 5, 5);
		gbc_lblPginas.gridx = 1;
		gbc_lblPginas.gridy = 4;
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
		gbc_txtPaginas.gridy = 4;
		panelDatos.add(txtPaginas, gbc_txtPaginas);
		txtPaginas.setColumns(10);
		
		lblEjemplares = new JLabel("Ejemplares");
		lblEjemplares.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblEjemplares = new GridBagConstraints();
		gbc_lblEjemplares.anchor = GridBagConstraints.EAST;
		gbc_lblEjemplares.insets = new Insets(0, 0, 0, 5);
		gbc_lblEjemplares.gridx = 1;
		gbc_lblEjemplares.gridy = 5;
		panelDatos.add(lblEjemplares, gbc_lblEjemplares);
		
		txtEjemplares = new JTextField();
		txtEjemplares.setBorder(null);
		txtEjemplares.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc_textField.insets = new Insets(0, 0, 0, 5);
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 5;
		panelDatos.add(txtEjemplares, gbc_textField);
		txtEjemplares.setColumns(10);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridheight = 4;
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
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		panel_1.setBackground(new Color(204, 153, 0));
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Formato", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 0, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 0;
		panel.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		chkCartone = new JCheckBox("Carton\u00E9");
		chkCartone.setForeground(new Color(0, 0, 0));
		chkCartone.setOpaque(false);
		chkCartone.setFont(new Font("Tahoma", Font.BOLD, 16));
		chkCartone.setBackground(new Color(102, 153, 153));
		GridBagConstraints gbc_chkCartone = new GridBagConstraints();
		gbc_chkCartone.anchor = GridBagConstraints.WEST;
		gbc_chkCartone.insets = new Insets(0, 0, 5, 0);
		gbc_chkCartone.gridx = 0;
		gbc_chkCartone.gridy = 0;
		panel_1.add(chkCartone, gbc_chkCartone);
		
		chkRustica = new JCheckBox("R\u00FAstica");
		chkRustica.setForeground(new Color(0, 0, 0));
		chkRustica.setOpaque(false);
		chkRustica.setFont(new Font("Tahoma", Font.BOLD, 16));
		chkRustica.setBackground(new Color(102, 153, 153));
		GridBagConstraints gbc_chkRustica = new GridBagConstraints();
		gbc_chkRustica.anchor = GridBagConstraints.WEST;
		gbc_chkRustica.insets = new Insets(0, 0, 5, 0);
		gbc_chkRustica.gridx = 0;
		gbc_chkRustica.gridy = 1;
		panel_1.add(chkRustica, gbc_chkRustica);
		
		chkTapaDura = new JCheckBox("Tapa dura");
		chkTapaDura.setForeground(new Color(0, 0, 0));
		chkTapaDura.setOpaque(false);
		chkTapaDura.setFont(new Font("Tahoma", Font.BOLD, 16));
		chkTapaDura.setBackground(new Color(102, 153, 153));
		GridBagConstraints gbc_chkTapaDura = new GridBagConstraints();
		gbc_chkTapaDura.anchor = GridBagConstraints.WEST;
		gbc_chkTapaDura.gridx = 0;
		gbc_chkTapaDura.gridy = 2;
		panel_1.add(chkTapaDura, gbc_chkTapaDura);
		
		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		panel_2.setBackground(new Color(204, 153, 0));
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Estado", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 0, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 3;
		gbc_panel_2.gridy = 0;
		panel.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
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
		
		JPanel panel_3 = new JPanel();
		panel_3.setOpaque(false);
		panel_3.setBackground(new Color(102, 153, 153));
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 5, 5);
		gbc_panel_3.fill = GridBagConstraints.VERTICAL;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 3;
		contentPane.add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel_3.rowHeights = new int[]{0, 0};
		gbl_panel_3.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		btnAlta = new JButton("Alta");
		btnAlta.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnAlta.setForeground(new Color(0, 0, 0));
		btnAlta.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnAlta.setBackground(new Color(0, 0, 0));
		btnAlta.setOpaque(false);
		GridBagConstraints gbc_btnAlta = new GridBagConstraints();
		gbc_btnAlta.insets = new Insets(0, 0, 0, 5);
		gbc_btnAlta.gridx = 0;
		gbc_btnAlta.gridy = 0;
		panel_3.add(btnAlta, gbc_btnAlta);
		
		btnBaja = new JButton("Baja");
		btnBaja.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnBaja.setForeground(new Color(0, 0, 0));
		btnBaja.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnBaja.setBackground(new Color(0, 0, 0));
		btnBaja.setOpaque(false);
		GridBagConstraints gbc_btnBaja = new GridBagConstraints();
		gbc_btnBaja.insets = new Insets(0, 0, 0, 5);
		gbc_btnBaja.gridx = 1;
		gbc_btnBaja.gridy = 0;
		panel_3.add(btnBaja, gbc_btnBaja);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNuevo.setForeground(new Color(0, 0, 0));
		btnNuevo.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnNuevo.setBackground(new Color(0, 0, 0));
		btnNuevo.setOpaque(false);
		GridBagConstraints gbc_btnNuevo = new GridBagConstraints();
		gbc_btnNuevo.insets = new Insets(0, 0, 0, 5);
		gbc_btnNuevo.gridx = 2;
		gbc_btnNuevo.gridy = 0;
		panel_3.add(btnNuevo, gbc_btnNuevo);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setOpaque(false);
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnModificar.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagConstraints gbc_btnModificar = new GridBagConstraints();
		gbc_btnModificar.gridx = 3;
		gbc_btnModificar.gridy = 0;
		panel_3.add(btnModificar, gbc_btnModificar);
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

	public JCheckBox getChkCartone() {
		return chkCartone;
	}

	public JCheckBox getChkRustica() {
		return chkRustica;
	}

	public JCheckBox getChkTapaDura() {
		return chkTapaDura;
	}

	public JRadioButton getRadialNovedad() {
		return radialNovedad;
	}

	public JRadioButton getRadialReedicion() {
		return radialReedicion;
	}

	public JButton getBtnAlta() {
		return btnAlta;
	}

	public JButton getBtnBaja() {
		return btnBaja;
	}

	public JButton getBtnNuevo() {
		return btnNuevo;
	}
	
	public JButton getBtnModificar() {
		return btnModificar;
	}
	
	
}
