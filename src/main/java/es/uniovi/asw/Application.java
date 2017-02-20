package es.uniovi.asw;

import es.uniovi.asw.Parser.RList;
import es.uniovi.asw.Parser.readers.ExcelReader;
import es.uniovi.asw.Parser.readers.Reader;
import es.uniovi.asw.Parser.writers.Writer;
import es.uniovi.asw.util.Console;

public class Application {

	public static void main (String[] args){
		
//		System.out.println("Aplicación para la carga de ciudadanos");		
		
		
		RList rList;		
		
		Console.println("Bienvenido a citizensLoader3a");
		Console.println();
		Console.println("Introduzca el nombre de un fichero con extensión correcta: ");
		String fichero = Console.readString();
		Console.println();
		Console.println("Introduzca el formato en el que desea que se le envie los correos a los usuarios: ");
		String correo = Console.readString();
		
		Reader reader = comprobarReader(fichero) ;
//		Writer writer = comprobarWriter(correo);
		
		do {
			if (reader != null) {
				rList = new RList(reader);
				System.out.println(rList.read(fichero));
				Console.println("Archivo cargado correctamente");
			}
			else {
				Console.print("Formato de fichero incorrecto, recuerde que el formato del fichero debe ser"
						+ "alguno de los siguientes: .xlsx");
			}
		}
		while (reader == null /*|| writer == null*/);
			
		
		
		
	}
	
	public static Reader comprobarReader (String fichero) {
		if (fichero.split("\\.")[1].equals("xlsx")){
			return new ExcelReader();
		} 
		return null;
	}
	
	public static Writer comprobarWriter (String correo) {
		return null;
	}
}