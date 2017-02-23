package es.uniovi.asw.parser;

import java.util.List;

import org.apache.commons.lang.RandomStringUtils;

import es.uniovi.asw.business.command.Command;
import es.uniovi.asw.business.command.CommandExecutor;
import es.uniovi.asw.model.Association;
import es.uniovi.asw.model.Ciudadano;
import es.uniovi.asw.model.Usuario;
import es.uniovi.asw.parser.readers.Reader;
import es.uniovi.asw.parser.writers.Writer;
import es.uniovi.asw.util.BusinessException;

public class RList implements ReadList {
	
	private InsertQ insert = new InsertQ();
	
	private List<Ciudadano> ciudadanos;
	private List<Ciudadano> insertados;	
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
		ciudadanos = reader.read(fichero);
		crearUsuarios();		
		insertarCiudadanos(ciudadanos, fichero);
		if (this.insertados != null)
			crearEmail(this.insertados);		
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
	
	private Void insertarCiudadanos(final List<Ciudadano> listaCiudadanos, final String fichero) {		
		try {
			new CommandExecutor<Void>().execute(new Command<Void>() {
				@Override
				public Void execute() throws BusinessException {										
					insertados = insert.insert(listaCiudadanos, fichero);
					return null;					
				}
			});
		} catch (BusinessException e) {
		}
		return null;		
	}
}