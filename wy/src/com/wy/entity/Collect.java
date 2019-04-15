package com.wy.entity;

/**
 * Collect entity. @author MyEclipse Persistence Tools
 */

public class Collect implements java.io.Serializable {

	// Fields

	private CollectId id;

	// Constructors

	/** default constructor */
	public Collect() {
	}

	/** full constructor */
	public Collect(CollectId id) {
		this.id = id;
	}

	// Property accessors

	public CollectId getId() {
		return this.id;
	}

	public void setId(CollectId id) {
		this.id = id;
	}

}