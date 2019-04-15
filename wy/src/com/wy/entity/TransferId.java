package com.wy.entity;

/**
 * TransferId entity. @author MyEclipse Persistence Tools
 */

public class TransferId implements java.io.Serializable {

	// Fields

	private Integer tunoactive;
	private Integer eno;
	private String tdate;

	// Constructors

	/** default constructor */
	public TransferId() {
	}

	/** full constructor */
	public TransferId(Integer tunoactive, Integer eno, String tdate) {
		this.tunoactive = tunoactive;
		this.eno = eno;
		this.tdate = tdate;
	}

	// Property accessors

	public Integer getTunoactive() {
		return this.tunoactive;
	}

	public void setTunoactive(Integer tunoactive) {
		this.tunoactive = tunoactive;
	}

	public Integer getEno() {
		return this.eno;
	}

	public void setEno(Integer eno) {
		this.eno = eno;
	}

	public String getTdate() {
		return this.tdate;
	}

	public void setTdate(String tdate) {
		this.tdate = tdate;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TransferId))
			return false;
		TransferId castOther = (TransferId) other;

		return ((this.getTunoactive() == castOther.getTunoactive()) || (this.getTunoactive() != null
				&& castOther.getTunoactive() != null && this.getTunoactive().equals(castOther.getTunoactive())))
				&& ((this.getEno() == castOther.getEno()) || (this.getEno() != null && castOther.getEno() != null
						&& this.getEno().equals(castOther.getEno())))
				&& ((this.getTdate() == castOther.getTdate()) || (this.getTdate() != null
						&& castOther.getTdate() != null && this.getTdate().equals(castOther.getTdate())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getTunoactive() == null ? 0 : this.getTunoactive().hashCode());
		result = 37 * result + (getEno() == null ? 0 : this.getEno().hashCode());
		result = 37 * result + (getTdate() == null ? 0 : this.getTdate().hashCode());
		return result;
	}

}