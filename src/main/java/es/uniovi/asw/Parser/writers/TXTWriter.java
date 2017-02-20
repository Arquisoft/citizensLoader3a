package es.uniovi.asw.Parser.writers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import es.uniovi.asw.model.Ciudadano;

public class TXTWriter implements Writer {

	private final static String PATH = "src/test/resources/emails/";
	
	@Override
	public void write(Ciudadano ciudadano) {		
		BufferedWriter bw = null;
		String direccion = PATH + ciudadano.getUsuario().getUsuario() + ".txt";
		try{
			bw = new BufferedWriter(new FileWriter(direccion));
			bw.write("Hola " + ciudadano.getNombre() + " " + ciudadano.getApellidos());
			bw.write("Este correo es para informarle de que ha sido dado de alta correctamente en el sistema de participación "
					+ "ciudadana. A continuación le comunicamos su usuario y contraseña: \n");
			bw.write("\tUsuario: "+ ciudadano.getUsuario().getUsuario() + "\n");
			bw.write("\tContraseña: "+ ciudadano.getUsuario().getContraseña());
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			if(bw != null){
				try{
					bw.close();
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		}		
	}
}