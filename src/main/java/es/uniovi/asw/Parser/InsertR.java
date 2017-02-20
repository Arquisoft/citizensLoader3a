package es.uniovi.asw.Parser;

import java.util.List;

import es.uniovi.asw.DBUpdate.Insert;
import es.uniovi.asw.DBUpdate.InsertP;
import es.uniovi.asw.model.Ciudadano;

public class InsertR implements Insert {

	@Override
	public void insert(List<Ciudadano> ciudadanos) {
		new InsertP().insert(ciudadanos);
	}
}