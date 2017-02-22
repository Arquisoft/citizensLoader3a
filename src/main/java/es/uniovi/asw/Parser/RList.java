package es.uniovi.asw.Parser;

import java.util.List;

import org.apache.commons.lang.RandomStringUtils;

import es.uniovi.asw.DBUpdate.Insert;
import es.uniovi.asw.Parser.readers.Reader;
import es.uniovi.asw.Parser.writers.Writer;
import es.uniovi.asw.business.command.Command;
import es.uniovi.asw.business.command.CommandExecutor;
import es.uniovi.asw.model.Association;
import es.uniovi.asw.model.Ciudadano;
import es.uniovi.asw.model.Usuario;
import es.uniovi.asw.util.BusinessException;

public class RList implements ReadList {
	
	private Insert insert = new InsertQ();
	
	private List<Ciudadano> ciudadanos;
	private String fichero;
	private Reader reader;
	private Writer writer;	
	
	public void setReader(Reader reader) {
		this.reader = reader;
	}
	
	public void setWriter(Writer writer) {
		this.writer = writer;
	}

	@Override
	public void read(String fichero) {	
		this.fichero = fichero;
		ciudadanos = reader.read(this.fichero);
		crearUsuarios();		
		List<Ciudadano> insertados = insertarCiudadanos(ciudadanos, fichero);
		if (insertados != null)
			crearEmail(insertados);
	}	

	private void crearUsuarios() {
		for(Ciudadano c: ciudadanos) {
			String usuario = generarUsuario(c);
			String contraseña = generarContraseña();
			Usuario u = new Usuario(usuario, contraseña, c);
			Association.Asignar.link(u, c);
		}
	}
	
	private String generarUsuario(Ciudadano ciudadano) {
		return ciudadano.getNombre() + RandomStringUtils.randomAlphanumeric(4);
	}
	
	private String generarContraseña() {
		return RandomStringUtils.randomAlphabetic(4) + RandomStringUtils.randomAlphanumeric(4);
	}
	
	private void crearEmail(List<Ciudadano> insertados) {
		for(Ciudadano c: insertados) {
			writer.write(c);
		}		
	}
	
	private List<Ciudadano> insertarCiudadanos(final List<Ciudadano> listaCiudadanos, final String fichero) {
		try {
			new CommandExecutor<List<Ciudadano>>().execute(new Command<List<Ciudadano>>() {
				@Override
				public List<Ciudadano> execute() throws BusinessException {										
					return insert.insert(listaCiudadanos, fichero);
				}
			});
		} catch (BusinessException e) {
		}
		return null;
	}
}