package vista;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Panel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import modelo.Temas;

public class UI extends JFrame {

	protected JPanel contentPane;
	protected JTextField txtTitulo;
	protected JTextField txtAutor;
	protected JTextField txtPaginas;
	protected JTextField txtISBN;
	protected JButton btnNuevo;
	protected JButton btnAlta;
	protected JButton btnBaja;
	protected JCheckBox chkCartone;
	protected JCheckBox chkRustica;
	protected JCheckBox chkTapaDura;
	protected JRadioButton radialNovedad;
	protected JRadioButton radialReedicion;
	protected JTable listaLibros;
	protected JTable table;
	protected JScrollPane scrollPane;
	protected final ButtonGroup buttonGroup = new ButtonGroup();
	protected Panel panelPrincipal;
	protected JPanel panelDatos;
	protected JLabel lblLibreriaTitulo;
	protected JPanel panelBotones;
	protected JPanel panelFormato;
	protected JPanel panelEstado;
	protected JComboBox<Temas> comboTema;

	/**
	 * Create the frame.
	 */
	public UI() {
//		try {
//			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
//				| UnsupportedLookAndFeelException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 455, 589);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 102, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		lblLibreriaTitulo = new JLabel("Librer\u00EDa");
		lblLibreriaTitulo.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 26));
		lblLibreriaTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblLibreriaTitulo, BorderLayout.NORTH);

		panelPrincipal = new Panel();
		contentPane.add(panelPrincipal, BorderLayout.CENTER);
		GridBagLayout gbl_panelPrincipal = new GridBagLayout();
		gbl_panelPrincipal.columnWidths = new int[] { 30, 0, 100, 0, 0, 30, 0 };
		gbl_panelPrincipal.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_panelPrincipal.columnWeights = new double[] { 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panelPrincipal.rowWeights = new double[] { 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		panelPrincipal.setLayout(gbl_panelPrincipal);

		panelDatos = new JPanel();
		panelDatos.setBackground(new Color(51, 102, 102));
		GridBagConstraints gbc_panelDatos = new GridBagConstraints();
		gbc_panelDatos.gridwidth = 3;
		gbc_panelDatos.insets = new Insets(0, 0, 5, 5);
		gbc_panelDatos.fill = GridBagConstraints.BOTH;
		gbc_panelDatos.gridx = 1;
		gbc_panelDatos.gridy = 0;
		panelPrincipal.add(panelDatos, gbc_panelDatos);
		GridBagLayout gbl_panelDatos = new GridBagLayout();
		gbl_panelDatos.columnWidths = new int[] { 0, 0, 0 };
		gbl_panelDatos.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_panelDatos.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_panelDatos.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panelDatos.setLayout(gbl_panelDatos);

		JLabel lblTtulo = new JLabel("T\u00EDtulo");
		GridBagConstraints gbc_lblTtulo = new GridBagConstraints();
		gbc_lblTtulo.anchor = GridBagConstraints.EAST;
		gbc_lblTtulo.insets = new Insets(0, 0, 5, 5);
		gbc_lblTtulo.gridx = 0;
		gbc_lblTtulo.gridy = 0;
		panelDatos.add(lblTtulo, gbc_lblTtulo);

		txtTitulo = new JTextField();
		txtTitulo.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_txtTitulo = new GridBagConstraints();
		gbc_txtTitulo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTitulo.insets = new Insets(0, 0, 5, 0);
		gbc_txtTitulo.gridx = 1;
		gbc_txtTitulo.gridy = 0;
		panelDatos.add(txtTitulo, gbc_txtTitulo);
		txtTitulo.setColumns(10);

		JLabel lblAutor = new JLabel("Autor");
		GridBagConstraints gbc_lblAutor = new GridBagConstraints();
		gbc_lblAutor.anchor = GridBagConstraints.EAST;
		gbc_lblAutor.insets = new Insets(0, 0, 5, 5);
		gbc_lblAutor.gridx = 0;
		gbc_lblAutor.gridy = 1;
		panelDatos.add(lblAutor, gbc_lblAutor);

		txtAutor = new JTextField();
		txtAutor.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_txtAutor = new GridBagConstraints();
		gbc_txtAutor.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAutor.insets = new Insets(0, 0, 5, 0);
		gbc_txtAutor.gridx = 1;
		gbc_txtAutor.gridy = 1;
		panelDatos.add(txtAutor, gbc_txtAutor);
		txtAutor.setColumns(10);

		JLabel lblTema = new JLabel("Tema");
		GridBagConstraints gbc_lblTema = new GridBagConstraints();
		gbc_lblTema.anchor = GridBagConstraints.EAST;
		gbc_lblTema.insets = new Insets(0, 0, 5, 5);
		gbc_lblTema.gridx = 0;
		gbc_lblTema.gridy = 2;
		panelDatos.add(lblTema, gbc_lblTema);
		
		comboTema = new JComboBox();
		comboTema.setModel(new DefaultComboBoxModel(Temas.values()));
		GridBagConstraints gbc_comboTema = new GridBagConstraints();
		gbc_comboTema.insets = new Insets(0, 0, 5, 0);
		gbc_comboTema.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboTema.gridx = 1;
		gbc_comboTema.gridy = 2;
		panelDatos.add(comboTema, gbc_comboTema);

		JLabel lblPginas = new JLabel("P\u00E1ginas");
		GridBagConstraints gbc_lblPginas = new GridBagConstraints();
		gbc_lblPginas.anchor = GridBagConstraints.EAST;
		gbc_lblPginas.insets = new Insets(0, 0, 5, 5);
		gbc_lblPginas.gridx = 0;
		gbc_lblPginas.gridy = 3;
		panelDatos.add(lblPginas, gbc_lblPginas);

		txtPaginas = new JTextField();
		txtPaginas.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_txtPaginas = new GridBagConstraints();
		gbc_txtPaginas.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPaginas.insets = new Insets(0, 0, 5, 0);
		gbc_txtPaginas.gridx = 1;
		gbc_txtPaginas.gridy = 3;
		panelDatos.add(txtPaginas, gbc_txtPaginas);
		txtPaginas.setColumns(10);

		JLabel lblIsbn = new JLabel("ISBN");
		GridBagConstraints gbc_lblIsbn = new GridBagConstraints();
		gbc_lblIsbn.anchor = GridBagConstraints.EAST;
		gbc_lblIsbn.insets = new Insets(0, 0, 0, 5);
		gbc_lblIsbn.gridx = 0;
		gbc_lblIsbn.gridy = 4;
		panelDatos.add(lblIsbn, gbc_lblIsbn);

		txtISBN = new JTextField();
		txtISBN.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_txtISBN = new GridBagConstraints();
		gbc_txtISBN.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtISBN.gridx = 1;
		gbc_txtISBN.gridy = 4;
		panelDatos.add(txtISBN, gbc_txtISBN);
		txtISBN.setColumns(10);

		panelBotones = new JPanel();
		panelBotones.setBackground(new Color(51, 102, 102));
		GridBagConstraints gbc_panelBotones = new GridBagConstraints();
		gbc_panelBotones.insets = new Insets(0, 0, 5, 5);
		gbc_panelBotones.fill = GridBagConstraints.BOTH;
		gbc_panelBotones.gridx = 4;
		gbc_panelBotones.gridy = 0;
		panelPrincipal.add(panelBotones, gbc_panelBotones);
		GridBagLayout gbl_panelBotones = new GridBagLayout();
		gbl_panelBotones.columnWidths = new int[] { 0, 0, 0 };
		gbl_panelBotones.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_panelBotones.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gbl_panelBotones.rowWeights = new double[] { 1.0, 1.0, 1.0, Double.MIN_VALUE };
		panelBotones.setLayout(gbl_panelBotones);

		btnNuevo = new JButton("Nuevo");
		GridBagConstraints gbc_btnNuevo = new GridBagConstraints();
		gbc_btnNuevo.fill = GridBagConstraints.BOTH;
		gbc_btnNuevo.insets = new Insets(0, 0, 5, 0);
		gbc_btnNuevo.gridx = 1;
		gbc_btnNuevo.gridy = 0;
		panelBotones.add(btnNuevo, gbc_btnNuevo);

		btnAlta = new JButton("Alta");
		GridBagConstraints gbc_btnAlta = new GridBagConstraints();
		gbc_btnAlta.fill = GridBagConstraints.BOTH;
		gbc_btnAlta.insets = new Insets(0, 0, 5, 0);
		gbc_btnAlta.gridx = 1;
		gbc_btnAlta.gridy = 1;
		panelBotones.add(btnAlta, gbc_btnAlta);

		btnBaja = new JButton("Baja");
		GridBagConstraints gbc_btnBaja = new GridBagConstraints();
		gbc_btnBaja.fill = GridBagConstraints.BOTH;
		gbc_btnBaja.gridx = 1;
		gbc_btnBaja.gridy = 2;
		panelBotones.add(btnBaja, gbc_btnBaja);

		panelFormato = new JPanel();
		panelFormato.setBackground(new Color(51, 102, 102));
		panelFormato.setBorder(new TitledBorder(null, "Formato", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panelFormato = new GridBagConstraints();
		gbc_panelFormato.insets = new Insets(0, 0, 5, 5);
		gbc_panelFormato.fill = GridBagConstraints.BOTH;
		gbc_panelFormato.gridx = 1;
		gbc_panelFormato.gridy = 1;
		panelPrincipal.add(panelFormato, gbc_panelFormato);
		GridBagLayout gbl_panelFormato = new GridBagLayout();
		gbl_panelFormato.columnWidths = new int[] { 0, 0 };
		gbl_panelFormato.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_panelFormato.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_panelFormato.rowWeights = new double[] { 1.0, 1.0, 1.0, Double.MIN_VALUE };
		panelFormato.setLayout(gbl_panelFormato);

		chkCartone = new JCheckBox("Carton\u00E9");
		chkCartone.setBackground(new Color(51, 102, 102));
		GridBagConstraints gbc_chkCartone = new GridBagConstraints();
		gbc_chkCartone.anchor = GridBagConstraints.WEST;
		gbc_chkCartone.insets = new Insets(0, 0, 5, 0);
		gbc_chkCartone.gridx = 0;
		gbc_chkCartone.gridy = 0;
		panelFormato.add(chkCartone, gbc_chkCartone);

		chkRustica = new JCheckBox("R\u00FAstica");
		chkRustica.setBackground(new Color(51, 102, 102));
		GridBagConstraints gbc_chkRustica = new GridBagConstraints();
		gbc_chkRustica.anchor = GridBagConstraints.WEST;
		gbc_chkRustica.insets = new Insets(0, 0, 5, 0);
		gbc_chkRustica.gridx = 0;
		gbc_chkRustica.gridy = 1;
		panelFormato.add(chkRustica, gbc_chkRustica);

		chkTapaDura = new JCheckBox("Tapa dura");
		chkTapaDura.setBackground(new Color(51, 102, 102));
		GridBagConstraints gbc_chkTapaDura = new GridBagConstraints();
		gbc_chkTapaDura.anchor = GridBagConstraints.WEST;
		gbc_chkTapaDura.gridx = 0;
		gbc_chkTapaDura.gridy = 2;
		panelFormato.add(chkTapaDura, gbc_chkTapaDura);

		panelEstado = new JPanel();
		panelEstado.setBackground(new Color(51, 102, 102));
		panelEstado.setBorder(new TitledBorder(null, "Estado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panelEstado = new GridBagConstraints();
		gbc_panelEstado.insets = new Insets(0, 0, 5, 5);
		gbc_panelEstado.fill = GridBagConstraints.BOTH;
		gbc_panelEstado.gridx = 2;
		gbc_panelEstado.gridy = 1;
		panelPrincipal.add(panelEstado, gbc_panelEstado);
		GridBagLayout gbl_panelEstado = new GridBagLayout();
		gbl_panelEstado.columnWidths = new int[] { 0, 0 };
		gbl_panelEstado.rowHeights = new int[] { 0, 0, 0 };
		gbl_panelEstado.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_panelEstado.rowWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		panelEstado.setLayout(gbl_panelEstado);

		radialNovedad = new JRadioButton("Novedad");
		buttonGroup.add(radialNovedad);
		radialNovedad.setBackground(new Color(51, 102, 102));
		GridBagConstraints gbc_radialNovedad = new GridBagConstraints();
		gbc_radialNovedad.anchor = GridBagConstraints.WEST;
		gbc_radialNovedad.insets = new Insets(0, 0, 5, 0);
		gbc_radialNovedad.gridx = 0;
		gbc_radialNovedad.gridy = 0;
		panelEstado.add(radialNovedad, gbc_radialNovedad);

		radialReedicion = new JRadioButton("Reedici\u00F3n");
		buttonGroup.add(radialReedicion);
		radialReedicion.setBackground(new Color(51, 102, 102));
		GridBagConstraints gbc_radialReedicion = new GridBagConstraints();
		gbc_radialReedicion.anchor = GridBagConstraints.WEST;
		gbc_radialReedicion.gridx = 0;
		gbc_radialReedicion.gridy = 1;
		panelEstado.add(radialReedicion, gbc_radialReedicion);

		scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 4;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 2;
		panelPrincipal.add(scrollPane, gbc_scrollPane);
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		table.setBackground(Color.LIGHT_GRAY);
	}
}
