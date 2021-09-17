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

	public static final String entityUploadPath = "/upperson"; // used as upload webservlet parameter

	public static final String entityListPath = "/personlist"; // used as display all webservlet parameter

	// Person labels

	public String govermentNoLabel = "Government id";

	public String firstNameLabel = "Surname";

	public String lastNameLabel = "Family Name";

	public String birthDateLabel = "Birth date";

	public String addressRecordLabel = "Address record";

	// Person label getters - order is important!

	public String getGovermentNoLabel();

	public String getFirstNameLabel();

	public String getLastNameLabel();

	public String getBirthDateLabel();

	public String getAddressRecordLabel();

}
