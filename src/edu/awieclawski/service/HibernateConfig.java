package edu.awieclawski.service;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.AnnotationException;
import org.hibernate.cfg.Configuration;

import edu.awieclawski.base.AllowedEntities;
import edu.awieclawski.base.BaseEntity;

/**
 * 
 * instead of persistence.xml
 * 
 * @author AWieclawski
 *
 */
public class HibernateConfig {
	private final static Logger LOGGER = Logger.getLogger(HibernateConfig.class.getName());

	Configuration getHibernateConfigWithAnnotatedClass(Configuration configuration) {
		if (configuration != null) {

			/**
			 * Necessary loop to operate joined Entities
			 * https://docs.jboss.org/hibernate/annotations/3.5/reference/en/html/ch01.html
			 */
			for (Class<? extends BaseEntity> clazz : AllowedEntities.getEntityClassesList())
				try {
					configuration.addAnnotatedClass(clazz);

				} catch (AnnotationException a) {
					LOGGER.log(Level.SEVERE, clazz + " error - Annotation Exception " + a.getMessage());
					a.printStackTrace();
				} catch (Exception e) {
					LOGGER.log(Level.SEVERE, clazz + " error in HibernateConfig " + e.getMessage());
					e.printStackTrace();
				}

		}
		return configuration;
	}

}
