package com.microfragment.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.microfragment.dao.FindDao;
import com.microfragment.dao.FindDaoimp;
import com.opensymphony.xwork2.ActionContext;

public class AccomandEssay {
	public int[] getUno() {
		return uno;
	}

	public void setUno(int[] uno) {
		this.uno = uno;
	}

	public String[] getClassfy() {
		return classfy;
	}

	public void setClassfy(String[] classfy) {
		this.classfy = classfy;
	}

	private int uno[];
	private String classfy[];

	//private FindJsonResponse findJsonResponse=new FindJsonResponse();
	public String execute() throws IOException{
		Gson gson=new Gson();
		ArrayList<String> jsonArrayList=new ArrayList<String>();
		ActionContext ctx=ActionContext.getContext();
		HttpServletResponse response=(HttpServletResponse)ctx.get(ServletActionContext.HTTP_RESPONSE);
		response.setContentType("text/json");
		response.setCharacterEncoding("utf-8");
		PrintWriter outPrintWriter=response.getWriter();
		FindDao findDao=new FindDaoimp();

		System.out.println("jiekou2ceshi");
		
			for(int j= 0;j<findDao.acommandEssay(classfy, uno).size();j++){
				
			    jsonArrayList.add(gson.toJson(findDao.acommandEssay(classfy, uno).get(j)));
			}
		
		
		outPrintWriter.print(jsonArrayList);
		return null;
		
	}

}
