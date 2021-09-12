package edu.awieclawski.base;

/**
 * getters for transient fields to be inherited by entities
 * 
 * @author AWieclawski
 *
 */
public abstract class BaseEntity {

	// Common entity getters
	public abstract int getEntityTypeId();

	public abstract String getEntityUploadPath();
	
	public abstract String getEntityListPath();

	public abstract String getEntityHeaderName();

	public abstract String getEntityTypeMark();

}
