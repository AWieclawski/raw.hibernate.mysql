package edu.awieclawski.session;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.UnknownServiceException;

/**
 * 
 * @author AWieclawski
 *
 */
public class HibernateService {
	private final static Logger LOGGER = Logger.getLogger(HibernateService.class.getName());
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory(Object entity) {
		if (sessionFactory == null) {
			try {
				Configuration configuration = new Configuration();

				configuration.setProperties(getHibernateProperties().getProperties());
				configuration = getHibernateConfig().getHibernateConfigWithAnnotatedClass(configuration);

				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();

				LOGGER.log(Level.WARNING, "Hibernate Java Config serviceRegistry created for entity " + entity);

				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
				return sessionFactory;

			} catch (UnknownServiceException u) {
				LOGGER.log(Level.SEVERE, " Error - UnknownService Exception " + ", entity="
						+ (entity != null ? entity.toString() : entity));
				u.printStackTrace();
			} catch (Exception e) {
				LOGGER.log(Level.SEVERE, " Error - SessionFactory Exception " + ", entity="
						+ (entity != null ? entity.toString() : entity));
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}

	private static HibernateConfig getHibernateConfig() {
		return new HibernateConfig();
	}

	private static HibernateProperties getHibernateProperties() {
		return new HibernateProperties();
	}

}
