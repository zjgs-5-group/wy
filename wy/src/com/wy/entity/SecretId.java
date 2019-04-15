package com.wy.entity;

/**
 * SecretId entity. @author MyEclipse Persistence Tools
 */

public class SecretId implements java.io.Serializable {

	// Fields

	private Integer suonactive;
	private Integer sunopassive;
	private String sdate;

	// Constructors

	/** default constructor */
	public SecretId() {
	}

	/** full constructor */
	public SecretId(Integer suonactive, Integer sunopassive, String sdate) {
		this.suonactive = suonactive;
		this.sunopassive = sunopassive;
		this.sdate = sdate;
	}

	// Property accessors

	public Integer getSuonactive() {
		return this.suonactive;
	}

	public void setSuonactive(Integer suonactive) {
		this.suonactive = suonactive;
	}

	public Integer getSunopassive() {
		return this.sunopassive;
	}

	public void setSunopassive(Integer sunopassive) {
		this.sunopassive = sunopassive;
	}

	public String getSdate() {
		return this.sdate;
	}

	public void setSdate(String sdate) {
		this.sdate = sdate;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof SecretId))
			return false;
		SecretId castOther = (SecretId) other;

		return ((this.getSuonactive() == castOther.getSuonactive()) || (this.getSuonactive() != null
				&& castOther.getSuonactive() != null && this.getSuonactive().equals(castOther.getSuonactive())))
				&& ((this.getSunopassive() == castOther.getSunopassive())
						|| (this.getSunopassive() != null && castOther.getSunopassive() != null
								&& this.getSunopassive().equals(castOther.getSunopassive())))
				&& ((this.getSdate() == castOther.getSdate()) || (this.getSdate() != null
						&& castOther.getSdate() != null && this.getSdate().equals(castOther.getSdate())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getSuonactive() == null ? 0 : this.getSuonactive().hashCode());
		result = 37 * result + (getSunopassive() == null ? 0 : this.getSunopassive().hashCode());
		result = 37 * result + (getSdate() == null ? 0 : this.getSdate().hashCode());
		return result;
	}

}