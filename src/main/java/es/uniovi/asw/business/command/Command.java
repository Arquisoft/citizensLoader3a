package es.uniovi.asw.business.command;

import es.uniovi.asw.util.BusinessException;

public interface Command<T> {

	T execute() throws BusinessException;

}