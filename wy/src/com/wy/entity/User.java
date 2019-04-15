package com.wy.entity;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Integer uno;
	private String uuser;
	private String upwd;
	private String ualias;
	private String usex;
	private Integer uage;
	private String usign;
	private String uphone;
	private String uarea;
	private String uimg;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String uphone) {
		this.uphone = uphone;
	}

	/** full constructor */
	public User(String uuser, String upwd, String ualias, String usex, Integer uage, String usign, String uphone,
			String uarea, String uimg) {
		this.uuser = uuser;
		this.upwd = upwd;
		this.ualias = ualias;
		this.usex = usex;
		this.uage = uage;
		this.usign = usign;
		this.uphone = uphone;
		this.uarea = uarea;
		this.uimg = uimg;
	}

	// Property accessors

	public Integer getUno() {
		return this.uno;
	}

	public void setUno(Integer uno) {
		this.uno = uno;
	}

	public String getUuser() {
		return this.uuser;
	}

	public void setUuser(String uuser) {
		this.uuser = uuser;
	}

	public String getUpwd() {
		return this.upwd;
	}

	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}

	public String getUalias() {
		return this.ualias;
	}

	public void setUalias(String ualias) {
		this.ualias = ualias;
	}

	public String getUsex() {
		return this.usex;
	}

	public void setUsex(String usex) {
		this.usex = usex;
	}

	public Integer getUage() {
		return this.uage;
	}

	public void setUage(Integer uage) {
		this.uage = uage;
	}

	public String getUsign() {
		return this.usign;
	}

	public void setUsign(String usign) {
		this.usign = usign;
	}

	public String getUphone() {
		return this.uphone;
	}

	public void setUphone(String uphone) {
		this.uphone = uphone;
	}

	public String getUarea() {
		return this.uarea;
	}

	public void setUarea(String uarea) {
		this.uarea = uarea;
	}

	public String getUimg() {
		return this.uimg;
	}

	public void setUimg(String uimg) {
		this.uimg = uimg;
	}

}