package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ParaUI;
import controlador.eventos.EventoVentaEjemplar;
import modelo.Estanteria;
import modelo.Modalable;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModalConfirmacionVenta extends JDialog implements Modalable {

	private final JPanel contentPanel = new JPanel();
	protected JTextField textField;
	private JButton okButton;
	private JButton cancelButton;

	/**
	 * Create the dialog.
	 * 
	 * @param ui_old
	 */
	public ModalConfirmacionVenta(UI_old ui_old) {
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 270, 144);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblCantidadAVender = new JLabel("Cantidad a vender:");
			lblCantidadAVender.setFont(new Font("Tahoma", Font.BOLD, 16));
			GridBagConstraints gbc_lblCantidadAVender = new GridBagConstraints();
			gbc_lblCantidadAVender.insets = new Insets(0, 0, 5, 5);
			gbc_lblCantidadAVender.gridx = 1;
			gbc_lblCantidadAVender.gridy = 1;
			contentPanel.add(lblCantidadAVender, gbc_lblCantidadAVender);
		}
		{
			textField = new JTextField();
			textField.setFont(new Font("Tahoma", Font.BOLD, 16));
			GridBagConstraints gbc_textField = new GridBagConstraints();
			gbc_textField.insets = new Insets(0, 0, 5, 5);
			gbc_textField.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField.gridx = 1;
			gbc_textField.gridy = 2;
			contentPanel.add(textField, gbc_textField);
			textField.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
			setLocationRelativeTo(ui_old);
		}
	}

	public JTextField getTxt() {
		return this.textField;
	}

	public JButton getBtnOk() {
		return this.okButton;
	}

}
