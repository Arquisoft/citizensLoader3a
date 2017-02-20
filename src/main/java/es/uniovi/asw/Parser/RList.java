package es.uniovi.asw.Parser;

import java.util.List;

import es.uniovi.asw.Parser.readers.ExcelReader;
import es.uniovi.asw.Parser.readers.Reader;
import es.uniovi.asw.model.Ciudadano;

public class RList implements ReadList {

	private Reader reader;		

	public RList(Reader reader) {	
		this.reader = reader;
	}

	@Override
	public List<Ciudadano> read(String fichero) {		
		return reader.read(fichero);
	}
}