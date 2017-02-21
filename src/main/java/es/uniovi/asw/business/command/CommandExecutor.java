package es.uniovi.asw.business.command;

import javax.persistence.*;

import es.uniovi.asw.persistence.util.Jpa;
import es.uniovi.asw.util.BusinessException;

public class CommandExecutor<T> {

	public T execute(Command<T> cmd) throws BusinessException {
		EntityManager entityManager = Jpa.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		try {
			T object = cmd.execute();

			entityTransaction.commit();
			return object;

		} catch (BusinessException e) {
			if (entityTransaction.isActive())
				entityTransaction.rollback();
			throw e;
		} finally {
			if (entityManager.isOpen())
				entityManager.close();
		}
	}
}