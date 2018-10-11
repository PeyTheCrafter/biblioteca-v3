package utiles;

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
	
	public void txt(boolean state) {
		this.txtTitulo(state);
		this.txtAutor(state);
		this.txtPaginas(state);
		this.txtIsbn(state);
	}

	public void combo(boolean state) {
		this.paraUI.getComboTema().setEnabled(state);
	}

	public void btn(boolean state) {
		this.btnAlta(state);
		this.btnBaja(state);
		//this.btnModificar(state);
	}
	
	public void chk(boolean state) {
		this.chkcartone(state);
		this.chkRustica(state);
		this.chkTapaDura(state);
	}
	
	public void radial(boolean state) {
		this.paraUI.getRadialNovedad().setEnabled(state);
		this.paraUI.getRadialReedicion().setEnabled(state);
	}

	public void btnAlta(boolean state) {
		this.paraUI.getBtnAlta().setEnabled(state);
	}

	public void btnBaja(boolean state) {
		this.paraUI.getBtnBaja().setEnabled(state);
	}
	
	public void btnModificar(boolean state) {
		this.paraUI.getBtnModificar().setEnabled(state);
	}

	public void chkTapaDura(boolean state) {
		this.paraUI.getChkTapaDura().setEnabled(state);
	}

	public void chkRustica(boolean state) {
		this.paraUI.getChkRustica().setEnabled(state);
	}

	public void chkcartone(boolean state) {
		this.paraUI.getChkCartone().setEnabled(state);
	}

	public void txtIsbn(boolean state) {
		this.paraUI.getTxtIsbn().setEditable(state);
	}

	public void txtPaginas(boolean state) {
		this.paraUI.getTxtPaginas().setEditable(state);
	}

	public void txtAutor(boolean state) {
		this.paraUI.getTxtAutor().setEditable(state);
	}

	public void txtTitulo(boolean state) {
		this.paraUI.getTxtTitulo().setEditable(state);
	}
}
