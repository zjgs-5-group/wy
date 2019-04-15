package com.wy.action;
//7 发表页面
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.wy.dao.EssayDao;
import com.wy.dao.EssayDaoImpl;
import com.wy.until.JsonRespense;

public class PublishFrag {
	private JsonRespense jsonResponse = new JsonRespense();
	private int userId;
	private String frag;
	private String fragImg;
	private String category;
	private int eno;
	public int getEno() {
		return eno;
	}
	public void setEno(int eno) {
		this.eno = eno;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFrag() {
		return frag;
	}
	public void setFrag(String frag) {
		this.frag = frag;
	}
	public String getFragImg() {
		return fragImg;
	}
	public void setFragImg(String fragImg) {
		this.fragImg = fragImg;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	public String execute() throws IOException{
		Gson gson = new Gson();
		ActionContext ctx = ActionContext.getContext();
		HttpServletResponse response = (HttpServletResponse)ctx.get(ServletActionContext.HTTP_RESPONSE);
		response.setContentType("text/json");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		EssayDao dao = new EssayDaoImpl();
		dao.publishFrag(userId, eno, frag, fragImg, category);		
		out.print(gson.toJson(jsonResponse));   
		return null;
	}
}
