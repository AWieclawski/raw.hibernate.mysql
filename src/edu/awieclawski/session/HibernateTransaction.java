package edu.awieclawski.session;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.awieclawski.service.ErrorService;

/**
 * 
 * @author AWieclawski
 *
 */
public class HibernateTransaction {
	private final static Logger LOGGER = Logger.getLogger(HibernateTransaction.class.getName());

	public ErrorService doSaveEntity(Object entity) {
		ErrorService errorService = new ErrorService();
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
				errorService = rollTransaction(transaction, entity);
			}
			errorService.setCALLOUT_INV_LOG(e.getMessage());
			LOGGER.log(Level.SEVERE, " Error in HibernateTransaction " + transaction + ", entity="
					+ (entity != null ? entity.toString() : entity));
			e.printStackTrace();

		}
		return errorService;
	}

	/**
	 * 
	 * @param transaction
	 * @param entity
	 */
	private ErrorService rollTransaction(Transaction transaction, Object entity) {
		ErrorService errorService = new ErrorService();
		try {
			transaction.rollback();
		} catch (Exception e) {
			errorService.setCALLOUT_INV_LOG(e.getMessage());
			LOGGER.log(Level.SEVERE, " Error during Transaction  rollback " + transaction + ", entity="
					+ (entity != null ? entity.toString() : entity));
			e.printStackTrace();
		}
		return errorService;
	}

}
