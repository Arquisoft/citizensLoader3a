package es.uniovi.asw.Parser.writers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import es.uniovi.asw.model.Ciudadano;

public class PDFWriter implements Writer {
	
	private final static String PATH = "src/test/resources/emails/";

	@SuppressWarnings("unused")
	@Override
	public void write(Ciudadano ciudadano) {		
		try{
			Document documento = new Document();			
			PdfWriter writer = PdfWriter.getInstance(documento, new FileOutputStream(new File(PATH+ciudadano.getDni()+".pdf")));
			documento.open();
			documento.add(new Paragraph("Hola " + ciudadano.getNombre() + " " + ciudadano.getApellidos() + ","));
			documento.add(new Paragraph("Este correo es para informarle de que ha sido dado de alta correctamente en el sistema de participación "
					+ "ciudadana. A continuación, le comunicamos su usuario y contraseña: "));
			documento.add(new Paragraph("\t\tUsuario: "+ ciudadano.getUsuario().getUsuario()));
			documento.add(new Paragraph("\t\tContraseña: "+ ciudadano.getUsuario().getContraseña()));
			documento.close();			
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		} 		
	}
}
