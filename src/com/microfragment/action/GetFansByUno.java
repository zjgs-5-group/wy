package com.microfragment.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;

import com.microfragment.dao.MessageDao;
import com.microfragment.dao.MessageDaoimp;
import com.opensymphony.xwork2.ActionContext;

public class GetFansByUno {
	private int uno;
	
	public String execute() throws IOException{
		Gson gson=new Gson();
		ArrayList<String> jsonArrayList=new ArrayList<String>();
		ActionContext ctx=ActionContext.getContext();
		HttpServletResponse response=(HttpServletResponse)ctx.get(ServletActionContext.HTTP_RESPONSE);
		response.setContentType("text/json");
		response.setCharacterEncoding("utf-8");
		PrintWriter outPrintWriter=response.getWriter();
		MessageDao messageDao=new MessageDaoimp();

		for(int j= 0;j<messageDao.getNewFans(uno).size();j++){
			
		    jsonArrayList.add(gson.toJson(messageDao.getNewFans(uno).get(j)));
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
