package com.microfragment.entity;

/**
 * Essay entity. @author MyEclipse Persistence Tools
 */

public class Essay implements java.io.Serializable {

	// Fields

	private Integer eno;
	private String etitle;
	private String econtent;
	private String edate;
	private String eclass;
	private String uno;
	private String eimg;
	private String eaudit;

	// Constructors

	/** default constructor */
	public Essay() {
	}

	/** full constructor */
	public Essay(String etitle, String econtent, String edate, String eclass, String uno, String eimg, String eaudit) {
		this.etitle = etitle;
		this.econtent = econtent;
		this.edate = edate;
		this.eclass = eclass;
		this.uno = uno;
		this.eimg = eimg;
		this.eaudit = eaudit;
	}

	// Property accessors

	public Integer getEno() {
		return this.eno;
	}

	public void setEno(Integer eno) {
		this.eno = eno;
	}

	public String getEtitle() {
		return this.etitle;
	}

	public void setEtitle(String etitle) {
		this.etitle = etitle;
	}

	public String getEcontent() {
		return this.econtent;
	}

	public void setEcontent(String econtent) {
		this.econtent = econtent;
	}

	public String getEdate() {
		return this.edate;
	}

	public void setEdate(String edate) {
		this.edate = edate;
	}

	public String getEclass() {
		return this.eclass;
	}

	public void setEclass(String eclass) {
		this.eclass = eclass;
	}

	public String getUno() {
		return this.uno;
	}

	public void setUno(String uno) {
		this.uno = uno;
	}

	public String getEimg() {
		return this.eimg;
	}

	public void setEimg(String eimg) {
		this.eimg = eimg;
	}

	public String getEaudit() {
		return this.eaudit;
	}

	public void setEaudit(String eaudit) {
		this.eaudit = eaudit;
	}

}