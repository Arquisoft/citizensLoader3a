package es.uniovi.asw.persistence;

import java.util.List;

import es.uniovi.asw.model.User;
import es.uniovi.asw.persistence.util.Jpa;

public class UserFinder {
	
	public static User findUsuarioByUserAndPassword(String user, String passw){
		List<User> usuarios = Jpa.getManager().
				createNamedQuery("Usuario.findByUserAndPassword", User.class)
				.setParameter(1, user).setParameter(2, passw).getResultList();
		
		return usuarios.isEmpty() ? null : usuarios.get(0);
	}
}
