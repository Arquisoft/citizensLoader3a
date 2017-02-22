package es.uniovi.asw.Parser;

import java.util.List;

import es.uniovi.asw.DBUpdate.Insert;
import es.uniovi.asw.DBUpdate.InsertP;
import es.uniovi.asw.model.Ciudadano;

public class InsertQ implements Insert {

	@Override
	public List<Ciudadano> insert(List<Ciudadano> ciudadanos, String fichero) {
		return InsertP.getInstance().insert(ciudadanos, fichero);
	}

}