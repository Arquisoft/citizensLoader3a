package es.uniovi.asw;

import es.uniovi.asw.Parser.RList;
import es.uniovi.asw.Parser.readers.ExcelReader;
import es.uniovi.asw.Parser.readers.Reader;
import es.uniovi.asw.Parser.writers.TXTWriter;
import es.uniovi.asw.Parser.writers.WordWriter;
import es.uniovi.asw.Parser.writers.Writer;
import es.uniovi.asw.util.Console;

public class Application {

	public static void main (String[] args){		
		
		RList rList;
		
		Reader reader = null;
		Writer writer = null;	
		String fichero;
		String formatoCorreo;
	
		Console.println("Bienvenido a citizensLoader3a");
		Console.println();	
		
		//Para coger un fichero de formato correcto
		do {
			Console.println("Introduzca el nombre de un fichero con extensión correcta (.xlsx): ");
			fichero = Console.readString();
			reader = comprobarReader(fichero);
			if(reader == null) {
				Console.print("Formato de fichero incorrecto, recuerde que el formato del fichero debe ser"
						+ " alguno de los siguientes: .xlsx\n");
			}
			
		} while (reader == null);
		
		//Para coger un formato correcto de correo
		do {
			Console.println("Introduzca el formato en el que desea que se le envie los correos a los usuarios (txt, docx): ");
			formatoCorreo = Console.readString();
			writer = comprobarWriter(formatoCorreo);
			if (writer == null) {
				Console.print("Formato de correo incorrecto, recuerde que el formato del correo debe ser"
						+ " alguno de los siguientes: txt, docx\n");
			}
			
		} while (writer == null);
		
		
		//Para ejecutar la aplicación
		if (reader != null && writer != null) {
			rList = new RList();
			rList.setReader(reader);
			rList.setWriter(writer);
			rList.read(fichero);			
		}			
	}
	
	public static Reader comprobarReader (String fichero) {
		if (fichero.split("\\.")[1].equals("xlsx")){
			return new ExcelReader();
		} 
		//Segun tengamos más tipos de readers se añadirían aquí
		return null;
	}
	
	public static Writer comprobarWriter (String formatoCorreo) {
		if (formatoCorreo.equalsIgnoreCase("TXT")) {
			return new TXTWriter();
		}
		else if (formatoCorreo.equalsIgnoreCase("DOCX")) {
			return new WordWriter();
		}
		//Según tengamos más tipo de writers se añadirían aquí
		return null;
	}
}