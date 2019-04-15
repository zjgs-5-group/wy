package com.wy.entity;

/**
 * BrowsingHistory entity. @author MyEclipse Persistence Tools
 */

public class BrowsingHistory implements java.io.Serializable {

	// Fields

	private BrowsingHistoryId id;

	// Constructors

	/** default constructor */
	public BrowsingHistory() {
	}

	/** full constructor */
	public BrowsingHistory(BrowsingHistoryId id) {
		this.id = id;
	}

	// Property accessors

	public BrowsingHistoryId getId() {
		return this.id;
	}

	public void setId(BrowsingHistoryId id) {
		this.id = id;
	}

}