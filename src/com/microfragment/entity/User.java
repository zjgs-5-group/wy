package com.microfragment.entity;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

@SuppressWarnings("serial")
public class User implements java.io.Serializable {

	// Fields

	private Integer uno;
	private String upwd;
	private String ualias;
	private String usex;
	private Integer uage;
	private String usign;
	private String phone;
	private String uimg;
	private String uarea;
	private String ubg;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String phone) {
		this.phone = phone;
	}

	/** full constructor */
	public User(String upwd, String ualias, String usex, Integer uage, String usign, String phone, String uimg,
			String uarea, String ubg) {
		this.upwd = upwd;
		this.ualias = ualias;
		this.usex = usex;
		this.uage = uage;
		this.usign = usign;
		this.phone = phone;
		this.uimg = uimg;
		this.uarea = uarea;
		this.ubg = ubg;
	}

	// Property accessors

	public Integer getUno() {
		return this.uno;
	}

	public void setUno(Integer uno) {
		this.uno = uno;
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

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUimg() {
		return this.uimg;
	}

	public void setUimg(String uimg) {
		this.uimg = uimg;
	}

	public String getUarea() {
		return this.uarea;
	}

	public void setUarea(String uarea) {
		this.uarea = uarea;
	}

	public String getUbg() {
		return this.ubg;
	}

	public void setUbg(String ubg) {
		this.ubg = ubg;
	}

}