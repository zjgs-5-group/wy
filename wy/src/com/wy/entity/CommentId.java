package com.wy.entity;

/**
 * CommentId entity. @author MyEclipse Persistence Tools
 */

public class CommentId implements java.io.Serializable {

	// Fields

	private Integer cunoactive;
	private Integer eno;
	private String cdate;

	// Constructors

	/** default constructor */
	public CommentId() {
	}

	/** full constructor */
	public CommentId(Integer cunoactive, Integer eno, String cdate) {
		this.cunoactive = cunoactive;
		this.eno = eno;
		this.cdate = cdate;
	}

	// Property accessors

	public Integer getCunoactive() {
		return this.cunoactive;
	}

	public void setCunoactive(Integer cunoactive) {
		this.cunoactive = cunoactive;
	}

	public Integer getEno() {
		return this.eno;
	}

	public void setEno(Integer eno) {
		this.eno = eno;
	}

	public String getCdate() {
		return this.cdate;
	}

	public void setCdate(String cdate) {
		this.cdate = cdate;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CommentId))
			return false;
		CommentId castOther = (CommentId) other;

		return ((this.getCunoactive() == castOther.getCunoactive()) || (this.getCunoactive() != null
				&& castOther.getCunoactive() != null && this.getCunoactive().equals(castOther.getCunoactive())))
				&& ((this.getEno() == castOther.getEno()) || (this.getEno() != null && castOther.getEno() != null
						&& this.getEno().equals(castOther.getEno())))
				&& ((this.getCdate() == castOther.getCdate()) || (this.getCdate() != null
						&& castOther.getCdate() != null && this.getCdate().equals(castOther.getCdate())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getCunoactive() == null ? 0 : this.getCunoactive().hashCode());
		result = 37 * result + (getEno() == null ? 0 : this.getEno().hashCode());
		result = 37 * result + (getCdate() == null ? 0 : this.getCdate().hashCode());
		return result;
	}

}