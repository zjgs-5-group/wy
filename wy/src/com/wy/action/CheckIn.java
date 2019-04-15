package com.wy.action;
// 1.2.2和1.3.2给用户发送验证码
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.wy.dao.Phone;
import com.wy.dao.PhoneImpl;
import com.wy.until.JsonRespense;

public class CheckIn {
	private JsonRespense jsonResponse = new JsonRespense();
	private String checkcode;
	public String getCheckcode() {
		return checkcode;
	}
	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}
	public String execute() throws IOException{
		Gson gson = new Gson();
		ActionContext ctx = ActionContext.getContext();
		HttpServletResponse response = (HttpServletResponse)ctx.get(ServletActionContext.HTTP_RESPONSE);
		response.setContentType("text/json");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		Phone dao = new PhoneImpl();
		boolean b = dao.checkIn(checkcode);
		if(b)jsonResponse.setStatus(200);
		else
			jsonResponse.setStatus(500);
		
		out.print(gson.toJson(jsonResponse));
		return null;
	}
}
