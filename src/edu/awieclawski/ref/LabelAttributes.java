package edu.awieclawski.ref;

/**
 * Attribute name labels to avoid mistakes between JSPs % controllers
 * 
 * @author AWieclawski
 *
 */
public enum LabelAttributes {

	ENT_MAP("Map of enties", "entityMap"), HEAD("Entity header", "head"), ACT("Form action", "action"),
	LAB_MAP("Map of labels", "labelsMap"), VAL_MAP("Map of values", "valuesMap");

	private String label;
	private String parName; // parameter name if any

	private LabelAttributes(String label, String parName) {
		this.label = label;
		this.parName = parName;
	}

	public String getLabel() {
		return label;
	}

	public String getParName() {
		return parName;
	}

}
