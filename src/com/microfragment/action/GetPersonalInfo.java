package com.microfragment.action;

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

public class GetPersonalInfo {
	private JsonResponse jsonResponse = new JsonResponse();
	private int uno;
	public int getUno() {
		return uno;
	}
	public void setUno(int uno) {
		this.uno = uno;
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
		UserDao dao = new UserDaoImpl();
		User u = dao.getPersonalInfo(uno);
		if(u==null)jsonResponse.setId(null);
		else
			jsonResponse.setId(u);
		out.print(gson.toJson(jsonResponse.getId()));
		return null;
	}
}
