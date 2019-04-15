package com.wy.action;
//1.3.3 用户重新设置密码
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.wy.dao.Phone;
import com.wy.dao.PhoneImpl;
import com.wy.until.JsonRespense;

public class resetPassword {
	public String phone;
	public String pwd;
	public String pwdd;
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getPwdd() {
		return pwdd;
	}
	public void setPwdd(String pwdd) {
		this.pwdd = pwdd;
	}
	private JsonRespense jsonResponse = new JsonRespense();
	public String execute() throws IOException{
		Gson gson = new Gson();
		ActionContext ctx = ActionContext.getContext();
		HttpServletResponse response = (HttpServletResponse)ctx.get(ServletActionContext.HTTP_RESPONSE);
		response.setContentType("text/json");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		Phone dao = new PhoneImpl();
		boolean b = dao.resetPassword(phone, pwd, pwdd);
		if(b)jsonResponse.setStatus(200);
		else
			jsonResponse.setStatus(500);
		
		
		out.print(gson.toJson(jsonResponse));   
		return null;
	}
}
