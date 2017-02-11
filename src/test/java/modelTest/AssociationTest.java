package modelTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.uniovi.asw.Model.Ciudadano;
import es.uniovi.asw.Model.Usuario;

public class AssociationTest {

	private Ciudadano ciudadano;
	private Usuario usuario;

	@Before
	public void setUp() {
		ciudadano = new Ciudadano("Pepe", "Pérez", "pp@gmail.es", new java.util.Date(), "33586", "España", "12345678-A");
		usuario = new Usuario("Pepe", "abcd", ciudadano);
	}
	
	@Test
	public void testAsignacion(){
		assertTrue(ciudadano.getUsuario() == usuario);
		assertTrue(usuario.getCiudadano() == ciudadano);
	}
	
	@Test
	public void testAtributos(){
		assertTrue(ciudadano.getNombre().equals("Pepe"));
		assertTrue(ciudadano.getApellidos().equals("Pérez"));
		assertTrue(ciudadano.getEmail().equals("pp@gmail.es"));
		assertTrue(ciudadano.getFechaNacimiento().equals(new java.util.Date()));
		assertTrue(ciudadano.getResidencia().equals("33586"));
		assertTrue(ciudadano.getNacionalidad().equals("España"));
		assertTrue(ciudadano.getDni().equals("12345678-A"));
		
		assertTrue(usuario.getUsuario().equals("Pepe"));
		assertTrue(usuario.getContraseña().equals("abcd"));
	}
	
	@Test
	public void testDesasignados(){
		usuario.desasignar();
		
		assertTrue(ciudadano.getUsuario() == null);
		assertTrue(usuario.getCiudadano() == null);
	}


}
