package utiles;

import java.awt.Component;

import javax.swing.JButton;

import controlador.ParaUI;

public class GestorBotones {
	private ParaUI paraUI;

	public GestorBotones(ParaUI paraUI) {
		this.paraUI = paraUI;
	}

	public void global(boolean state) {
		this.txt(state);
		this.btn(state);
		this.chk(state);
		this.radial(state);
		this.combo(state);
	}

	public void combo(boolean state) {
		this.paraUI.getComboTema().setEnabled(state);
	}

	public void btn(boolean state) {
		this.paraUI.getBtnAlta().setEnabled(state);
		this.paraUI.getBtnBaja().setEnabled(state);
	}

	public void chk(boolean state) {
		this.paraUI.getChkCartone().setEnabled(state);
		this.paraUI.getChkRustica().setEnabled(state);
		this.paraUI.getChkTapaDura().setEnabled(state);
	}

	public void radial(boolean state) {
		this.paraUI.getRadialNovedad().setEnabled(state);
		this.paraUI.getRadialReedicion().setEnabled(state);
	}

	public void txt(boolean state) {
		this.paraUI.getTxtTitulo().setEditable(state);
		this.paraUI.getTxtAutor().setEditable(state);
		this.paraUI.getTxtPaginas().setEditable(state);
		this.paraUI.getTxtISBN().setEditable(state);
	}
}
