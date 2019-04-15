package com.wy.action;

//  9.1 个人资料更改

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.wy.dao.UserDao;
import com.wy.dao.UserDaoImpl;
import com.wy.until.JsonRespense;

public class ChangePersonalData {
	private JsonRespense jsonResponse = new JsonRespense();
	private int userId;
	private String userImage;
	private String userName;
	private String userSex;
	private String userArea;
	public String execute() throws IOException{
		Gson gson = new Gson();
		ActionContext ctx = ActionContext.getContext();
		HttpServletResponse response = (HttpServletResponse)ctx.get(ServletActionContext.HTTP_RESPONSE);
		response.setContentType("text/json");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		UserDao dao = new UserDaoImpl();
		boolean cjs = dao.changePersonalData(userId, userImage, userName, userSex, userArea);
		if(cjs){
			jsonResponse.setStatus(200);
		}
		else
		{
			jsonResponse.setStatus(500);
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
	public String getUserImage() {
		return userImage;
	}
	public void setUserImage(String userImage) {
		this.userImage = userImage;
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
