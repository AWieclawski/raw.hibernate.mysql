package edu.awieclawski.dao;

import java.util.Map;

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

	public ErrorService saveAddress(BaseEntity entity, Map<String, BaseEntity> recordsMap) {
		return getHibernateTransaction().doSaveEntity(entity, recordsMap);
	}

	private HibernateTransaction getHibernateTransaction() {
		return new HibernateTransaction();
	}

}
