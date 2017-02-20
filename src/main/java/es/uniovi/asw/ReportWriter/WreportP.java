package es.uniovi.asw.ReportWriter;

import org.apache.log4j.Logger;

public class WreportP implements WriteReport {

	private static Logger log = Logger.getLogger("CitizensLogger");
	
	@Override
	public void report(String error, String fichero, Level nivel) {
		switch (nivel) {
			case TRACE: log.trace(error);
			case DEBUG: log.debug(error);
			case INFO: log.info(error);
			case WARN: log.info(error);
			case ERROR: log.error("Se ha producido el siguiente error en el fichero "+ fichero +": " + error);
			case FATAL: log.fatal("Se ha producido el siguiente error en el fichero "+ fichero +": " + error);
		}		
	}	
}