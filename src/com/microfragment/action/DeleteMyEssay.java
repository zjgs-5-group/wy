package com.microfragment.action;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.microfragment.dao.MineDao;
import com.microfragment.dao.MineDaoimp;
import com.microfragment.util.JsonResponse;
import com.opensymphony.xwork2.ActionContext;

public class DeleteMyEssay {
	private int uno;
	private int eno;
	public int getEno() {
		return eno;
	}

	public void setEno(int eno) {
		this.eno = eno;
	}

	public int getUno() {
		return uno;
	}

	public void setUno(int uno) {
		this.uno = uno;
	}

	//private FindJsonResponse findJsonResponse=new FindJsonResponse();
	public String execute() throws IOException{
		Gson gson=new Gson();
		JsonResponse jsonResponse=new JsonResponse();
		ActionContext ctx=ActionContext.getContext();
		HttpServletResponse response=(HttpServletResponse)ctx.get(ServletActionContext.HTTP_RESPONSE);
		response.setContentType("text/json");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");  
        response.setHeader("Access-Control-Max-Age", "3600");  
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
		response.setCharacterEncoding("utf-8");
		PrintWriter outPrintWriter=response.getWriter();
		MineDao mineDao=new MineDaoimp();
		boolean c=mineDao.deletemyessay(uno, eno);
		if(c){
			jsonResponse.setStatus("200");
		}else {
			jsonResponse.setStatus("500");
		}
		
		
		
		outPrintWriter.print(gson.toJson(jsonResponse));
		return null;
}
}