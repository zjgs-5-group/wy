package com.wy.entity;

/**
 * VerificationCode entity. @author MyEclipse Persistence Tools
 */

public class VerificationCode implements java.io.Serializable {

	// Fields

	private VerificationCodeId id;
	private String vphone;

	// Constructors

	/** default constructor */
	public VerificationCode() {
	}

	/** minimal constructor */
	public VerificationCode(VerificationCodeId id) {
		this.id = id;
	}

	/** full constructor */
	public VerificationCode(VerificationCodeId id, String vphone) {
		this.id = id;
		this.vphone = vphone;
	}

	// Property accessors

	public VerificationCodeId getId() {
		return this.id;
	}

	public void setId(VerificationCodeId id) {
		this.id = id;
	}

	public String getVphone() {
		return this.vphone;
	}

	public void setVphone(String vphone) {
		this.vphone = vphone;
	}

}