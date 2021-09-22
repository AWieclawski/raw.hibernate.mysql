package edu.awieclawski.base;

import java.util.Map;

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
	
	// to override by label interface
	
	public abstract Map<String, String> getLabelsOrder();
	

}
