package modelo;

public enum Temas {
	Void(""), Accion("Acción"), Aventuras("Aventuras"), Ciencia("Ciencia"), Biologia("Biología"), Misterio("MIsterio"), Drama(
			"Drama"), Terror("Terror");
	String tema;

	private Temas(String tema) {
		this.tema = tema;
	}
	
	@Override
	public String toString() {
		return tema.toString();
	}
}
