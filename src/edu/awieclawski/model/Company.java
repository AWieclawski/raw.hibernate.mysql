package edu.awieclawski.model;

import java.io.Serializable;

import edu.awieclawski.base.BaseEntity;
import edu.awieclawski.label.CompanyLables;

public class Company extends BaseEntity implements Serializable, CompanyLables {

	private static final long serialVersionUID = -5039546866289007641L;

	private long companyId;

	private String taxId;

	private String companyName;

	private Address addressRecord;

	// must be
	public Company() {
	}

	public Company(String taxId, String companyName, Address address) {
		this.taxId = taxId;
		this.companyName = companyName;
		this.addressRecord = address;
	}

	// getters & setters

	public String getTaxId() {
		return taxId;
	}

	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}

	public long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Address getAddressRecord() {
		return addressRecord;
	}

	public void setAddressRecord(Address address) {
		this.addressRecord = address;
	}

	@Override
	public String toString() {
		return "Company [companyId=" + companyId + ", taxId=" + taxId + ", companyName=" + companyName + ", address="
				+ addressRecord + "]";
	}

	// marks

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
	public String getTaxIdLabel() {
		return entityTypeMark;
	}

	@Override
	public String getCompanyNameLabel() {
		return companyNameLabel;
	}

	@Override
	public String getAddressRecordLabel() {
		return addressRecordLabel;
	}

}
