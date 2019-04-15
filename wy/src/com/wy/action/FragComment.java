package com.wy.action;
//2.9 写评论
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.wy.dao.CommentDao;
import com.wy.dao.CommentDaoImpl;
import com.wy.until.JsonRespense;

public class FragComment {
	private JsonRespense jsonResponse = new JsonRespense();
	private int cunoactive;
	private int eno;
	public int getCunoactive() {
		return cunoactive;
	}
	public void setCunoactive(int cunoactive) {
		this.cunoactive = cunoactive;
	}
	public int getEno() {
		return eno;
	}
	public void setEno(int eno) {
		this.eno = eno;
	}
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	private String str;
	public String execute() throws IOException{
		Gson gson = new Gson();
		ActionContext ctx = ActionContext.getContext();
		HttpServletResponse response = (HttpServletResponse)ctx.get(ServletActionContext.HTTP_RESPONSE);
		response.setContentType("text/json");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		CommentDao dao = new CommentDaoImpl();
		dao.FragComment(cunoactive, eno, str);
		
		out.print(gson.toJson(jsonResponse));
		return null;
	}
}
