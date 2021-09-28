package edu.awieclawski.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import edu.awieclawski.base.BaseEntity;
import edu.awieclawski.label.JobContractLabels;

@Entity
@Table(name = "contracts")
@NamedQueries({

		@NamedQuery(name = "JobContract.findAll", query = "SELECT j FROM JobContract j"),

		@NamedQuery(name = "JobContract.findById", query = "SELECT j FROM JobContract j WHERE j.contractId = :id"),

})

public class JobContract extends BaseEntity implements Serializable, JobContractLabels {

	private static final long serialVersionUID = -2756167856683541268L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "contr_id")
	private long contractId;

	@Column(updatable = true, name = "contr_name", nullable = true, length = 50)
	private String contractName;

	@Column(updatable = true, name = "startdate", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date contractStarts;

	@Column(updatable = true, name = "enddate", nullable = true)
	@Temporal(TemporalType.DATE)
	private Date contractEnds;

	@Column(updatable = true, name = "salary", nullable = false, length = 22)
	private BigDecimal salary;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "comp_id", nullable = false)
	private Company companyRecord;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "pers_id", nullable = false)
	private Person personRecord;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "job_id", nullable = false)
	private JobFunction jobFunctionRecord;

	// standard no parameters constructor, must be

	public JobContract() {
	}

	public JobFunction getJobFunctionRecord() {
		return jobFunctionRecord;
	}

	public void setJobFunctionRecord(JobFunction jobFunctionRecord) {
		this.jobFunctionRecord = jobFunctionRecord;
	}

	public Person getPersonRecord() {
		return personRecord;
	}

	public void setPersonRecord(Person personRecord) {
		this.personRecord = personRecord;
	}

	public Company getCompanyRecord() {
		return companyRecord;
	}

	public void setCompanyRecord(Company companyRecord) {
		this.companyRecord = companyRecord;
	}

	public long getContractId() {
		return contractId;
	}

	public void setContractId(long contractId) {
		this.contractId = contractId;
	}

	public String getContractName() {
		return contractName;
	}

	public void setContractName(String contractName) {
		this.contractName = contractName;
	}

	public Date getContractStarts() {
		return contractStarts;
	}

	public void setContractStarts(Date contractStarts) {
		this.contractStarts = contractStarts;
	}

	public Date getContractEnds() {
		return contractEnds;
	}

	public void setContractEnds(Date contractEnds) {
		this.contractEnds = contractEnds;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
//		return "JobContract [contractId=" + contractId + ", contractName=" + contractName + ", contractStarts="
//				+ contractStarts + ", contractEnds=" + contractEnds + ", salary=" + salary + ", company="
//				+ companyRecord + ", employee=" + personRecord + ", job=" + jobFunctionRecord + "]";
		return "JobContract [crtnIndx=" + crtnIndx + "]";
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

	// Labels getters

	@Override
	public String getContractNameLabel() {
		return contractNameLabel;
	}

	@Override
	public String getContractStartsLabel() {
		return contractStartsLabel;
	}

	@Override
	public String getContractEndsLabel() {
		return contractEndsLabel;
	}

	@Override
	public String getSalaryLabel() {
		return salaryLabel;
	}

	@Override
	public String getCompanyRecordLabel() {
		return companyRecordLabel;
	}

	@Override
	public String getPersonRecordLabel() {
		return personRecordLabel;
	}

	@Override
	public String getJobFunctionRecordLabel() {
		return jobFunctionRecordLabel;
	}

	// Label order
	@Override
	public Map<String, String> getLabelsOrder() {
		Map<String, String> map = new LinkedHashMap<>() {
			private static final long serialVersionUID = 1458858973241099321L;
			// order is important
			{
				put("contractName", contractNameLabel);
				put("contractStarts", contractStartsLabel);
				put("contractEnds", contractEndsLabel);
				put("salary", salaryLabel);
				put("companyRecord", companyRecordLabel);
				put("personRecord", personRecordLabel);
				put("jobFunctionRecord", jobFunctionRecordLabel);
			}
		};
		// not yet sorted
		return map;
	}

	// unique index of creation
	private String crtnIndx = getEntityTypeMark() + separator + ZonedDateTime.now().toInstant().toEpochMilli();

	@Override
	public String getCrtnIndx() {
		return crtnIndx;
	}

}
