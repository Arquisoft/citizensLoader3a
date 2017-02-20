package es.uniovi.asw;

import java.util.List;

import es.uniovi.asw.Parser.InsertR;
import es.uniovi.asw.Parser.RList;
import es.uniovi.asw.Parser.readers.ExcelReader;
import es.uniovi.asw.Parser.readers.Reader;
import es.uniovi.asw.Parser.writers.TXTWriter;
import es.uniovi.asw.Parser.writers.WordWriter;
import es.uniovi.asw.Parser.writers.Writer;
import es.uniovi.asw.model.Ciudadano;
import es.uniovi.asw.util.Console;

public class Application {

	public static void main (String[] args){
		
//		System.out.println("Aplicación para la carga de ciudadanos");		
		
		
		RList rList;
		InsertR insertR;
		
		Console.println("Bienvenido a citizensLoader3a");
		Console.println();
		Console.println("Introduzca el nombre de un fichero con extensión correcta (.xlsx): ");
		String fichero = Console.readString();
		Console.println();
		Console.println("Introduzca el formato en el que desea que se le envie los correos a los usuarios (txt, docx): ");
		String formatoCorreo = Console.readString();
		
		Reader reader = comprobarReader(fichero) ;
		Writer writer = comprobarWriter(formatoCorreo);
		
	
		if (reader != null && writer != null) {
			rList = new RList();
			rList.setReader(reader);
			rList.setWriter(writer);
			List<Ciudadano> lista = rList.read(fichero);
//			new InsertR().insert(lista);;
			System.out.println(rList.read(fichero));
			Console.println("Archivo cargado correctamente");
		}
		else {
			Console.print("Formato de fichero incorrecto, recuerde que el formato del fichero debe ser"
					+ "alguno de los siguientes: .xlsx");
		}		
	}
	
	public static Reader comprobarReader (String fichero) {
		if (fichero.split("\\.")[1].equals("xlsx")){
			return new ExcelReader();
		} 
		return null;
	}
	
	public static Writer comprobarWriter (String formatoCorreo) {
		if (formatoCorreo.equalsIgnoreCase("TXT")) {
			return new TXTWriter();
		}
		else if (formatoCorreo.equalsIgnoreCase("DOCX")) {
			return new WordWriter();
		}
		return null;
	}
}