package com.wy.action;
//2.11显示评论回复
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.wy.dao.ResponseDao;
import com.wy.dao.ResponseDaoImpl;
import com.wy.until.JsonRespense;

public class ShowCommentReply {
	private JsonRespense jsonResponse = new JsonRespense();
	private int cno;
	private int eno;
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public int getEno() {
		return eno;
	}
	public void setEno(int eno) {
		this.eno = eno;
	}
	public String execute() throws IOException{
		Gson gson = new Gson();
		ActionContext ctx = ActionContext.getContext();
		HttpServletResponse response = (HttpServletResponse)ctx.get(ServletActionContext.HTTP_RESPONSE);
		response.setContentType("text/json");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		ResponseDao dao = new ResponseDaoImpl();
		String str = dao.showCommentReply(cno, eno);
		jsonResponse.setCommentreply(str);
		out.print(gson.toJson(jsonResponse));
		return null;
	}
}
