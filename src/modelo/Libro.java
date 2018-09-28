package modelo;

public class Libro {
	private String titulo;
	private String autor;
	private String tema;
	private String numPaginas;
	private String formatoUno;
	private String formatoDos;
	private String formatoTres;
	private String estado;
	private String locTema;
	private String isbn;

	public Libro(String titulo, String autor, String tema, String numPaginas, String formatoUno, String formatoDos,
			String formatoTres, String estado, String locTema) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.tema = tema;
		this.numPaginas = numPaginas;
		this.formatoUno = formatoUno;
		this.formatoDos = formatoDos;
		this.formatoTres = formatoTres;
		this.estado = estado;
		this.locTema = locTema;
	}

	public Libro(String titulo) {
		this.titulo = titulo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public String getNumPaginas() {
		return numPaginas;
	}

	public void setNumPaginas(String numPaginas) {
		this.numPaginas = numPaginas;
	}

	public String getFormatoUno() {
		return formatoUno;
	}

	public void setFormatoUno(String formatoUno) {
		this.formatoUno = formatoUno;
	}

	public String getFormatoDos() {
		return formatoDos;
	}

	public void setFormatoDos(String formatoDos) {
		this.formatoDos = formatoDos;
	}

	public String getFormatoTres() {
		return formatoTres;
	}

	public void setFormatoTres(String formatoTres) {
		this.formatoTres = formatoTres;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getLocTema() {
		return locTema;
	}

	public void setLocTema(String locTema) {
		this.locTema = locTema;
	}
	
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

}
