package com.wy.entity;

/**
 * Thomb entity. @author MyEclipse Persistence Tools
 */

public class Thomb implements java.io.Serializable {

	// Fields

	private ThombId id;

	// Constructors

	/** default constructor */
	public Thomb() {
	}

	/** full constructor */
	public Thomb(ThombId id) {
		this.id = id;
	}

	// Property accessors

	public ThombId getId() {
		return this.id;
	}

	public void setId(ThombId id) {
		this.id = id;
	}

}