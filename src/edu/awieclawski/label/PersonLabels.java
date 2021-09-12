package edu.awieclawski.label;

/**
 * Fields used:
 * 
 * Label as jsp presentation
 * 
 * UploadPath as upload servlet path
 * 
 * Mark as doc indexing element
 * 
 * @author AWieclawski
 *
 */
public interface PersonLabels {

	// Person marks

	public final int entityTypeId = 2;

	public final String entityTypeMark = "PRN";

	public final String entityHeaderName = "Person";

	public final String entityUploadPath = "/upperson"; // used as upload webservlet parameter

	public static final String entityListPath = "/personlist"; // used as display all webservlet parameter

	// Person labels

	public String govermentIdLabel = "Government id";

	public String firstNameLabel = "First name";

	public String lastNameLabel = "Name label";

	public String birthDateLabel = "Birth date";

	public String addressLabel = "Address record";

	// Person label getters

	public String getGovermentIdLabel();

	public String getFirstNameLabel();

	public String getLastNameLabel();

	public String getBirthDateLabel();

	public String getAddressLabel();

}
