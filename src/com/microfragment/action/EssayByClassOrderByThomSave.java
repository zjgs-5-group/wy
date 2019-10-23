package com.microfragment.action;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.ArrayList;


import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;


import com.google.gson.Gson;

import com.microfragment.dao.FindDao;
import com.microfragment.dao.FindDaoimp;


import com.opensymphony.xwork2.ActionContext;

public class EssayByClassOrderByThomSave {
	
	private String classstring;
	
	public String execute() throws IOException{
	Gson gson=new Gson();
	ArrayList<String> jsonArrayList=new ArrayList<String>();
	ActionContext ctx=ActionContext.getContext();
	HttpServletResponse response=(HttpServletResponse)ctx.get(ServletActionContext.HTTP_RESPONSE);
	response.setContentType("text/json");
	response.setCharacterEncoding("utf-8");
	response.setHeader("Access-Control-Allow-Origin", "*");
	response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");  
    response.setHeader("Access-Control-Max-Age", "3600");  
    response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
	PrintWriter outPrintWriter=response.getWriter();
	FindDao findDao=new FindDaoimp();
	
	String s1=URLDecoder.decode(classstring,"UTF-8");
	for(int j= 0;j<findDao.essaybyclass(s1).size();j++){
	   
	    jsonArrayList.add(gson.toJson(findDao.essaybyclass(s1).get(j)));
	}
	outPrintWriter.print(jsonArrayList);
	return null;
}
	public String getClassstring() {
		return classstring;
	}

	public void setClassstring(String classstring) {
		this.classstring = classstring;
	}

}
