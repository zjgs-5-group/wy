package com.wy.entity;

/**
 * Secret entity. @author MyEclipse Persistence Tools
 */

public class Secret implements java.io.Serializable {

	// Fields

	private SecretId id;
	private String scontent;

	// Constructors

	/** default constructor */
	public Secret() {
	}

	/** full constructor */
	public Secret(SecretId id, String scontent) {
		this.id = id;
		this.scontent = scontent;
	}

	// Property accessors

	public SecretId getId() {
		return this.id;
	}

	public void setId(SecretId id) {
		this.id = id;
	}

	public String getScontent() {
		return this.scontent;
	}

	public void setScontent(String scontent) {
		this.scontent = scontent;
	}

}