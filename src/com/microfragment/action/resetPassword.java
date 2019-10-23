package com.microfragment.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.microfragment.dao.Phone;
import com.microfragment.dao.PhoneImpl;
import com.microfragment.util.JsonResponse;

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
	private JsonResponse jsonResponse = new JsonResponse();
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
		Phone dao = new PhoneImpl();
		boolean b = dao.resetPassword(phone, pwd, pwdd);
		if(b)jsonResponse.setStatus("200");
		else
			jsonResponse.setStatus("500");
		
		
		out.print(gson.toJson(jsonResponse));   
		return null;
	}
}
