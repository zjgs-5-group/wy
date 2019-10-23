package com.microfragment.action;

//  9.1 个人资料更改

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.microfragment.dao.UserDao;
import com.microfragment.dao.UserDaoImpl;
import com.microfragment.util.JsonResponse;

public class ChangePersonalData {
	private JsonResponse jsonResponse = new JsonResponse();
	private int userId;
	private int userAge;
	public int getUserAge() {
		return userAge;
	}
	public void setUserAge(int useAge) {
		this.userAge = useAge;
	}
	private String userName;
	private String userSex;
	private String userArea;
	
	
	public String getUserSign() {
		return userSign;
	}
	public void setUserSign(String userSign) {
		this.userSign = userSign;
	}
	private String userSign;
	public String execute() throws IOException{
		Gson gson = new Gson();
		ActionContext ctx = ActionContext.getContext();
		HttpServletResponse response = (HttpServletResponse)ctx.get(ServletActionContext.HTTP_RESPONSE);
		response.setContentType("text/json");
		response.setCharacterEncoding("utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");  
        response.setHeader("Access-Control-Max-Age", "3600");  
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
		PrintWriter out = response.getWriter();
		UserDao dao = new UserDaoImpl();
		String s1=URLDecoder.decode(userName,"UTF-8");
		String s2=URLDecoder.decode(userArea,"UTF-8");
		String s3=URLDecoder.decode(userSign,"UTF-8");
		boolean cjs = dao.changePersonalData(userId, userAge, s1, userSex, s2,s3);
		if(cjs){
			jsonResponse.setStatus("200");
		}
		else
		{
			jsonResponse.setStatus("500");
		}
		out.print(gson.toJson(jsonResponse));
		return null;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserSex() {
		return userSex;
	}
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	public String getUserArea() {
		return userArea;
	}
	public void setUserArea(String userArea) {
		this.userArea = userArea;
	}
}
