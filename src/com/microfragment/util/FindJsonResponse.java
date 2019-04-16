package com.microfragment.util;



public class FindJsonResponse {
	
	public String getEtitle() {
		return etitle;
	}
	public void setEtitle(String etitle) {
		this.etitle = etitle;
	}
	public String getEcontent() {
		return econtent;
	}
	public void setEcontent(String econtent) {
		this.econtent = econtent;
	}
	public String getEdate() {
		return edate;
	}
	public void setEdate(String edate) {
		this.edate = edate;
	}
	public String getEclass() {
		return eclass;
	}
	public void setEclass(String eclass) {
		this.eclass = eclass;
	}
	public String getAuthor_name() {
		return author_name;
	}
	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}
	public String getEimg() {
		return eimg;
	}
	public void setEimg(String eimg) {
		this.eimg = eimg;
	}
	public Integer getThom_number() {
		return thom_number;
	}
	public void setThom_number(Integer thom_number) {
		this.thom_number = thom_number;
	}
	public Integer getSave_number() {
		return save_number;
	}
	public void setSave_number(Integer save_number) {
		this.save_number = save_number;
	}
	private String author_name;
	public FindJsonResponse(String author_name, String etitle, String econtent, String eclass, String edate,
			String eimg, Integer thom_number, Integer save_number) {
		super();
		this.author_name = author_name;
		this.etitle = etitle;
		this.econtent = econtent;
		this.eclass = eclass;
		this.edate = edate;
		this.eimg = eimg;
		this.thom_number = thom_number;
		this.save_number = save_number;
	}
	public FindJsonResponse(){}
	private String etitle;
	private String econtent;
	
	private String eclass;
	private String edate;
	private String eimg;
	private Integer thom_number;
	private Integer save_number;
	



}
