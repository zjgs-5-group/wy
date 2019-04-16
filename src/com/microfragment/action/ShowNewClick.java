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

public class ShowNewClick {
	private int uno;
	private String clicktime;
	public String getClicktime() {
		return clicktime;
	}
	public void setClicktime(String clicktime) {
		this.clicktime = clicktime;
	}
	public String execute() throws IOException{
		Gson gson=new Gson();
		ArrayList<String> jsonArrayList=new ArrayList<String>();
		ActionContext ctx=ActionContext.getContext();
		HttpServletResponse response=(HttpServletResponse)ctx.get(ServletActionContext.HTTP_RESPONSE);
		response.setContentType("text/json");
		response.setCharacterEncoding("utf-8");
		PrintWriter outPrintWriter=response.getWriter();
		MessageDao messageDao=new MessageDaoimp();

		for(int j= 0;j<messageDao.showClick(uno, clicktime).size();j++){
			
		    jsonArrayList.add(gson.toJson(messageDao.showClick(uno, clicktime).get(j)));
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
