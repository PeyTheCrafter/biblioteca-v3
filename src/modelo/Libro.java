package modelo;

public class Libro {
	private String titulo;
	private String autor;
	private int tema;
	private String numPaginas;
	private String isbn;
	private boolean cartone;
	private boolean rustico;
	private boolean tapaDura;
	private boolean novedad;

	public Libro(String titulo, String autor, int tema, String numPaginas, String isbn, boolean cartone,
			boolean rustico, boolean tapaDura, boolean novedad) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.tema = tema;
		this.numPaginas = numPaginas;
		this.isbn = isbn;
		this.cartone = cartone;
		this.rustico = rustico;
		this.tapaDura = tapaDura;
		this.novedad = novedad;
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

}
