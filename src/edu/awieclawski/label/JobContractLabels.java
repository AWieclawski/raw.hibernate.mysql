package edu.awieclawski.label;

public interface JobContractLabels {

	// JobContract marks

	public static final int entityTypeId = 5;

	public static final String entityTypeMark = "JCT";

	public static final String entityHeaderName = "Job contract";

	public static final String entityUploadPath = "/upjobcontract"; // used as upload webservlet parameter

	public static final String entityListPath = "/jobcontractlist"; // used as display all webservlet parameter

	// Label fields

	public static final String contractNameLabel = "Contract Name";

	public static final String contractStartsLabel = "Contract Starts";

	public static final String contractEndsLabel = "Contract Ends";

	public static final String salaryLabel = "Salary";

	public static final String companyRecordLabel = "Company record";

	public static final String personRecordLabel = "Person record";

	public static final String jobFunctionRecordLabel = "Job Function Record";

	// Label getters

	public String getContractNameLabel();

	public String getContractStartsLabel();

	public String getContractEndsLabel();

	public String getSalaryLabel();

	public String getCompanyRecordLabel();

	public String getPersonRecordLabel();

	public String getJobFunctionRecordLabel();

}
