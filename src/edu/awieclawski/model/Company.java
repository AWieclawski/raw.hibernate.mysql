package edu.awieclawski.model;

import java.io.Serializable;

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

import edu.awieclawski.base.BaseEntity;
import edu.awieclawski.label.CompanyLables;

@Entity
@Table(name = "companies")
@NamedQueries({

		@NamedQuery(name = "Company.findByName", query = "SELECT c FROM Company c WHERE c.companyName = :name"),

		@NamedQuery(name = "Company.findById", query = "SELECT c FROM Company c WHERE c.companyId = :id"),

})

public class Company extends BaseEntity implements Serializable, CompanyLables {

	private static final long serialVersionUID = -5039546866289007641L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "comp_id")
	private long companyId;

	@Column(updatable = true, name = "tax_id", nullable = false, length = 10, unique = true)
	private String taxId;

	@Column(updatable = true, name = "comp_name", nullable = false, length = 50)
	private String companyName;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "addr_id", nullable = false)
	private Address addressRecord;

	// default constructor MUST BE
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
