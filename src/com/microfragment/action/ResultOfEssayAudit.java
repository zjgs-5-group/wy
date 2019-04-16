package com.microfragment.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.microfragment.dao.MessageDao;
import com.microfragment.dao.MessageDaoimp;
import com.opensymphony.xwork2.ActionContext;

public class ResultOfEssayAudit {
	private int uno;
	private int eno;
	
	public String execute() throws IOException{
	Gson gson=new Gson();
	ActionContext ctx=ActionContext.getContext();
	HttpServletResponse response=(HttpServletResponse)ctx.get(ServletActionContext.HTTP_RESPONSE);
	response.setContentType("text/json");
	response.setCharacterEncoding("utf-8");
	PrintWriter outPrintWriter=response.getWriter();
	MessageDao messageDao=new MessageDaoimp();
	outPrintWriter.print(gson.toJson(messageDao.getMessageAudit(uno, eno)));
	return null;
	}
	public int getUno() {
		return uno;
	}
	public void setUno(int uno) {
		this.uno = uno;
	}
	public int getEno() {
		return eno;
	}
	public void setEno(int eno) {
		this.eno = eno;
	}
}
