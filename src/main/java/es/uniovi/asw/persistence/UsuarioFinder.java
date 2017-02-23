package es.uniovi.asw.persistence;

import java.util.List;

import es.uniovi.asw.model.Usuario;
import es.uniovi.asw.persistence.util.Jpa;

public class UsuarioFinder {
	
	public static Usuario findUsuarioByUserAndPassword(String user, String passw){
		List<Usuario> usuarios = Jpa.getManager().
				createNamedQuery("Usuario.findByUserAndPassword", Usuario.class)
				.setParameter(1, user).setParameter(2, passw).getResultList();
		
		return usuarios.isEmpty() ? null : usuarios.get(0);
	}
}
