package es.uniovi.asw.parser.readers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import es.uniovi.asw.model.Citizen;
import es.uniovi.asw.parser.WreportQ;
import es.uniovi.asw.reportwriter.Level;
import es.uniovi.asw.util.BusinessException;
import es.uniovi.asw.util.CitizenChecker;

public class ExcelReader implements Reader {	
	
	private WreportQ writeReport = new WreportQ();
	
	private final static String PATH = "src/main/resources/";	
	
	@Override
	public List<Citizen> read(String fichero) {
		List<Citizen> listaCiudadanos = new ArrayList<Citizen>();					
		FileInputStream file;
		XSSFWorkbook workbook;
		XSSFSheet sheet;
		Iterator<Row> rowIterator;			
		Row row;	
		
		if(comprobarExtension(fichero)) {
			try {				
				file = new FileInputStream(new File(PATH+fichero));				
				workbook= new XSSFWorkbook(file);			
				sheet = workbook.getSheetAt(0);
				rowIterator = sheet.iterator();
				rowIterator.next();
				int counter = 1;
				while(rowIterator.hasNext()) {
					counter++;
					row = rowIterator.next();					
					
					try {
						String nombre = CitizenChecker.checkNombre(row.getCell(0).getStringCellValue());
						String apellidos = CitizenChecker.checkApellidos(row.getCell(1).getStringCellValue());
						String email = CitizenChecker.checkEmail(row.getCell(2).getStringCellValue());
						Date fechaNacimiento = CitizenChecker.checkFechaNacimiento(row.getCell(3).getDateCellValue());
						String residencia = CitizenChecker.checkResidencia(row.getCell(4).getStringCellValue());
						String nacionalidad = CitizenChecker.checkNacionalidad(row.getCell(5).getStringCellValue());
						String dni = CitizenChecker.checkDni(row.getCell(6).getStringCellValue());					
						
						Citizen ciudadano = new Citizen(nombre, apellidos, email, fechaNacimiento, residencia, nacionalidad, dni);
						listaCiudadanos.add(ciudadano);
					} catch (BusinessException e) {
						String error = "Error de lectura de los datos en la fila "+counter;
						writeReport.report(error, fichero, Level.ERROR);						
					} catch (Exception e) {
						String error = "Error de lectura de los datos en la fila "+counter;
						writeReport.report(error, fichero, Level.ERROR);						
					}					
				}				
			} catch (FileNotFoundException e) {
				String error = "No existe el fichero especificado";
				writeReport.report(error, fichero, Level.FATAL);				
			} catch (IOException e) {
				String error = "No se puede acceder al fichero especificado, puede que esté abierto";
				writeReport.report(error, fichero, Level.FATAL);					
			} catch (Exception e) {				
				String error = "Se ha producido un error irrecuperable";
				writeReport.report(error, fichero, Level.FATAL);	
			}
		}		
				
		return listaCiudadanos;
	}
	
	@Override
	public boolean comprobarExtension(String path) {			
		return  path.split("\\.")[1].equals("xlsx") ? true : false;
	}	
}