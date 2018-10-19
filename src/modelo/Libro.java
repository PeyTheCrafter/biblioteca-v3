package modelo;

import java.io.Serializable;

public class Libro implements Serializable {
	private static final long serialVersionUID = 1L;
	private String titulo;
	private String autor;
	private String editorial;
	private int tema;
	private String numPaginas;
	private String isbn;
	private boolean cartone;
	private boolean rustico;
	private boolean tapaDura;
	private boolean espiral;
	private boolean novedad;
	private boolean reedicion;
	private int ejemplares;

	public Libro(String titulo, String autor, String editorial, int tema, String numPaginas, String isbn,
			boolean cartone, boolean rustico, boolean tapaDura, boolean espiral, boolean novedad, boolean reedicion,
			int ejemplares) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
		this.tema = tema;
		this.numPaginas = numPaginas;
		this.isbn = isbn;
		this.cartone = cartone;
		this.rustico = rustico;
		this.tapaDura = tapaDura;
		this.espiral = espiral;
		this.novedad = novedad;
		this.reedicion = reedicion;
		this.ejemplares = ejemplares;
	}

	public Libro(String titulo) {
		this.titulo = titulo;
	}

	public Libro(String titulo, String isbn) {
		this.titulo = titulo;
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getAutor() {
		return autor;
	}

	public int getTema() {
		return tema;
	}

	public String getNumPaginas() {
		return numPaginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public boolean isCartone() {
		return cartone;
	}

	public boolean isRustico() {
		return rustico;
	}

	public boolean isTapaDura() {
		return tapaDura;
	}

	public boolean isNovedad() {
		return novedad;
	}

	public int getEjemplares() {
		return this.ejemplares;
	}

	public void setEjemplares(int ejemplares) {
		this.ejemplares = ejemplares;
	}

	public String getEditorial() {
		return editorial;
	}

	public boolean isEspiral() {
		return espiral;
	}

	public boolean isReedicion() {
		return reedicion;
	}

}
