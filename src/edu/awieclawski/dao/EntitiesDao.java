package edu.awieclawski.dao;

import edu.awieclawski.base.BaseEntity;
import edu.awieclawski.service.HibernateTransaction;

/**
 * Universal DAO for BaseEntity class heirs
 * 
 * @author AWieclawski
 *
 */
public class EntitiesDao {

	public void saveAddress(BaseEntity entity) {
		getHibernateTransaction().doSaveEntity(entity);
	}

	private HibernateTransaction getHibernateTransaction() {
		return new HibernateTransaction();
	}

}
