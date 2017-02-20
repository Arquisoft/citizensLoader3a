package es.uniovi.asw.Parser;

import java.util.List;

import org.apache.commons.lang.RandomStringUtils;

import es.uniovi.asw.Parser.readers.Reader;
import es.uniovi.asw.Parser.writers.Writer;
import es.uniovi.asw.model.Association;
import es.uniovi.asw.model.Ciudadano;
import es.uniovi.asw.model.Usuario;

public class RList implements ReadList {

	private List<Ciudadano> ciudadanos;
	private Reader reader;
	private Writer writer;	
	
	public void setReader(Reader reader) {
		this.reader = reader;
	}
	
	public void setWriter(Writer writer) {
		this.writer = writer;
	}

	@Override
	public List<Ciudadano> read(String fichero) {	
		ciudadanos = reader.read(fichero);
		crearUsuarios(ciudadanos);
		crearEmail(ciudadanos);
		return ciudadanos;
	}
	
	private void crearUsuarios(List<Ciudadano> listaCiudadanos) {
		for(Ciudadano c: listaCiudadanos) {
			String usuario = generarUsuario(c);
			String contraseña = generarContraseña(c);
			Usuario u = new Usuario(usuario, contraseña, c);
			Association.Asignar.link(u, c);
		}
	}
	
	private String generarUsuario(Ciudadano ciudadano) {
		return ciudadano.getNombre() + RandomStringUtils.randomAlphanumeric(4);
	}
	
	private String generarContraseña(Ciudadano ciudadano) {
		return RandomStringUtils.randomAlphabetic(4) + RandomStringUtils.randomAlphanumeric(4);
	}
	
	private void crearEmail(List<Ciudadano> listaCiudadanos) {
		for(Ciudadano c: listaCiudadanos) {
			writer.write(c);
		}		
	}
}