package es.uniovi.asw.dbupdate;

import java.util.ArrayList;
import java.util.List;

import es.uniovi.asw.model.Citizen;
import es.uniovi.asw.model.User;
import es.uniovi.asw.persistence.CitizenFinder;
import es.uniovi.asw.persistence.util.Jpa;
import es.uniovi.asw.reportwriter.Level;

public class InsertP implements Insert {

	private WreportR writeReport = new WreportR();	
	
	private final static InsertP INSTANCE = null;
	
	private InsertP(){		
	}
	
	public static InsertP getInstance() {
		if (INSTANCE == null) {
			return new InsertP();
		}
		else {
			return INSTANCE;
		}
	}
	
	@Override
	public List<Citizen> insert(List<Citizen> listaCiudadanos, String fichero) {
		List<Citizen> insertados = new ArrayList<Citizen>();
		for(Citizen c: listaCiudadanos) {
			Citizen aux = CitizenFinder.findByDni(c.getDni());
			
			if(aux == null) {
				User ususario = c.getUser();
				Jpa.getManager().persist(c);
				Jpa.getManager().persist(ususario);
				insertados.add(c);
			}
			else {				
				String error = "No se puede introducir el ciudadano con dni "+ c.getDni() + " porque ya está cargado en la base de datos";
				writeReport.report(error, fichero, Level.ERROR);
			}
		}
		return insertados;
	}
	
}