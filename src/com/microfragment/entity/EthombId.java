package com.microfragment.entity;

/**
 * EthombId entity. @author MyEclipse Persistence Tools
 */

public class EthombId implements java.io.Serializable {

	// Fields

	private Integer etunoactive;
	private Integer eno;

	// Constructors

	/** default constructor */
	public EthombId() {
	}

	/** full constructor */
	public EthombId(Integer etunoactive, Integer eno) {
		this.etunoactive = etunoactive;
		this.eno = eno;
	}

	// Property accessors

	public Integer getEtunoactive() {
		return this.etunoactive;
	}

	public void setEtunoactive(Integer etunoactive) {
		this.etunoactive = etunoactive;
	}

	public Integer getEno() {
		return this.eno;
	}

	public void setEno(Integer eno) {
		this.eno = eno;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof EthombId))
			return false;
		EthombId castOther = (EthombId) other;

		return ((this.getEtunoactive() == castOther.getEtunoactive()) || (this.getEtunoactive() != null
				&& castOther.getEtunoactive() != null && this.getEtunoactive().equals(castOther.getEtunoactive())))
				&& ((this.getEno() == castOther.getEno()) || (this.getEno() != null && castOther.getEno() != null
						&& this.getEno().equals(castOther.getEno())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getEtunoactive() == null ? 0 : this.getEtunoactive().hashCode());
		result = 37 * result + (getEno() == null ? 0 : this.getEno().hashCode());
		return result;
	}

}