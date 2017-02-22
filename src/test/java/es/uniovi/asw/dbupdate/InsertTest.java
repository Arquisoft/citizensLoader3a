package es.uniovi.asw.dbupdate;

import static org.junit.Assert.*;

import org.junit.Test;

import es.uniovi.asw.Parser.RList;
import es.uniovi.asw.Parser.ReadList;
import es.uniovi.asw.Parser.readers.ExcelReader;
import es.uniovi.asw.model.Ciudadano;
import es.uniovi.asw.persistence.CiudadanoFinder;

public class InsertTest {
	
	private RList rList = new RList();
	private Ciudadano c1;
	private Ciudadano c2;
	private Ciudadano c3;

	@Test
	public void test() {
		c1 = new Ciudadano("Juan", "Torres Pardo", "juan@example.com", null, null, "Español", "90500084Y");
		c2 = new Ciudadano("Luis", "López Fernando", "luis@example.com", null, null, "Español", "19160962F");
		c3 = new Ciudadano("Ana", "Torres Pardo", "ana@example.com", null, null, "Francés", "09940449X");
		
		rList.setReader(new ExcelReader());
		//Metodo encargado de leer el fichero, de crear a los ciudadanos y de llamar al insert
		rList.read("test.xlsx");
		
		
		Ciudadano ciud1 = CiudadanoFinder.findByDni("90500084Y");
		assertFalse(ciud1 == null);
	}

}
