package es.uniovi.asw.ReportWriter;

import org.apache.log4j.Logger;

public class WreportP implements WriteReport {

	private static Logger log = Logger.getLogger("CitizensLogger");	
	
	private static final WriteReport INSTANCE = null;
	
	private WreportP() {		
	}
	
	public static WriteReport getInstance () {
		if (INSTANCE == null) {
			return new WreportP();
		}
		else {
			return INSTANCE;
		}
	}
	
	@Override
	public void report(String error, String fichero, Level nivel) {
		switch (nivel) {
			case TRACE: log.trace(error);
						break;
			case DEBUG: log.debug(error);
						break;
			case INFO: log.info(error);
						break;
			case WARN: log.info(error);
						break;
			case ERROR: log.error("Se ha producido el siguiente error en el fichero "+ fichero +": " + error);
						break;
			case FATAL: log.fatal("Se ha producido el siguiente error en el fichero "+ fichero +": " + error);
						break;
			default: break;
		}		
	}	
}