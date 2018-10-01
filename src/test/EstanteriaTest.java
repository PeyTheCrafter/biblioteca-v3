package test;

import static org.junit.Assert.*;

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
		es.insertarLibro(new Libro("Uno", "1"));
		es.insertarLibro(new Libro("Libro", "2"));
		assertEquals(esp[0].getTitulo(), es.getLibros()[0].getTitulo());
		assertEquals(esp[1].getTitulo(), es.getLibros()[1].getTitulo());
	}

	@Test
	public void testBorrarLibro() {
		Estanteria es = new Estanteria(10);
		es.insertarLibro(new Libro("Uno", "1"));
		es.insertarLibro(new Libro("Dos", "2"));
		es.insertarLibro(new Libro("Tres", "3"));
		es.insertarLibro(new Libro("Cuatro", "4"));
		es.insertarLibro(new Libro("Cinco", "5"));
		es.borrarLibro("Dos");
		assertNull(es.getLibros()[1]);
	}

	@Test
	public void testBuscarIndice() {
		Estanteria es = new Estanteria(10);
		es.insertarLibro(new Libro("Uno", "1"));
		es.insertarLibro(new Libro("Dos", "2"));
		es.insertarLibro(new Libro("Tres", "3"));
		es.insertarLibro(new Libro("Cuatro", "4"));
		es.insertarLibro(new Libro("Cinco", "5"));
		es.borrarLibro("Dos");
		assertEquals(1, es.buscarIndice());
	}

	@Test
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

	@Test
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
