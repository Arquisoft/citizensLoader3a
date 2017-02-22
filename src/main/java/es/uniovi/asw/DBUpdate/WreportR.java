package es.uniovi.asw.DBUpdate;

import es.uniovi.asw.ReportWriter.Level;
import es.uniovi.asw.ReportWriter.WreportP;
import es.uniovi.asw.ReportWriter.WriteReport;

public class WreportR implements WriteReport {

	@Override
	public void report(String error, String fichero, Level nivel) {
		WreportP.getInstance().report(error, fichero, nivel);
	}
	
}