package com.microfragment.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.microfragment.dao.FindDao;
import com.microfragment.dao.FindDaoimp;
import com.microfragment.dao.UserDaoimp;
import com.microfragment.dao.Userinfo;

import com.microfragment.entity.User;
import com.microfragment.util.JsonResponse;
import com.opensymphony.xwork2.ActionContext;


public class RegisterAction {
	
private JsonResponse jsonResponse=new JsonResponse();
private String uuser;
private String pwd;
private String alias;
private String sex;
private int age;
private String sign;
private String phone;
private String area;
private String img;
public String execute() throws IOException{
	Gson gson=new Gson();
	ActionContext ctx=ActionContext.getContext();
	HttpServletResponse response=(HttpServletResponse)ctx.get(ServletActionContext.HTTP_RESPONSE);
	response.setContentType("text/json");
	response.setCharacterEncoding("utf-8");
	System.out.println("1111");
	System.out.println(ctx);
	System.out.println("1333");
	System.out.println(response);
	PrintWriter outPrintWriter=response.getWriter();
	System.out.println("2222");
	System.out.println(uuser);
	Userinfo userinfo=new UserDaoimp();
	FindDao findDao=new FindDaoimp();
	findDao.getEssay(1);
	System.out.println("testfinfdao4444");
	System.out.println(findDao.getEssay(1).getEtitle());
	User user1=new User();
	user1.setPhone("123456");
	user1.setUage(12);
	user1.setUalias("123456");
	user1.setUarea("125");
	user1.setUimg("125");
	user1.setUpwd("125");
	user1.setUsex("125");
	user1.setUsign("125");
	user1.setUuser(uuser);
	userinfo.saveUser(user1);
	jsonResponse.setStatus(uuser);
	outPrintWriter.print(gson.toJson(jsonResponse));
	return null;
}
public String getUuser() {
	return uuser;
}
public void setUuser(String uuser) {
	this.uuser = uuser;
}
public String getPwd() {
	return pwd;
}
public void setPwd(String pwd) {
	this.pwd = pwd;
}
public String getAlias() {
	return alias;
}
public void setAlias(String alias) {
	this.alias = alias;
}
public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getSign() {
	return sign;
}
public void setSign(String sign) {
	this.sign = sign;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getArea() {
	return area;
}
public void setArea(String area) {
	this.area = area;
}
public String getImg() {
	return img;
}
public void setImg(String img) {
	this.img = img;
}
	
	
	
	

}
