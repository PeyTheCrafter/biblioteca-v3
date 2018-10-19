package utiles;

import controlador.ParaUI;

public class GestorUI {
	private ParaUI paraUI;

	public GestorUI(ParaUI paraUI) {
		this.paraUI = paraUI;
	}

	public void global(boolean state) {
		this.txt(state);
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
	
	public void chk(boolean state) {
		this.Radiocartone(state);
		this.RadioRustica(state);
		this.RadioTapaDura(state);
		this.chkEspiral(state);
	}
	
	public void radial(boolean state) {
		this.paraUI.getRadialNovedad().setEnabled(state);
		this.paraUI.getRadialReedicion().setEnabled(state);
	}
	
	public void chkEspiral(boolean state) {
		this.paraUI.getRadioEspiral().setEnabled(state);
	}

	public void RadioTapaDura(boolean state) {
		this.paraUI.getRadioTapaDura().setEnabled(state);
	}

	public void RadioRustica(boolean state) {
		this.paraUI.getRadioRustica().setEnabled(state);
	}

	public void Radiocartone(boolean state) {
		this.paraUI.getRadioCartone().setEnabled(state);
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
