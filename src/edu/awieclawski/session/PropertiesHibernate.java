package edu.awieclawski.session;

public interface PropertiesHibernate {

	final static String M_DRIVER = "com.mysql.jdbc.Driver";
	final static String M_JDBC = "jdbc:mysql";
	final static String M_USER = "javapp";
	final static String M_PASS = "1234";
	final static String M_IP = "localhost";

	final static String M_PORT = "3333";
	final static String M_DBNAME = "appdb";
	final static String M_DIALECT = "org.hibernate.dialect.MySQL8Dialect";
	final static String M_DDLMODE = "update";
	final static String M_CONNPARAM = "allowPublicKeyRetrieval=true&useSSL=false";

}
