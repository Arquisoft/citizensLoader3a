package es.uniovi.asw.Parser.readers;

import java.util.List;

import es.uniovi.asw.model.Ciudadano;

public interface Reader {
	
	public List<Ciudadano> read(String fichero);
	public boolean comprobarExtension(String fichero);
	
}