package edu.awieclawski.model;

import java.io.Serializable;
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

import org.hibernate.annotations.ColumnDefault;

import edu.awieclawski.base.BaseEntity;
import edu.awieclawski.label.AddressLabels;

//import javax.validation.constraints.Pattern;

@Entity
@Table(name = "addresses")

@NamedQueries({

		@NamedQuery(name = "Address.findById", query = "SELECT a FROM Address a WHERE a.addressId = :id"),

		@NamedQuery(name = "Address.findByCity", query = "SELECT a FROM Address a WHERE a.city = :city"),

		@NamedQuery(name = "Address.findByCode", query = "SELECT a FROM Address a WHERE a.postalCode = :code"),

		@NamedQuery(name = "Address.findByCountry", query = "SELECT a FROM Address a WHERE a.country = :country"),

})

/**
 * Heir of BaseEntity class
 * 
 * has label and mark fields, that are transient for Hibernate
 * 
 * @author AWieclawski
 *
 */
public class Address extends BaseEntity implements Serializable, AddressLabels {
	private static final long serialVersionUID = -3776095967033917869L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "addr_id")
	private long addressId;

	@Column(updatable = true, name = "addr_name", nullable = true, length = 50)
	private String addressName;

	@ColumnDefault(value = "'Poland'")
	@Column(updatable = true, name = "country", nullable = false, length = 50)
	private String country; // = "Poland";

	@Column(updatable = true, name = "city", nullable = false, length = 50)
	private String city;

//	@Pattern(regexp = "[0-9]{2}(-[0-9]{3})?", message = "not a valid zipcode")
	@Column(updatable = true, name = "post_cod", nullable = false, length = 6)
	private String postalCode;

	@Column(updatable = true, name = "street", nullable = false, length = 50)
	private String streetName;

	@Column(updatable = true, name = "str_no", nullable = false, length = 6)
	private String streetNumber;

	@Column(updatable = true, name = "flat_no", nullable = true, length = 6)
	private String flatNumber;

	// standard constructor
	public Address() {
	}

	// getters & setters
	public long getAddressId() {
		return addressId;
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	public String getAddressName() {
		return addressName;
	}

	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getFlatNumber() {
		return flatNumber;
	}

	public void setFlatNumber(String flatNumber) {
		this.flatNumber = flatNumber;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", addressName=" + addressName + ", country=" + country + ", city="
				+ city + ", postalCode=" + postalCode + ", streetName=" + streetName + ", streetNumber=" + streetNumber
				+ ", flatNumber=" + flatNumber + "]";
	}

	// Label getters - order is important!

	@Override
	public String getAddressNameLabel() {
		return addressNameLabel;
	}

	@Override
	public String getCountryLabel() {
		return countryLabel;
	}

	@Override
	public String getCityLabel() {
		return cityLabel;
	}

	@Override
	public String getPostalCodeLabel() {
		return postalCodeLabel;
	}

	@Override
	public String getStreetNameLabel() {
		return streetNameLabel;
	}

	@Override
	public String getStreetNumberLabel() {
		return streetNumberLabel;
	}

	@Override
	public String getFlatNumberLabel() {
		return flatNumberLabel;
	}

	// transient base entity getters

	@Override
	public int getEntityTypeId() {
		return entityTypeId;
	}

	@Override
	public String getEntityTypeMark() {
		return entityTypeMark;
	}

	@Override
	public String getEntityHeaderName() {
		return entityHeaderName;
	}

	@Override
	public String getEntityUploadPath() {
		return entityUploadPath;
	}

	@Override
	public String getEntityListPath() {
		return entityListPath;
	}

	// Labels order

	@Override
	public Map<String, String> getLabelsOrder() {
		Map<String, String> map = new LinkedHashMap<>() {
			private static final long serialVersionUID = -8458858973241099586L;
			// order is important
			{
				put("addressName", addressNameLabel);
				put("country", countryLabel);
				put("city", cityLabel);
				put("postalCode", postalCodeLabel);
				put("streetName", streetNameLabel);
				put("streetNumber", streetNumberLabel);
				put("flatNumber", flatNumberLabel);
			}
		};
		return map;
	}

}
