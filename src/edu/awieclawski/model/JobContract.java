package edu.awieclawski.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import edu.awieclawski.base.BaseEntity;
import edu.awieclawski.label.JobContractLabels;

public class JobContract extends BaseEntity implements Serializable, JobContractLabels {

	private static final long serialVersionUID = -2756167856683541268L;

	private long contractId;

	private String contractName;

	private Date contractStarts;

	private Date contractEnds;

	private BigDecimal salary;

	private Company companyRecord;

	private Person personRecord;

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
		return "JobContract [contractId=" + contractId + ", contractName=" + contractName + ", contractStarts="
				+ contractStarts + ", contractEnds=" + contractEnds + ", salary=" + salary + ", company="
				+ companyRecord + ", employee=" + personRecord + ", job=" + jobFunctionRecord + "]";
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

	// Label getters

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

}
