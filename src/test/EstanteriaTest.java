package test;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import modelo.Estanteria;
import modelo.Libro;

public class EstanteriaTest {

	@Test
	public void testInsertarLibro() {
		Estanteria es = new Estanteria(5);
		Libro esp[] = new Libro[5];
		esp[0] = new Libro("Uno", "1");
		esp[1] = new Libro("Libro", "2");
		esp[2] = new Libro("Algo", "3");
		esp[3] = new Libro("AAAA", "4");
		esp[4] = new Libro("EEEE", "5");
		es.insertarLibro(new Libro("Uno", "1"));
		es.insertarLibro(new Libro("Libro", "2"));
		es.insertarLibro(new Libro("Algo", "3"));
		es.insertarLibro(new Libro("AAAA", "4"));
		es.insertarLibro(new Libro("EEEE", "5"));
		for (int i = 0; i < esp.length; i++) {
			assertEquals(esp[i].getTitulo(), es.getLibros()[i].getTitulo());
		}
	}

	@Test
	public void testBorrarLibro() {
		Estanteria es = new Estanteria(10);
		es.insertarLibro(new Libro("Uno", "1"));
		es.insertarLibro(new Libro("Dos", "2"));
		es.insertarLibro(new Libro("Tres", "3"));
		es.insertarLibro(new Libro("Cuatro", "4"));
		es.insertarLibro(new Libro("Cinco", "5"));
		int posicion = es.posicionLibro("Tres");
		Libro libro = es.obtenerLibro(posicion);
		es.borrarLibroISBN(libro.getIsbn());
		assertNull(es.getLibros()[2]);
	}

	@Ignore
	public void testBuscarIndice() {
		Estanteria es = new Estanteria(10);
		es.insertarLibro(new Libro("Uno", "1"));
		es.insertarLibro(new Libro("Dos", "2"));
		es.insertarLibro(new Libro("Tres", "3"));
		es.insertarLibro(new Libro("Cuatro", "4"));
		es.insertarLibro(new Libro("Cinco", "5"));
		es.
		assertEquals(1, es.buscarEspacio());
	}

	@Ignore
	public void testBuscarLibro() {
		Estanteria es = new Estanteria(10);
		Libro esp = new Libro("Tres", "3");
		es.insertarLibro(new Libro("Uno", "1"));
		es.insertarLibro(new Libro("Dos", "2"));
		es.insertarLibro(new Libro("Tres", "3"));
		es.insertarLibro(new Libro("Cuatro", "4"));
		es.insertarLibro(new Libro("Cinco", "5"));
		assertEquals(esp.getTitulo(), es.buscarLibro("Tres").getTitulo());
		assertNull(es.buscarLibro("AAAA"));
	}

	@Ignore
	public void testPosicionLibro() {
		Estanteria es = new Estanteria(10);
		es.insertarLibro(new Libro("Uno", "1"));
		es.insertarLibro(new Libro("Dos", "2"));
		es.insertarLibro(new Libro("Tres", "3"));
		es.insertarLibro(new Libro("Cuatro", "4"));
		es.insertarLibro(new Libro("Cinco", "5"));
		assertEquals(2, es.posicionLibro("Tres"));
		assertEquals(-1, es.posicionLibro("AAAA"));
	}

}
