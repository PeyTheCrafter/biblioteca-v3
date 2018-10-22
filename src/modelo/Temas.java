package modelo;

public enum Temas {
	Void(""), Accion("Acci�n"), Aventuras("Aventuras"), Ciencia("Ciencia"), Biologia("Biolog�a"), Misterio("MIsterio"), Drama(
			"Drama"), Terror("Terror"), Discursion("Discursi�n");
	String tema;

	private Temas(String tema) {
		this.tema = tema;
	}
	
	@Override
	public String toString() {
		return tema.toString();
	}
}
