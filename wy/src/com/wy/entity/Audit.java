package com.wy.entity;

/**
 * Audit entity. @author MyEclipse Persistence Tools
 */

public class Audit implements java.io.Serializable {

	// Fields

	private Integer eno;
	private String adate;
	private String astate;

	// Constructors

	/** default constructor */
	public Audit() {
	}

	/** full constructor */
	public Audit(Integer eno,String adate, String astate) {
		this.eno = eno;
		this.adate = adate;
		this.astate = astate;
	}

	// Property accessors

	public Integer getEno() {
		return this.eno;
	}

	public void setEno(Integer eno) {
		this.eno = eno;
	}

	public String getAdate() {
		return this.adate;
	}

	public void setAdate(String adate) {
		this.adate = adate;
	}

	public String getAstate() {
		return this.astate;
	}

	public void setAstate(String astate) {
		this.astate = astate;
	}

}