package com.microfragment.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.microfragment.dao.MineDao;
import com.microfragment.dao.MineDaoimp;
import com.opensymphony.xwork2.ActionContext;

public class GetUserInformation {
private int uno;
	
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
		MineDao mineDao=new MineDaoimp();

		for(int j= 0;j<mineDao.getUserInfo(uno).size();j++){
			
		    jsonArrayList.add(gson.toJson(mineDao.getUserInfo(uno).get(j)));
		}
		
		outPrintWriter.print(jsonArrayList);
		return null;
		
	}
	public int getUno() {
		return uno;
	}
	public void setUno(int uno) {
		this.uno = uno;
	}
}
