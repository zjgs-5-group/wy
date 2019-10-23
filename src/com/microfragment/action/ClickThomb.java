package com.microfragment.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.microfragment.dao.ThombDao;
import com.microfragment.dao.ThombDaoImpl;
import com.microfragment.util.JsonResponse;

public class ClickThomb {
	private JsonResponse jsonResponse = new JsonResponse();
	private int userId;
	private int fragId;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getFragId() {
		return fragId;
	}
	public void setFragId(int fragId) {
		this.fragId = fragId;
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

		ThombDao dao = new ThombDaoImpl();
		dao.clickOn(userId, fragId);
		jsonResponse.setStatus("200");
		out.print(gson.toJson(jsonResponse));
		return null;
	}
}
