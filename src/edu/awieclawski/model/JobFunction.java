package edu.awieclawski.model;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import edu.awieclawski.base.BaseEntity;
import edu.awieclawski.label.JobFunctionLabel;

@Entity
@Table(name = "jobs")
@NamedQueries({

		@NamedQuery(name = "JobFunction.findById", query = "SELECT j FROM JobFunction j WHERE j.jobId = :id"),

		@NamedQuery(name = "JobFunction.findByName", query = "SELECT j FROM JobFunction j WHERE j.jobName = :name"),

		@NamedQuery(name = "JobFunction.findBySup", query = "SELECT j FROM JobFunction j WHERE j.isSupervisor = :sup"),

})

public class JobFunction extends BaseEntity implements Serializable, JobFunctionLabel {

	private static final long serialVersionUID = 7931934861961047663L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "job_id")
	private long jobId;

	@Column(updatable = true, name = "name", nullable = false, length = 50)
	private String jobName;

	@Column(updatable = true, name = "is_sup", nullable = false)
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
//		return "JobFunction [jobId=" + jobId + ", jobName=" + jobName + ", isSupervisor=" + isSupervisor + "]";
		return "JobFunction [crtnIndx=" + crtnIndx + "]";
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

	// Labels order
	@Override
	public Map<String, String> getLabelsOrder() {
		Map<String, String> map = new LinkedHashMap<>() {
			private static final long serialVersionUID = -2358858973241099543L;
			// order is important
			{
				put("jobName", jobNameLabel);
				put("isSupervisor", isSupervisorLabel);
			}
		};
		return map;
	}

	// unique index of creation
	private String crtnIndx = getEntityTypeMark() + separator + ZonedDateTime.now().toInstant().toEpochMilli();

	@Override
	public String getCrtnIndx() {
		return crtnIndx;
	}

}
