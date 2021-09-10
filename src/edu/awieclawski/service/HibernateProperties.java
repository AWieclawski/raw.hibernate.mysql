package edu.awieclawski.service;

import java.util.Properties;

import org.hibernate.cfg.Environment;

/**
 * instead of persistence.xml
 * 
 * @author AWieclawski
 *
 */
public class HibernateProperties {
	private final static String M_USER = "javapp";
	private final static String M_PASS = "1234";
	private final static String M_PORT = "3333";
	private final static String M_DBNAME = "appdb";
	private final static String M_CONNCONF = "allowPublicKeyRetrieval=true&useSSL=false";

	Properties getProperties() {
		// Hibernate settings equivalent to hibernate.cfg.xml's properties
		Properties settings = new Properties();
		settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
		settings.put(Environment.URL, "jdbc:mysql://localhost:" + M_PORT + "/" + M_DBNAME + "?" + M_CONNCONF);
		settings.put(Environment.USER, M_USER);
		settings.put(Environment.PASS, M_PASS);
		settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");

		settings.put(Environment.SHOW_SQL, "true");

		settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

		settings.put(Environment.HBM2DDL_AUTO, "update");
		return settings;
	}

}
