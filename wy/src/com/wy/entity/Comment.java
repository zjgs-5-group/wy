package com.wy.entity;

/**
 * Comment entity. @author MyEclipse Persistence Tools
 */

public class Comment implements java.io.Serializable {

	// Fields

	private CommentId id;
	private String ccontent;

	// Constructors

	/** default constructor */
	public Comment() {
	}

	/** full constructor */
	public Comment(CommentId id, String ccontent) {
		this.id = id;
		this.ccontent = ccontent;
	}

	// Property accessors

	public CommentId getId() {
		return this.id;
	}

	public void setId(CommentId id) {
		this.id = id;
	}

	public String getCcontent() {
		return this.ccontent;
	}

	public void setCcontent(String ccontent) {
		this.ccontent = ccontent;
	}

}