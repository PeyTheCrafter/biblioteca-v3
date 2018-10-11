package modelo;

import java.util.ArrayList;

public class Estanteria_new {
	
	
	public static void main(String[] args) {
		ArrayList<Libro> estanteria = new ArrayList<>();
		estanteria.add(new Libro("Uno", "Uno"));
		estanteria.add(new Libro("Dos", "Dos"));
		estanteria.add(new Libro("Tres", "Tres"));
		estanteria.add(new Libro("Cuatro", "Cuatro"));
		mostrar(estanteria);
		estanteria.remove(1);
		mostrar(estanteria);
		estanteria.add(new Libro("Cinco", "Cinco"));
		mostrar(estanteria);
	}
	
	public static void mostrar(ArrayList<Libro> al) {
		for (int i = 0; i < al.size(); i++) {
			System.out.println(al.get(i).getTitulo() + " " + al.get(i).getIsbn());
		}
	}
}
