package es.uniovi.asw.persistence;

import java.util.List;

import es.uniovi.asw.model.Ciudadano;
import es.uniovi.asw.persistence.util.Jpa;

public class CiudadanoFinder {

	public static  Ciudadano findByDni (String dni) {		
		List<Ciudadano> ciudadanos = Jpa.getManager().createNamedQuery("Ciudadano.findByDni", Ciudadano.class).setParameter(1, dni).getResultList();
		
		return ciudadanos.isEmpty() ? null : ciudadanos.get(0);
	}	
}