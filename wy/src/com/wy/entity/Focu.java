package com.wy.entity;

/**
 * Focu entity. @author MyEclipse Persistence Tools
 */

public class Focu implements java.io.Serializable {

	// Fields

	private FocuId id;

	// Constructors

	/** default constructor */
	public Focu() {
	}

	/** full constructor */
	public Focu(FocuId id) {
		this.id = id;
	}

	// Property accessors

	public FocuId getId() {
		return this.id;
	}

	public void setId(FocuId id) {
		this.id = id;
	}

}