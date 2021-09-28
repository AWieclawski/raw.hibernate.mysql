package edu.awieclawski.ref;

/**
 * JSP page names to avoid mistakes between JSPs % controllers
 * 
 * @author AWieclawski
 *
 */
public enum ReferenceJSP {

	UP_FRM("Upload form JSP", "upform.jsp"), CON_VW("Confirm view JSP", "confirmview.jsp");

	private String label;
	private String pageName; // parameter name if any

	private ReferenceJSP(String label, String pageName) {
		this.label = label;
		this.pageName = pageName;
	}

	public String getLabel() {
		return label;
	}

	public String getPageName() {
		return pageName;
	}

}
