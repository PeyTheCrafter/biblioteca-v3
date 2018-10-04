package utiles;

import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Validador {	
	public static boolean validarISBN(String isbn) {
		return isbn.matches("[0-9]{13}");
	}
}
