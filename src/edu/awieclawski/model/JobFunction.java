package edu.awieclawski.model;

import java.io.Serializable;

import edu.awieclawski.base.BaseEntity;
import edu.awieclawski.label.JobFunctionLabel;

public class JobFunction extends BaseEntity implements Serializable, JobFunctionLabel {

	private static final long serialVersionUID = 7931934861961047663L;

	private long jobId;

	private String jobName;

	private Boolean isSupervisor;

	// default constructor MUST BE
	public JobFunction() {
	}

	public JobFunction(String jobName, Boolean isSupervisor) {
		this.jobName = jobName;
		this.isSupervisor = isSupervisor;
	}

	// getters & setters

	public long getJobId() {
		return jobId;
	}

	public void setJobId(long jobId) {
		this.jobId = jobId;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public Boolean getIsSupervisor() {
		return isSupervisor;
	}

	public void setIsSupervisor(Boolean isSupervisor) {
		this.isSupervisor = isSupervisor;
	}

	@Override
	public String toString() {
		return "JobFunction [jobId=" + jobId + ", jobName=" + jobName + ", isSupervisor=" + isSupervisor + "]";
	}

	// Label getters

	@Override
	public String getJobNameLabel() {
		return jobNameLabel;
	}

	@Override
	public String getIsSupervisorLabel() {
		return isSupervisorLabel;
	}

	// Marks

	@Override
	public int getEntityTypeId() {
		return entityTypeId;
	}

	@Override
	public String getEntityUploadPath() {
		return entityUploadPath;
	}

	@Override
	public String getEntityListPath() {
		return entityListPath;
	}

	@Override
	public String getEntityHeaderName() {
		return entityHeaderName;
	}

	@Override
	public String getEntityTypeMark() {
		return entityTypeMark;
	}

}
