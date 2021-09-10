package edu.awieclawski.service;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class HibernateTransaction {
	private final static Logger LOGGER = Logger.getLogger(HibernateTransaction.class.getName());

	public void doSaveEntity(Object entity) {
		Transaction transaction = null;
		try (Session session = HibernateService.getSessionFactory(entity).openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.save(entity);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			LOGGER.log(Level.SEVERE, entity + " error in HibernateTransaction " + transaction + "|" + e.getMessage());
//			e.printStackTrace();

		}
	}

}
