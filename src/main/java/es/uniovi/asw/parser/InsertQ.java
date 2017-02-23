package es.uniovi.asw.parser;

import java.util.List;

import es.uniovi.asw.dbupdate.Insert;
import es.uniovi.asw.dbupdate.InsertP;
import es.uniovi.asw.model.Ciudadano;

public class InsertQ implements Insert {

	@Override
	public List<Ciudadano> insert(List<Ciudadano> ciudadanos, String fichero) {		
		return InsertP.getInstance().insert(ciudadanos, fichero);
	}
	
}