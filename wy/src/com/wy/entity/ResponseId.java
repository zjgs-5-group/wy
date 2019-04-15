package com.wy.entity;

/**
 * ResponseId entity. @author MyEclipse Persistence Tools
 */

public class ResponseId implements java.io.Serializable {

	// Fields

	private Integer cno;
	private Integer eno;

	// Constructors

	/** default constructor */
	public ResponseId() {
	}

	/** full constructor */
	public ResponseId(Integer cno, Integer eno) {
		this.cno = cno;
		this.eno = eno;
	}

	// Property accessors

	public Integer getCno() {
		return this.cno;
	}

	public void setCno(Integer cno) {
		this.cno = cno;
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
		if (!(other instanceof ResponseId))
			return false;
		ResponseId castOther = (ResponseId) other;

		return ((this.getCno() == castOther.getCno())
				|| (this.getCno() != null && castOther.getCno() != null && this.getCno().equals(castOther.getCno())))
				&& ((this.getEno() == castOther.getEno()) || (this.getEno() != null && castOther.getEno() != null
						&& this.getEno().equals(castOther.getEno())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getCno() == null ? 0 : this.getCno().hashCode());
		result = 37 * result + (getEno() == null ? 0 : this.getEno().hashCode());
		return result;
	}

}