package es.uniovi.asw.persistence;

import java.util.List;

import es.uniovi.asw.model.Citizen;
import es.uniovi.asw.persistence.util.Jpa;

public class CitizenFinder {

	public static  Citizen findByDni (String dni) {		
		List<Citizen> ciudadanos = Jpa.getManager().createNamedQuery("Ciudadano.findByDni", Citizen.class).setParameter(1, dni).getResultList();
		
		return ciudadanos.isEmpty() ? null : ciudadanos.get(0);
	}	
}