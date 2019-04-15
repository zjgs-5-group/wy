package com.wy.entity;

/**
 * VerificationCodeId entity. @author MyEclipse Persistence Tools
 */

public class VerificationCodeId implements java.io.Serializable {

	// Fields

	private String vdata;
	private String vcode;

	// Constructors

	/** default constructor */
	public VerificationCodeId() {
	}

	/** full constructor */
	public VerificationCodeId(String vdata, String vcode) {
		this.vdata = vdata;
		this.vcode = vcode;
	}

	// Property accessors

	public String getVdata() {
		return this.vdata;
	}

	public void setVdata(String vdata) {
		this.vdata = vdata;
	}

	public String getVcode() {
		return this.vcode;
	}

	public void setVcode(String vcode) {
		this.vcode = vcode;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VerificationCodeId))
			return false;
		VerificationCodeId castOther = (VerificationCodeId) other;

		return ((this.getVdata() == castOther.getVdata()) || (this.getVdata() != null && castOther.getVdata() != null
				&& this.getVdata().equals(castOther.getVdata())))
				&& ((this.getVcode() == castOther.getVcode()) || (this.getVcode() != null
						&& castOther.getVcode() != null && this.getVcode().equals(castOther.getVcode())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getVdata() == null ? 0 : this.getVdata().hashCode());
		result = 37 * result + (getVcode() == null ? 0 : this.getVcode().hashCode());
		return result;
	}

}