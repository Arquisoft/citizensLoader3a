package es.uniovi.asw.Parser.readers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import es.uniovi.asw.model.Ciudadano;
import es.uniovi.asw.util.Console;

public class ExcelReader implements Reader {	
	
	private final static String PATH = "src/test/resources/";
	
	private String nombre;
	private String apellidos;
	private String email;
	private Date fechaNacimiento;
	private String residencia;
	private String nacionalidad;
	private String dni;
	
	@Override
	public List<Ciudadano> read(String fichero) {
		List<Ciudadano> listaCiudadanos = new ArrayList<>();
		if(comprobarExtension(fichero)){			
			FileInputStream file;
			XSSFWorkbook workbook;
			XSSFSheet sheet;
			Iterator<Row> rowIterator;			
			Row row;	
//			Iterator<Cell> cellIterator;
//			Cell cell;
			try {				
				file = new FileInputStream(new File(PATH+fichero));				
				workbook= new XSSFWorkbook(file);			
				sheet = workbook.getSheetAt(0);
				rowIterator = sheet.iterator();
				rowIterator.next();
				while(rowIterator.hasNext()) {
					row = rowIterator.next();					
//					cellIterator = row.cellIterator();
//					
//					while(cellIterator.hasNext()) {
//						cell = cellIterator.next();
//					}
					nombre = row.getCell(0).getStringCellValue();
					apellidos = row.getCell(1).getStringCellValue();
					email = row.getCell(2).getStringCellValue();
					fechaNacimiento = row.getCell(3).getDateCellValue();
					residencia = row.getCell(4).getStringCellValue();
					nacionalidad = row.getCell(5).getStringCellValue();
					dni = row.getCell(6).getStringCellValue();					
					
					Ciudadano ciudadano = new Ciudadano(nombre, apellidos, email, fechaNacimiento, residencia, nacionalidad, dni);
					listaCiudadanos.add(ciudadano);
				}				
			} catch (FileNotFoundException e) {
				Console.print("No existe el fichero especificado");
			} catch (IOException e) {
				Console.print("No se puede acceder al fichero especificado, puede que esté abierto");
			} catch (Exception e) {
				Console.print("Se ha producido un error irrecuperable");
			}
		}
		else {
			Console.print("Formato de fichero incorrecto, compruebe que se trata de un fichero .xlsx");
		}
		return listaCiudadanos;
	}
	
	@Override
	public boolean comprobarExtension(String path) {			
		return  path.split("\\.")[1].equals("xlsx") ? true : false;
	}

	@Override
	public void crearUsuarioPassword() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void crearEmail() {
		// TODO Auto-generated method stub
		
	}	
}