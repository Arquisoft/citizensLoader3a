package es.uniovi.asw.dbupdate;

import es.uniovi.asw.model.Ciudadano;
import es.uniovi.asw.persistence.util.Jpa;

public class DeleteP implements Delete{
	
	public void delete(Ciudadano c){
		Jpa.getManager().remove(c.getUsuario());
		Jpa.getManager().remove(c);
	}
}
