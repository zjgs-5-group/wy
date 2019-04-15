package com.wy.entity;

/**
 * Transfer entity. @author MyEclipse Persistence Tools
 */

public class Transfer implements java.io.Serializable {

	// Fields

	private TransferId id;

	// Constructors

	/** default constructor */
	public Transfer() {
	}

	/** full constructor */
	public Transfer(TransferId id) {
		this.id = id;
	}

	// Property accessors

	public TransferId getId() {
		return this.id;
	}

	public void setId(TransferId id) {
		this.id = id;
	}

}