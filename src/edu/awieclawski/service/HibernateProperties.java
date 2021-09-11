package edu.awieclawski.service;

import java.util.Properties;

import org.hibernate.cfg.Environment;

/**
 * instead of persistence.xml
 * 
 * @author AWieclawski
 *
 */
public class HibernateProperties implements PropertiesHibernate {

	Properties getProperties() {
		// Hibernate settings equivalent to hibernate.cfg.xml's properties
		Properties settings = new Properties();
		settings.put(Environment.DRIVER, M_DRIVER);
		settings.put(Environment.URL, M_JDBC + "://" + M_IP + ":" + M_PORT + "/" + M_DBNAME + "?" + M_CONNPARAM);
		settings.put(Environment.USER, M_USER);
		settings.put(Environment.PASS, M_PASS);
		settings.put(Environment.DIALECT, M_DIALECT);

		settings.put(Environment.SHOW_SQL, "true");

		settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

		settings.put(Environment.HBM2DDL_AUTO, M_DDLMODE);
		return settings;
	}

}
