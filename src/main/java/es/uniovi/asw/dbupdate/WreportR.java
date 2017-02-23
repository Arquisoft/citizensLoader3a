package es.uniovi.asw.dbupdate;

import es.uniovi.asw.reportwriter.Level;
import es.uniovi.asw.reportwriter.WreportP;
import es.uniovi.asw.reportwriter.WriteReport;

public class WreportR implements WriteReport {

	@Override
	public void report(String error, String fichero, Level nivel) {
		WreportP.getInstance().report(error, fichero, nivel);
	}
	
}