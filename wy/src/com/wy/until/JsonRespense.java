package com.wy.until;

import com.wy.entity.User;

public class JsonRespense {
	private int status;
	private String img_address;
	private String Essay_content;
	private User id;
	private String alias;
	private int uno;
	private String comment;
	private String commentreply;
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getUno() {
		return uno;
	}
	public void setUno(int uno) {
		this.uno = uno;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public User getId() {
		return id;
	}
	public void setId(User id) {
		this.id = id;
	}
	public String getEssay_content() {
		return Essay_content;
	}
	public void setEssay_content(String essay_content) {
		Essay_content = essay_content;
	}
	public int getStatus(){
		return status;
	}
	public void setStatus(int status){
		this.status = status;
	}
	public String getImg_address() {
		return img_address;
	}
	public void setImg_address(String img_address) {
		this.img_address = img_address;
	}
	public String getCommentreply() {
		return commentreply;
	}
	public void setCommentreply(String commentreply) {
		this.commentreply = commentreply;
	}
}
