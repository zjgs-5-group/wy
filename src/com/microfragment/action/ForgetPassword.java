package com.microfragment.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.microfragment.dao.Phone;
import com.microfragment.dao.PhoneImpl;
import com.microfragment.util.JsonResponse;
import com.opensymphony.xwork2.ActionContext;

public class ForgetPassword {
	private JsonResponse jsonResponse = new JsonResponse();
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
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");  
        response.setHeader("Access-Control-Max-Age", "3600");  
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
		PrintWriter out = response.getWriter();
		Phone dao = new PhoneImpl();
		boolean b = dao.forgetpwd(usernumber);
		if(b)jsonResponse.setStatus("200");
		else
			jsonResponse.setStatus("500");
		
		out.print(gson.toJson(jsonResponse));   
		return null;
	}
}
