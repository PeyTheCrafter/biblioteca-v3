package controlador;

import java.awt.EventQueue;

import vista.UI_old;

public class Principal {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ParaUI.getInstance();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
