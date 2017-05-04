package es.uniovi.asw.dbupdate;

import java.util.List;
import es.uniovi.asw.model.Citizen;

public interface Insert {
	
	public List<Citizen> insert (List<Citizen> ciudadanos, String fichero);

}