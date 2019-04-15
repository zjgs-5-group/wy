package com.wy.entity;

/**
 * CollectId entity. @author MyEclipse Persistence Tools
 */

public class CollectId implements java.io.Serializable {

	// Fields

	private Integer uno;
	private Integer eno;

	// Constructors

	/** default constructor */
	public CollectId() {
	}

	/** full constructor */
	public CollectId(Integer uno, Integer eno) {
		this.uno = uno;
		this.eno = eno;
	}

	// Property accessors

	public Integer getUno() {
		return this.uno;
	}

	public void setUno(Integer uno) {
		this.uno = uno;
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
		if (!(other instanceof CollectId))
			return false;
		CollectId castOther = (CollectId) other;

		return ((this.getUno() == castOther.getUno())
				|| (this.getUno() != null && castOther.getUno() != null && this.getUno().equals(castOther.getUno())))
				&& ((this.getEno() == castOther.getEno()) || (this.getEno() != null && castOther.getEno() != null
						&& this.getEno().equals(castOther.getEno())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getUno() == null ? 0 : this.getUno().hashCode());
		result = 37 * result + (getEno() == null ? 0 : this.getEno().hashCode());
		return result;
	}

}