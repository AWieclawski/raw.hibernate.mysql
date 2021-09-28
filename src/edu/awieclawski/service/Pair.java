package edu.awieclawski.service;

import edu.awieclawski.base.BaseEntity;

public class Pair {
	private BaseEntity parent;
	private BaseEntity child;

	public Pair(BaseEntity parent, BaseEntity child) {
		this.parent = parent;
		this.child = child;
	}

	public Pair() {
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

}
