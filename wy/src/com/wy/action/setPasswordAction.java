package com.wy.action;
//1.2.3用户设置昵称密码
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.wy.dao.UserDao;
import com.wy.dao.UserDaoImpl;
import com.wy.until.JsonRespense;

public class setPasswordAction {
	private JsonRespense jsonResponse = new JsonRespense();
	private int uno;
	private String useralias;
	private String userpassword;
	private String passwordble;
	public int getUno() {
		return uno;
	}
	public void setUno(int uno) {
		this.uno = uno;
	}
	public String getUseralias() {
		return useralias;
	}
	public void setUseralias(String useralias) {
		this.useralias = useralias;
	}
	public String getUserpassword() {
		return userpassword;
	}
	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}
	public String getPasswordble() {
		return passwordble;
	}
	public void setPasswordble(String passwordble) {
		this.passwordble = passwordble;
	}
	public String execute() throws IOException{
		Gson gson = new Gson();
		ActionContext ctx = ActionContext.getContext();
		HttpServletResponse response = (HttpServletResponse)ctx.get(ServletActionContext.HTTP_RESPONSE);
		response.setContentType("text/json");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		UserDao dao = new UserDaoImpl();
		boolean b = dao.setPassword(uno, useralias, userpassword, passwordble);
		if(b)
		{
			jsonResponse.setStatus(200);
		}
		else
			jsonResponse.setStatus(500);
		
		
		out.print(gson.toJson(jsonResponse));   
		return null;
	}
}
