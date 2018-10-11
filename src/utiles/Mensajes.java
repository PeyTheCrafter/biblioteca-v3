package utiles;

public enum Mensajes {
	ErrorIsbnRepetido("ISBN repetido."), ErrorIsbnInvalido("ISBN incorrecto."), ErrorInsercion(
			"Error al insertar el libro."), ExitoInsercion(
					"Libro añadido correctamente."), ErrorMemoria("Memoria llena."), ErrorBorrar(
							"Error al borrar el libro."), ExitoBorrar("Libro borrado con éxito"), ExitoModificacion(
									"Libro modificado con éxito."), ErrorModificacion("Error al modificar el libro.");

	String mensaje;

	private Mensajes(String mensaje) {
		this.mensaje = mensaje;
	}

	@Override
	public String toString() {
		return mensaje.toString();
	}
}
