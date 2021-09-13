package edu.awieclawski.dao;

import edu.awieclawski.base.BaseEntity;
import edu.awieclawski.service.ErrorService;
import edu.awieclawski.session.HibernateTransaction;

/**
 * Universal DAO for BaseEntity class heirs
 * 
 * @author AWieclawski
 *
 */
public class EntitiesDao {

	public ErrorService saveAddress(BaseEntity entity) {
		return getHibernateTransaction().doSaveEntity(entity);
	}

	private HibernateTransaction getHibernateTransaction() {
		return new HibernateTransaction();
	}

}
