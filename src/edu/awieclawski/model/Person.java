package edu.awieclawski.model;

import java.io.Serializable;
import java.util.Date;

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
import edu.awieclawski.label.PersonLabels;

@Entity
@Table(name = "persons")
@NamedQueries({

		@NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p"),

		@NamedQuery(name = "Person.findById", query = "SELECT p FROM Person p WHERE p.personId = :id"),

		@NamedQuery(name = "Person.findByName", query = "SELECT p FROM Person p WHERE p.lastName = :name"),

		@NamedQuery(name = "Person.findByDate", query = "SELECT p FROM Person p WHERE p.birthDate = :date"),

})

public class Person extends BaseEntity implements Serializable, PersonLabels {
	private static final long serialVersionUID = -3263439368870615487L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pers_id")
	private long personId;

	@Column(updatable = true, name = "gov_id", nullable = false, length = 10, unique = true)
	private String govermentId;

	@Column(updatable = true, name = "surname", nullable = false, length = 50)
	private String firstName;

	@Column(updatable = true, name = "name", nullable = false, length = 50)
	private String lastName;

	@Column(updatable = true, name = "birthdate", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date birthDate;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "addr_id", nullable = false)
	private Address address;

	public long getPersonId() {
		return personId;
	}

	public void setPersonId(long personId) {
		this.personId = personId;
	}

	public String getGovermentId() {
		return govermentId;
	}

	public void setGovermentId(String govermentId) {
		this.govermentId = govermentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Person [pers_id=" + personId + ", first_name=" + firstName + ", last_name=" + lastName
				+ ", date_of_birth=" + birthDate + ", address=" + address.toString() + "]";
	}

	// Label getters

	@Override
	public String getGovermentIdLabel() {
		return govermentIdLabel;
	}

	@Override
	public String getFirstNameLabel() {
		return firstNameLabel;
	}

	@Override
	public String getLastNameLabel() {
		return lastNameLabel;
	}

	@Override
	public String getBirthDateLabel() {
		return birthDateLabel;
	}

	@Override
	public String getAddressLabel() {
		return addressLabel;
	}

	@Override
	public int getEntityTypeId() {
		return entityTypeId;
	}

	// Mark getters

	@Override
	public String getEntityLink() {
		return entityLink;
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
