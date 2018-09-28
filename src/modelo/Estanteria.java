package modelo;

public class Estanteria {
	private Libro[] libros = new Libro[100];

	public static void main(String[] args) {
		Estanteria e = new Estanteria();
		e.insertarLibro(new Libro("1"));
		e.insertarLibro(new Libro("2"));
		e.buscarIndice();
		e.borrarLibro("2");
	}

	private <T> void mostrar(T[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}

	/**
	 * PROPORCIONADO.
	 * Inserta un libro en el array.
	 * @param libro: el libro a insertar.
	 * @return true si lo ha guardado, false si no.
	 */
	public boolean insertarLibro(Libro libro) {
		int indice = this.buscarIndice();
		this.libros[indice] = libro;
		return !this.libros[indice].equals(null);
	}

	/**
	 * PROPORCIONADO.
	 * Borra un libro por su nombre.
	 * @param nombre: el nombre del libro.
	 * @return true si lo borra, false si no.
	 */
	public boolean borrarLibro(String nombre) {
		int indice = this.posicionLibro(nombre);
		System.out.println(indice);
		this.libros[indice] = null;
		return this.libros[indice] == null;
	}

	/**
	 * PROPIO.
	 * Busca el primer hueco libre que haya.
	 * @return el índice del hueco encontrado.
	 */
	public int buscarIndice() {
		for (int i = 0; i < this.libros.length; i++) {
			if (this.libros[i] == null) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * PROPORCIONADO.
	 * Busca un libro por su nombre.
	 * @param nombre: el nombre del libro.
	 * @return el libro si lo encuentra, null si no.
	 */
	public Libro buscarLibro(String nombre) {
		for (Libro libro : libros) {
			if (libro.getTitulo().contains(nombre)) {
				return libro;
			}
		}
		return null;
	}

	/**
	 * PROPORCIONADO.
	 * Busca la posición del un libro por su nombre.
	 * @param nombre: nombre del libro a buscar.
	 * @return la posición si lo ha encontrado, -1 si no.
	 */
	public int posicionLibro(String nombre) {
		for (int i = 0; i < this.libros.length; i++) {
			if (this.libros[i].getTitulo().toLowerCase().equals(nombre.toLowerCase())) {
				return i;
			}
		}
		return -1;
	}

	public Libro[] getLibros() {
		return libros;
	}

}
