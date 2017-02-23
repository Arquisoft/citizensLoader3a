package es.uniovi.asw.dbupdate;

import java.util.List;

import es.uniovi.asw.model.Ciudadano;

public interface Insert {
	
	public List<Ciudadano> insert (List<Ciudadano> ciudadanos, String fichero);

}