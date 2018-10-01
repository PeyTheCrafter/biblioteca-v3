package modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class EstanteriaTest {

	@Test
	public void testInsertarLibro() {
		Estanteria es = new Estanteria(5);
		Libro esp[] = new Libro[5];
		esp[0] = new Libro("Uno");
		esp[1] = new Libro("Libro");
		es.insertarLibro(new Libro("Uno"));
		es.insertarLibro(new Libro("Libro"));
		for (int i = 0; i < esp.length; i++) {
			assertEquals(esp[i].getTitulo(), es.getLibros()[i].getTitulo());
		}
	}

	@Test
	public void testBorrarLibro() {
		Estanteria es = new Estanteria(10);
		es.insertarLibro(new Libro("Uno"));
		es.insertarLibro(new Libro("Dos"));
		es.insertarLibro(new Libro("Tres"));
		es.insertarLibro(new Libro("Cuatro"));
		es.insertarLibro(new Libro("Cinco"));
		es.borrarLibro("Dos");
		assertNull(es.getLibros()[1]);
	}

	@Test
	public void testBuscarIndice() {
		Estanteria es = new Estanteria(10);
		es.insertarLibro(new Libro("Uno"));
		es.insertarLibro(new Libro("Dos"));
		es.insertarLibro(new Libro("Tres"));
		es.insertarLibro(new Libro("Cuatro"));
		es.insertarLibro(new Libro("Cinco"));
		es.borrarLibro("Dos");
		assertEquals(1, es.buscarIndice());
	}

	@Test
	public void testBuscarLibro() {
		Estanteria es = new Estanteria(10);
		es.insertarLibro(new Libro("Uno"));
		es.insertarLibro(new Libro("Dos"));
		es.insertarLibro(new Libro("Tres"));
		es.insertarLibro(new Libro("Cuatro"));
		es.insertarLibro(new Libro("Cinco"));
		assertEquals(2, es.buscarLibro("Tres"));
		assertNull(es.buscarLibro("AAAA"));
	}

	@Test
	public void testPosicionLibro() {
		Estanteria es = new Estanteria(10);
		es.insertarLibro(new Libro("Uno"));
		es.insertarLibro(new Libro("Dos"));
		es.insertarLibro(new Libro("Tres"));
		es.insertarLibro(new Libro("Cuatro"));
		es.insertarLibro(new Libro("Cinco"));
		assertEquals(3,  es.posicionLibro("Tres"));
		assertEquals(-1, "AAAA");
	}

}
