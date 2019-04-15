package com.wy.entity;

/**
 * FocuId entity. @author MyEclipse Persistence Tools
 */

public class FocuId implements java.io.Serializable {

	// Fields

	private Integer factiveuno;
	private Integer fpassiveuno;

	// Constructors

	/** default constructor */
	public FocuId() {
	}

	/** full constructor */
	public FocuId(Integer factiveuno, Integer fpassiveuno) {
		this.factiveuno = factiveuno;
		this.fpassiveuno = fpassiveuno;
	}

	// Property accessors

	public Integer getFactiveuno() {
		return this.factiveuno;
	}

	public void setFactiveuno(Integer factiveuno) {
		this.factiveuno = factiveuno;
	}

	public Integer getFpassiveuno() {
		return this.fpassiveuno;
	}

	public void setFpassiveuno(Integer fpassiveuno) {
		this.fpassiveuno = fpassiveuno;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof FocuId))
			return false;
		FocuId castOther = (FocuId) other;

		return ((this.getFactiveuno() == castOther.getFactiveuno()) || (this.getFactiveuno() != null
				&& castOther.getFactiveuno() != null && this.getFactiveuno().equals(castOther.getFactiveuno())))
				&& ((this.getFpassiveuno() == castOther.getFpassiveuno())
						|| (this.getFpassiveuno() != null && castOther.getFpassiveuno() != null
								&& this.getFpassiveuno().equals(castOther.getFpassiveuno())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getFactiveuno() == null ? 0 : this.getFactiveuno().hashCode());
		result = 37 * result + (getFpassiveuno() == null ? 0 : this.getFpassiveuno().hashCode());
		return result;
	}

}