package com.wy.action;

// 1.2.1和1.3.1 用户输入手机号
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.wy.dao.Phone;
import com.wy.dao.PhoneImpl;
import com.wy.until.JsonRespense;

public class Register {
	private JsonRespense jsonResponse = new JsonRespense();
	private String usernumber;
	public String getUsernumber() {
		return usernumber;
	}
	public void setUsernumber(String usernumber) {
		this.usernumber = usernumber;
	}
	public String execute() throws IOException{
		Gson gson = new Gson();
		ActionContext ctx = ActionContext.getContext();
		HttpServletResponse response = (HttpServletResponse)ctx.get(ServletActionContext.HTTP_RESPONSE);
		response.setContentType("text/json");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		Phone dao = new PhoneImpl();
		boolean b = dao.register(usernumber);
		if(b)jsonResponse.setStatus(200);
		else
			jsonResponse.setStatus(500);
		
		out.print(gson.toJson(jsonResponse));   
		return null;
	}
}
