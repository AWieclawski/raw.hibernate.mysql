package edu.awieclawski.label;

public interface PersonLabels {

	// Person marks

	public final int entityTypeId = 2;

	public final String entityTypeMark = "PRN";

	public final String entityHeaderName = "Person";

	public final String entityLink = "upperson";

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
