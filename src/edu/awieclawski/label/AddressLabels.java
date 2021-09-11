package edu.awieclawski.label;

/**
 * Fields used:
 * 
 * Label as jsp presentation
 * 
 * Link as upload servlet path
 * 
 * Mark as doc indexing element
 * 
 * @author AWieclawski
 *
 */
public interface AddressLabels {

	// Address marks

	public final int entityTypeId = 1;

	public final String entityTypeMark = "ADR";

	public final String entityHeaderName = "Address";

	public final String entityLink = "upaddress";

	// Address labels

	public final String countryLabel = "Country";

	public final String addressNameLabel = "Address name";

	public final String cityLabel = "City";

	public final String postalCodeLabel = "Postal code";

	public final String streetNameLabel = "Street name";

	public final String streetNumberLabel = "Street number";

	public final String flatNumberLabel = "Flat number";

	// Address label getters

	public String getCountryLabel();

	public String getAddressNameLabel();

	public String getCityLabel();

	public String getPostalCodeLabel();

	public String getStreetNameLabel();

	public String getStreetNumberLabel();

	public String getFlatNumberLabel();

}
