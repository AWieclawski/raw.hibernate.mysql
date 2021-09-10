package edu.awieclawski.service;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.AnnotationException;
import org.hibernate.cfg.Configuration;

/**
 * 
 * instead of persistence.xml
 * 
 * @author AWieclawski
 *
 */
public class HibernateConfig {
	private final static Logger LOGGER = Logger.getLogger(HibernateConfig.class.getName());

	Configuration getHibernateConfigWithAnnotatedClass(Configuration configuration, Object clazz) {
		if (clazz != null) {
			try {
				configuration.addAnnotatedClass(clazz.getClass());
			} catch (AnnotationException a) {
				LOGGER.log(Level.SEVERE, clazz + " error - Annotation Exception " + a.getMessage());
//				a.printStackTrace();
			} catch (Exception e) {
				LOGGER.log(Level.SEVERE, clazz + " error in HibernateConfig " + e.getMessage());
//				e.printStackTrace();
			}
		}
		return configuration;
	}

}
