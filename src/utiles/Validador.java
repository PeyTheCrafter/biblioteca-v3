package utiles;

import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Validador {
	public static void main(String[] args) {
		System.out.println(validarISBN("1234567891234"));
		System.out.println(validarISBN("123456781234"));
	}
	
	public static boolean validarISBN(String isbn) {
		return isbn.matches("[0-9]{13}");
	}
}
