package modelo;

public class Estanteria {
	private Libro[] libros;
	private int uso = 0;

	public Estanteria(int tamano) {
		this.libros = new Libro[tamano];
	}

	public static void main(String[] args) {
		Estanteria es = new Estanteria(10);
		System.out.println(es.insertarLibro(new Libro("uno", "1")));
		System.out.println(es.insertarLibro(new Libro("dos", "1")));
		System.out.println(es.insertarLibro(new Libro("dos", "2")));
		System.out.println(es.getLibros()[0].getTitulo());
		System.out.println(es.getLibros()[1].getTitulo());
		// System.out.println(es.getLibros()[2].getTitulo());
		System.out.println(es.buscarLibro("A"));
	}

	/**
	 * PROPORCIONADO. Inserta un libro en el array.
	 * 
	 * @param libro:
	 *            el libro a insertar.
	 * @return true si lo ha guardado, false si no.
	 */
	public boolean insertarLibro(Libro libro) {
		int indice = this.buscarIndice();
		if (indice != -1 && !this.comprobarISBNRepetido(libro.getIsbn())) {
			this.libros[indice] = libro;
		}
		return this.libros[indice] != null;
	}

	private void mostrar(Libro libro) {
		assert libro != null;
		System.out.println(libro.getAutor());
		System.out.println(libro.getTitulo());
		System.out.println(libro.getNumPaginas());
		System.out.println(libro.getIsbn());
	}

	/**
	 * PROPIO. Comprueba si el ISBN del libro está repetido.
	 * 
	 * @param isbn:
	 *            el código a comprobar.
	 * @return true si está repetido, false si no.
	 */
	private boolean comprobarISBNRepetido(String isbn) {
		for (int i = 0; i < this.libros.length; i++) {
			if (this.libros[i] != null && this.libros[i].getIsbn().equals(isbn)) {
				return true;
			}
		}
		return false;
	}

	private void usoMemoria() {
		this.setUso(0);
		for (Libro libro : libros) {
			if (libro != null) {
				this.setUso(this.getUso() + 1);
			}
		}
	}

	/**
	 * PROPORCIONADO. Borra un libro por su nombre.
	 * 
	 * @param nombre:
	 *            el nombre del libro.
	 * @return true si lo borra, false si no.
	 */
	public boolean borrarLibro(String nombre) {
		int indice = this.posicionLibro(nombre);
		System.out.println(indice);
		this.libros[indice] = null;
		return this.libros[indice] == null;
	}

	/**
	 * PROPIO. Busca el primer hueco libre que haya.
	 * 
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
	 * PROPORCIONADO. Busca un libro por su nombre.
	 * 
	 * @param nombre:
	 *            el nombre del libro.
	 * @return el libro si lo encuentra, null si no.
	 */
	public Libro buscarLibro(String nombre) {
		for (Libro libro : this.getLibros()) {
			if (libro != null && libro.getTitulo().contains(nombre)) {
				return libro;
			}
		}
		return null;
	}

	/**
	 * PROPORCIONADO. Busca la posición del un libro por su nombre.
	 * 
	 * @param nombre:
	 *            nombre del libro a buscar.
	 * @return la posición si lo ha encontrado, -1 si no.
	 */
	public int posicionLibro(String nombre) {
		for (int i = 0; i < this.getLibros().length; i++) {
			if (this.getLibros()[i] != null
					&& this.getLibros()[i].getTitulo().toLowerCase().equals(nombre.toLowerCase())) {
				return i;
			}
		}
		return -1;
	}

	public Libro[] getLibros() {
		return libros;
	}

	public int getUso() {
		return this.uso;
	}

	private void setUso(int uso) {
		this.uso = uso;
	}

}
