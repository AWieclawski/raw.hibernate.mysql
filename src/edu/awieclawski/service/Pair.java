package edu.awieclawski.service;

import java.io.Serializable;

import edu.awieclawski.base.BaseEntity;

public class Pair implements Serializable {
	private static final long serialVersionUID = 2047868779682829718L;
	private BaseEntity parent;
	private BaseEntity child;
	private Boolean isChildUpload;

	public Pair(BaseEntity parent, BaseEntity child) {
		this.parent = parent;
		this.child = child;
	}

	public Pair() {
	}

	public Pair(BaseEntity parent, BaseEntity child, Boolean isChildUpload) {
		this.parent = parent;
		this.child = child;
		this.isChildUpload = isChildUpload;
	}

	public BaseEntity getParent() {
		return parent;
	}

	public void setParent(BaseEntity parent) {
		this.parent = parent;
	}

	public BaseEntity getChild() {
		return child;
	}

	public void setChild(BaseEntity child) {
		this.child = child;
	}

	@Override
	public String toString() {
		return "Pair [parent=" + parent + ", child=" + child + "]";
	}

	public Boolean getIsChildUpload() {
		return isChildUpload;
	}

	public void setIsChildUpload(Boolean isChildUpload) {
		this.isChildUpload = isChildUpload;
	}

}
