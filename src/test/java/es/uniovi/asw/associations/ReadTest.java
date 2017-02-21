package es.uniovi.asw.associations;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import es.uniovi.asw.Parser.readers.ExcelReader;
import es.uniovi.asw.Parser.readers.Reader;
import es.uniovi.asw.model.Ciudadano;

public class ReadTest {
	
	private Reader reader;
	private Ciudadano c1;
	private Ciudadano c2;
	private Ciudadano c3;

	@Test
	public void testReader() {
		reader = new ExcelReader();
		c1 = new Ciudadano("Juan", "Torres Pardo", "juan@example.com", null, null, "Español", "90500084Y");
		c2 = new Ciudadano("Luis", "López Fernando", "luis@example.com", null, null, "Español", "19160962F");
		c3 = new Ciudadano("Ana", "Torres Pardo", "ana@example.com", null, null, "Francés", "09940449X");
		
		List<Ciudadano> lista = reader.read("test.xlsx");
		
		//Compruebo ciudadano 1
		assertTrue(lista.get(0).getDni().equals(c1.getDni()));
		assertFalse(lista.get(0).getFechaNacimiento().equals(c1.getFechaNacimiento()));
		assertTrue(lista.get(0).equals(c1));
		
		//Compruebo ciudadano 2
		assertTrue(lista.get(1).getDni().equals(c2.getDni()));
		assertTrue(lista.get(1).getNacionalidad().equals(c2.getNacionalidad()));
		assertTrue(lista.get(1).equals(c2));
		
		//Compruebo ciudadano 3
		assertTrue(lista.get(2).getDni().equals(c3.getDni()));
		assertFalse(lista.get(2).getNacionalidad().equals(c3.getNacionalidad()));
		assertTrue(lista.get(2).equals(c3));
		
		assertFalse(c1.equals(c2));
		assertFalse(c1.equals(c3));
		assertFalse(c2.equals(c3));
	}
}
