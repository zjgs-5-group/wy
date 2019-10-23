package com.microfragment.action;
// 1.1鐧婚檰鎺ュ彛

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.microfragment.dao.UserDao;
import com.microfragment.dao.UserDaoImpl;
import com.microfragment.entity.User;
import com.microfragment.util.JsonResponse;
public class LoginAction {
	
	private JsonResponse jsonResponse = new JsonResponse();
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
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");  
        response.setHeader("Access-Control-Max-Age", "3600");  
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
		PrintWriter out = response.getWriter();
		UserDao dao = new UserDaoImpl();
		User user = dao.login(userPhone, userPassword);
		if(user!=null)
		{
			jsonResponse.setStatus("200");
			jsonResponse.setUno(user.getUno());		}
		else
			jsonResponse.setStatus("500");
		out.print(gson.toJson(jsonResponse));
		return null;
	}
}
