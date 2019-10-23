package com.microfragment.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
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
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");  
        response.setHeader("Access-Control-Max-Age", "3600");  
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
		PrintWriter outPrintWriter=response.getWriter();
		SerchDao serchDao=new SearchDaoimp();

		System.out.println("jiekou2ceshi");
		String s1=URLDecoder.decode(title,"UTF-8");
			for(int j= 0;j<serchDao.serchEssayByTitle(s1).size();j++){
				
			    jsonArrayList.add(gson.toJson(serchDao.serchEssayByTitle(s1).get(j)));
			}
		
		
		outPrintWriter.print(jsonArrayList);
		return null;
		
	}


}
