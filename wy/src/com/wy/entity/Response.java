package com.wy.entity;

/**
 * Response entity. @author MyEclipse Persistence Tools
 */

public class Response implements java.io.Serializable {

	// Fields

	private ResponseId id;
	private String rcontent;
	private String rdate;

	// Constructors

	/** default constructor */
	public Response() {
	}

	/** full constructor */
	public Response(ResponseId id, String rcontent, String rdate) {
		this.id = id;
		this.rcontent = rcontent;
		this.rdate = rdate;
	}

	// Property accessors

	public ResponseId getId() {
		return this.id;
	}

	public void setId(ResponseId id) {
		this.id = id;
	}

	public String getRcontent() {
		return this.rcontent;
	}

	public void setRcontent(String rcontent) {
		this.rcontent = rcontent;
	}

	public String getRdate() {
		return this.rdate;
	}

	public void setRdate(String rdate) {
		this.rdate = rdate;
	}

}