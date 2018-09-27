package modelo;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Estanteria {
	private Libro[] libros = new Libro[100];

	public static void main(String[] args) {
		Estanteria e = new Estanteria();
		System.out.println(e.insertarLibro(new Libro("1")));
		System.out.println(e.insertarLibro(new Libro("2")));
		System.out.println(e.buscarIndice());
		System.out.println(e.borrarLibro("2"));
	}

	private <T> void mostrar(T[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}

	public boolean insertarLibro(Libro libro) {
		int indice = this.buscarIndice();
		this.libros[indice] = libro;
		return !this.libros[indice].equals(null);
	}

	public boolean borrarLibro(String nombre) {
		int indice = this.posicionLibro(nombre);
		this.libros[indice] = null;
		return this.libros[indice].equals(null);
	}

	private int buscarIndice() {
		for (int i = 0; i < this.libros.length; i++) {
			if (this.libros[i] == null) {
				return i;
			}
		}
		return -1;
	}

	public Libro buscarLibro(String nombre) {
		for (Libro libro : libros) {
			if (libro.getTitulo().contains(nombre)) {
				return libro;
			}
		}
		return null;
	}

	private int posicionLibro(String nombre) {
		for (int i = 0; i < this.libros.length; i++) {
			if (this.libros[i].getTitulo() == nombre) {
				return i;
			}
		}
		return -1;
	}
}
