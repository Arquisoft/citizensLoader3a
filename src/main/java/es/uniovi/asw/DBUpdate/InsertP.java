package es.uniovi.asw.DBUpdate;

import java.util.List;

import es.uniovi.asw.ReportWriter.Level;
import es.uniovi.asw.model.Ciudadano;
import es.uniovi.asw.model.Usuario;
import es.uniovi.asw.persistence.CiudadanoFinder;
import es.uniovi.asw.persistence.util.Jpa;

public class InsertP implements Insert {

	private WreportR report = new WreportR();
	
	@Override
	public void insert(List<Ciudadano> listaCiudadanos, String fichero) {
		for(Ciudadano c: listaCiudadanos) {
			Ciudadano aux = CiudadanoFinder.findByDni(c.getDni());
			
			if(aux == null) {
				Usuario ususario = c.getUsuario();
				Jpa.getManager().persist(c);
				Jpa.getManager().persist(ususario);
			}
			else {				
				String error = "No se puede introducir el ciudadano con dni "+ c.getDni() + " porque ya está cargado en la base de datos";
				report.report(error, fichero, Level.ERROR);
			}
		}
	}
}