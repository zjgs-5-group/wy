package com.microfragment.util;

import com.microfragment.entity.User;

public class JsonResponse {
private String Status;
public String getStatus() {
	return Status;
}
public void setStatus(String status) {
	Status = status;
}

private int eno;
private int cno;
public int getCno() {
	return cno;
}
public void setCno(int cno) {
	this.cno = cno;
}
public int getEno() {
	return eno;
}
public void setEno(int eno) {
	this.eno = eno;
}

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
