package es.uniovi.asw.DBUpdate;

import java.util.ArrayList;
import java.util.List;

import es.uniovi.asw.ReportWriter.Level;
import es.uniovi.asw.model.Ciudadano;
import es.uniovi.asw.model.Usuario;
import es.uniovi.asw.persistence.CiudadanoFinder;
import es.uniovi.asw.persistence.util.Jpa;

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
	public List<Ciudadano> insert(List<Ciudadano> listaCiudadanos, String fichero) {
		List<Ciudadano> insertados = new ArrayList<Ciudadano>();
		for(Ciudadano c: listaCiudadanos) {
			Ciudadano aux = CiudadanoFinder.findByDni(c.getDni());
			
			if(aux == null) {
				Usuario ususario = c.getUsuario();
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