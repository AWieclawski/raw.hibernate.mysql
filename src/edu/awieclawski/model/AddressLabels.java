package edu.awieclawski.model;

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

	public final int entityTypeId = 1;

	public final String entityTypeMark = "ADR";

	public final String entityHeaderName = "Address";

	public final String entityLink = "upaddress";

	// Address labels

	public String getCountryLabel();

	public String getAddressNameLabel();

	public String getCityLabel();

	public String getPostalCodeLabel();

	public String getStreetNameLabel();

	public String getStreetNumberLabel();

	public String getFlatNumberLabel();

}
