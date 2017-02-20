package es.uniovi.asw.DBUpdate;

import java.util.List;

import es.uniovi.asw.model.Ciudadano;
import es.uniovi.asw.model.Usuario;
import es.uniovi.asw.persistence.CiudadanoFinder;
import es.uniovi.asw.persistence.util.Jpa;

public class InsertP implements Insert {

	@Override
	public void insert(List<Ciudadano> listaCiudadanos) {
		for(Ciudadano c: listaCiudadanos) {
			Ciudadano aux = CiudadanoFinder.findByDni(c.getDni());
			
			if(aux != null) {
				Usuario ususario = aux.getUsuario();
				Jpa.getManager().persist(c);
				Jpa.getManager().persist(ususario);
			}
			else {
//				Log de qeu no se puede añadir ya que esta añadido
				System.err.println("esta mal");
			}
		}
	}
}