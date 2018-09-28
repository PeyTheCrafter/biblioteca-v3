package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import modelo.Estanteria;
import modelo.Libro;

class EstanteriaTest {
	Estanteria instancia = new Estanteria();

	@Test
	void testInsertarLibro() {
		// Preparatoria.
		Libro[] salida = new Libro[5];
		Libro libro = new Libro("Uno");
		salida[0] = libro;

		// Prueba.
		this.instancia.insertarLibro(libro);
		assertEquals(salida[0].getTitulo(), this.instancia.getLibros()[0].getTitulo());
	}

	@Test
	void testBorrarLibro() {
		this.instancia = new Estanteria();
		this.instancia.insertarLibro(new Libro("Uno"));
		this.instancia.borrarLibro("Uno");
		assertNull(this.instancia.getLibros()[0]);
	}

	@Test
	void testBuscarIndice() {
		int posicion = 3;
		this.instancia = new Estanteria();
		this.instancia.insertarLibro(new Libro(""));
		this.instancia.insertarLibro(new Libro(""));
		this.instancia.insertarLibro(new Libro(""));
		assertEquals(posicion, this.instancia.buscarIndice());
	}

	@Test
	void testBuscarLibro() {
		this.instancia = new Estanteria();
		this.instancia.insertarLibro(new Libro("Uno"));
		this.instancia.insertarLibro(new Libro("Dos"));
		this.instancia.insertarLibro(new Libro("Tres"));
		assertEquals(new Libro("Uno").getTitulo(), this.instancia.buscarLibro("Uno").getTitulo());
	}

	@Test
	void testPosicionLibro() {
		this.instancia = new Estanteria();
		this.instancia.insertarLibro(new Libro("Uno"));
		this.instancia.insertarLibro(new Libro("Dos"));
		this.instancia.insertarLibro(new Libro("Tres"));
		this.instancia.insertarLibro(new Libro("Cuatro"));
		this.instancia.insertarLibro(new Libro("Cinco"));
		assertEquals(1, this.instancia.posicionLibro("Dos"));
		assertEquals(3, this.instancia.posicionLibro("Cuatro"));
	}

}
