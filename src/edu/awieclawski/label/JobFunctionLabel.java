package edu.awieclawski.label;

public interface JobFunctionLabel {

	// JobFunction marks

	public final int entityTypeId = 4;

	public final String entityTypeMark = "JBF";

	public final String entityHeaderName = "Job Function";

	public static final String entityUploadPath = "/upjobfunction"; // used as upload webservlet parameter

	public static final String entityListPath = "/jobfunctionlist"; // used as display all webservlet parameter

	// JobFunction labels

	public final static String jobNameLabel = "Job name";

	public final static String isSupervisorLabel = "Supervisor";

	// JobFunction getters

	public String getJobNameLabel();

	public String getIsSupervisorLabel();

}
