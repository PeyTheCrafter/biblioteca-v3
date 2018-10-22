package modelo;

import java.util.ArrayList;

import controlador.acceso.Almacen;

public class Estanteria {
	private ArrayList<Libro> libros;
	private Almacen almacen;

	public Estanteria() {
		this.libros = new ArrayList<>();
		this.almacen = new Almacen("storage.data");
		this.iniciarFichero();
	}

	private void iniciarFichero() {
		try {
			this.cargar();
		} catch (Exception e) {
			this.almacen.almacena(this.libros);
		}
	}

	private void guardar() {
		this.almacen.almacena(this.libros);
	}

	private void cargar() {
		this.libros = (ArrayList<Libro>) this.almacen.recuperar();
	}

	public void vender(int posicion, int cantidad) {
		assert posicion > -1;
		assert cantidad > 0;
		Libro libro = this.obtenerLibro(posicion);
		int ejemplares = libro.getEjemplares();
		if (ejemplares - cantidad >= 0) {
			libro.setEjemplares(ejemplares - cantidad);
		}
		this.borrarLibroPosicion(posicion);
		this.insertarLibro(libro, posicion);
	}

	/**
	 * Calcula el tamaño del array.
	 * 
	 * @return
	 */
	public int getTamano() {
		return this.libros.size();
	}

	public int getUsoMemoria() {
		int contador = 0;
		for (Libro libro : libros) {
			if (libro != null) {
				contador++;
			}
		}
		return contador;
	}

	/**
	 * Obtiene el libro en la posición.
	 * 
	 * @param posicion
	 *            la posición.
	 * @return el libro si lo ha encontrado, null si no.
	 */
	public Libro obtenerLibro(int posicion) {
		return this.getLibros().get(posicion);
	}

	/**
	 * PROPORCIONADO. Inserta un libro en el array.
	 * 
	 * @param libro:
	 *            el libro a insertar.
	 * @return true si lo ha guardado, false si no.
	 */
	public boolean insertarLibro(Libro libro) {
		this.cargar();
		if (!this.comprobarISBNRepetido(libro.getIsbn())) {
			this.getLibros().add(libro);
			this.guardar();
			return true;
		}
		return false;
	}

	public boolean insertarLibro(Libro libro, int posicion) {
		this.cargar();
		assert posicion >= 0;
		if (!this.comprobarISBNRepetido(libro.getIsbn())) {
			this.getLibros().add(posicion, libro);
			this.guardar();
		}
		return this.obtenerLibro(posicion) != null && this.obtenerLibro(posicion).getIsbn().equals(libro.getIsbn());
	}

	/**
	 * PROPORCIONADO. Busca la posición del un libro por su nombre.
	 * 
	 * @param nombre:
	 *            nombre del libro a buscar.
	 * @return la posición si lo ha encontrado, -1 si no.
	 */
	public int posicionLibro(String nombre) {
		this.cargar();
		for (int i = 0; i < this.getLibros().size(); i++) {
			if (this.getLibros().get(i).getTitulo().toLowerCase().equals(nombre.toLowerCase())) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * PROPIO. Busca la posición del un libro por su ISBN.
	 * 
	 * @param nombre:
	 *            ISBN del libro a buscar.
	 * @return la posición si lo ha encontrado, -1 si no.
	 */
	public int posicionLibroISBN(String isbn) {
		this.cargar();
		for (int i = 0; i < this.getLibros().size(); i++) {
			if (this.getLibros().get(i).getIsbn().toLowerCase().equals(isbn.toLowerCase())) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Obtiene la posición de un libro por su nombre.
	 * 
	 * @param nombre
	 *            nombre del libro a buscar.
	 * @return la posición si lo encuentra, -1 si no.
	 */
	public int posicionLibroNombre(String nombre) {
		this.cargar();
		for (int i = 0; i < this.getLibros().size(); i++) {
			if (this.getLibros().get(i).getTitulo().toLowerCase().equals(nombre.toLowerCase())) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Borra la posición.
	 * 
	 * @param indice
	 *            la posición a borrar.
	 * @return true si se ha borrado, false si no.
	 */
	public boolean borrarLibroPosicion(int indice) {
		this.cargar();
		if (indice >= 0 && indice < this.libros.size()) {
			Libro libro = this.getLibros().get(indice);
			if (this.getLibros().remove(indice) != null) {
				this.guardar();
				return true;
			}
		}
		return false;
	}

	/**
	 * PROPIO. Borra un libro por su ISBN.
	 * 
	 * @param nombre:
	 *            el ISBN del libro.
	 * @return true si lo borra, false si no.
	 */
	public boolean borrarLibroISBN(String isbn) {
		this.cargar();
		int indice = this.posicionLibroISBN(isbn);
		if (this.getLibros().remove(indice) == null) {
			this.guardar();
			return true;
		}
		return false;
	}

	/**
	 * PROPIO. Comprueba si el ISBN del libro está repetido.
	 * 
	 * @param isbn:
	 *            el código a comprobar.
	 * @return true si está repetido, false si no.
	 */
	private boolean comprobarISBNRepetido(String isbn) {
		this.cargar();
		if (this.getLibros().size() != 0) {
			for (int i = 0; i < this.libros.size(); i++) {
				if (this.getLibros().get(i) != null && this.getLibros().get(i).getIsbn().equals(isbn)) {
					return true;
				}
			}
		}
		return false;
	}

	public ArrayList<Libro> getLibros() {
		return libros;
	}

}
