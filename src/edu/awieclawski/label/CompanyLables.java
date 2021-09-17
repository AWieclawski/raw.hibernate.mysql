package edu.awieclawski.label;

public interface CompanyLables {

	// Company marks

	public final int entityTypeId = 3;

	public final String entityTypeMark = "CMP";

	public final String entityHeaderName = "Company";

	public final String entityUploadPath = "/upcompany"; // used as upload webservlet parameter

	public static final String entityListPath = "/companylist"; // used as display all webservlet parameter

	// Company labels

	public static final String taxIdLabel = "Taxpayer Identification Number";

	public static final String companyNameLabel = "Company name";

	public static final String addressRecordLabel = "Address record";

	// Label getters

	public String getTaxIdLabel();

	public String getCompanyNameLabel();

	public String getAddressRecordLabel();

}
