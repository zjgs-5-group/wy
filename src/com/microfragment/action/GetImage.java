package com.microfragment.action;


import java.io.IOException;

import java.io.PrintWriter;


import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.microfragment.dao.UserDao;
import com.microfragment.dao.UserDaoImpl;
import com.microfragment.entity.User;
import com.microfragment.util.JsonResponse;
import com.opensymphony.xwork2.ActionContext;




public class GetImage {
	private JsonResponse jsonResponse=new JsonResponse();
	private int uno;
	private String type;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
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
        UserDao userDao=new UserDaoImpl();
        User user=userDao.getPersonalInfo(uno);
       
        
           if(type.equals("head")){
        	   jsonResponse.setStatus(user.getUimg());
           }else if(type.equals("bg")){
        	   jsonResponse.setStatus(user.getUbg());
           }
			
		
		out.print(gson.toJson(jsonResponse.getStatus()));
		return null;
	}
}
