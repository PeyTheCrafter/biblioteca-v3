package utiles;

public class Validador {
	public static boolean validarISBN(String isbn) {
		return isbn.matches("^[0-9]{13}$");
	}
}
