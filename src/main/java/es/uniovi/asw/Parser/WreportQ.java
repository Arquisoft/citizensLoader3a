package es.uniovi.asw.Parser;

import es.uniovi.asw.ReportWriter.Level;
import es.uniovi.asw.ReportWriter.WreportP;
import es.uniovi.asw.ReportWriter.WriteReport;

public class WreportQ implements WriteReport {

	@Override
	public void report(String error, String fichero, Level nivel) {
		WreportP.getInstance().report(error, fichero, nivel);
	}
	
}