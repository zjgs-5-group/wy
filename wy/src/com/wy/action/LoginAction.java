package com.wy.action;
// 1.1登陆接口

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.wy.dao.UserDao;
import com.wy.dao.UserDaoImpl;
import com.wy.until.JsonRespense;
public class LoginAction {
	
	private JsonRespense jsonResponse = new JsonRespense();
	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	private String userPhone;
	private String userPassword;
	
	public String execute() throws IOException{
		Gson gson = new Gson();
		ActionContext ctx = ActionContext.getContext();
		HttpServletResponse response = (HttpServletResponse)ctx.get(ServletActionContext.HTTP_RESPONSE);
		response.setContentType("text/json");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		UserDao dao = new UserDaoImpl();
		boolean logined = dao.login(userPhone, userPassword);
		if(logined)
		{
			jsonResponse.setStatus(200);
		}
		else
			jsonResponse.setStatus(500);
		out.print(gson.toJson(jsonResponse));
		return null;
	}
}
