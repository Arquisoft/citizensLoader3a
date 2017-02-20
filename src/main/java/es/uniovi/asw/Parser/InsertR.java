package es.uniovi.asw.Parser;

import java.util.List;

import es.uniovi.asw.DBUpdate.Insert;
import es.uniovi.asw.DBUpdate.InsertP;
import es.uniovi.asw.business.command.Command;
import es.uniovi.asw.business.command.CommandExecutor;
import es.uniovi.asw.model.Ciudadano;
import es.uniovi.asw.util.BusinessException;

public class InsertR implements Insert {	
	
	@Override
	public void insert(final List<Ciudadano> ciudadanos, final String fichero) {		
		try {
			new CommandExecutor<Void>().execute(new Command<Void>() {
				@Override
				public Void execute() throws BusinessException {
					new InsertP().insert(ciudadanos, fichero);
					return null;
				}
			});
		} catch (BusinessException e) {

		}
	}
}