package com.microfragment.entity;

/**
 * Ethomb entity. @author MyEclipse Persistence Tools
 */

@SuppressWarnings("serial")
public class Ethomb implements java.io.Serializable {

	// Fields

	private EthombId id;
	private String etdate;

	// Constructors

	/** default constructor */
	public Ethomb() {
	}

	/** full constructor */
	public Ethomb(EthombId id, String etdate) {
		this.id = id;
		this.etdate = etdate;
	}

	// Property accessors

	public EthombId getId() {
		return this.id;
	}

	public void setId(EthombId id) {
		this.id = id;
	}

	public String getEtdate() {
		return this.etdate;
	}

	public void setEtdate(String etdate) {
		this.etdate = etdate;
	}

}