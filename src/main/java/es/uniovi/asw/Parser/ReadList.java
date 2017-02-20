package es.uniovi.asw.Parser;

import java.util.List;

import es.uniovi.asw.model.Ciudadano;

public interface ReadList {

	public List<Ciudadano> read (String fichero);
	
}