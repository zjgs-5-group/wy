package com.wy.action;
//2.10 显示评论
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.wy.dao.CommentDao;
import com.wy.dao.CommentDaoImpl;
import com.wy.until.JsonRespense;

public class ShowComment {
	private JsonRespense jsonResponse = new JsonRespense();
	private int userId;
	private int fragId;
	private String data;
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
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String execute() throws IOException{
		Gson gson = new Gson();
		ActionContext ctx = ActionContext.getContext();
		HttpServletResponse response = (HttpServletResponse)ctx.get(ServletActionContext.HTTP_RESPONSE);
		response.setContentType("text/json");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		CommentDao dao = new CommentDaoImpl();
		String str = dao.showComment(userId, fragId, data);
		jsonResponse.setComment(str);
		out.print(gson.toJson(jsonResponse));
		return null;
	}
}
