package es.uniovi.asw.parser.writers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import es.uniovi.asw.model.Ciudadano;
import es.uniovi.asw.util.Console;

public class WORDWriter implements Writer {

	private final static String PATH = "src/main/resources/emails/";	
	
	@SuppressWarnings("resource")
	@Override
	public void write(Ciudadano ciudadano) {		
		XWPFDocument documento;
		FileOutputStream out;
		XWPFParagraph parrafo;
		XWPFRun run;
		
		try {
			documento =  new XWPFDocument();
			out = new FileOutputStream(new File(PATH+ciudadano.getDni()+".docx"));
			parrafo = documento.createParagraph();
			parrafo.setAlignment(ParagraphAlignment.BOTH);
			run = parrafo.createRun();
			
			run.setText("Hola " + ciudadano.getNombre() + " " + ciudadano.getApellidos());
			run.addCarriageReturn();
			run.addCarriageReturn();
			run.setText("Este correo es para informarle de que ha sido dado de alta correctamente en el sistema de participación " + 
					"ciudadana. A continuación, le comunicamos su usuario y contraseña:");
			run.addCarriageReturn();
			run.addCarriageReturn();
			run.addTab();
			run.setText("Usuario: "+ ciudadano.getUsuario().getUsuario());
			run.addCarriageReturn();
			run.addTab();
			run.setText("Contraseña: "+ ciudadano.getUsuario().getContraseña());
			
			documento.write(out);
		} catch (IOException e) {
			Console.println("Error en WordWriter, no se pude escribir el fichero");
		}			
	}
}