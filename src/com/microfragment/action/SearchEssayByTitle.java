package com.microfragment.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;

import com.microfragment.dao.SearchDaoimp;
import com.microfragment.dao.SerchDao;
import com.opensymphony.xwork2.ActionContext;

public class SearchEssayByTitle {
	private String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	//private FindJsonResponse findJsonResponse=new FindJsonResponse();
	public String execute() throws IOException{
		Gson gson=new Gson();
		ArrayList<String> jsonArrayList=new ArrayList<String>();
		ActionContext ctx=ActionContext.getContext();
		HttpServletResponse response=(HttpServletResponse)ctx.get(ServletActionContext.HTTP_RESPONSE);
		response.setContentType("text/json");
		response.setCharacterEncoding("utf-8");
		PrintWriter outPrintWriter=response.getWriter();
		SerchDao serchDao=new SearchDaoimp();

		System.out.println("jiekou2ceshi");
	
			for(int j= 0;j<serchDao.serchEssayByTitle(title).size();j++){
				
			    jsonArrayList.add(gson.toJson(serchDao.serchEssayByTitle(title).get(j)));
			}
		
		
		outPrintWriter.print(jsonArrayList);
		return null;
		
	}


}
