package es.uniovi.asw.dbupdate;

import es.uniovi.asw.model.Citizen;
import es.uniovi.asw.persistence.util.Jpa;

public class DeleteP implements Delete{
	
	public void delete(Citizen c){
		Jpa.getManager().remove(c.getUser());
		Jpa.getManager().remove(c);
	}
}
