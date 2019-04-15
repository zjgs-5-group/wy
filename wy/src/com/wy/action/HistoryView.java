package com.wy.action;
//2.8 更新浏览历史
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.wy.dao.BrowsingHistoryDao;
import com.wy.dao.BrowsingHistoryDaoImpl;
import com.wy.until.JsonRespense;

public class HistoryView {
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
	private JsonRespense jsonResponse = new JsonRespense();
	public String execute() throws IOException{
		Gson gson = new Gson();
		ActionContext ctx = ActionContext.getContext();
		HttpServletResponse response = (HttpServletResponse)ctx.get(ServletActionContext.HTTP_RESPONSE);
		response.setContentType("text/json");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		BrowsingHistoryDao dao = new BrowsingHistoryDaoImpl();
		dao.HistoryView(userId, fragId);
		out.print(gson.toJson(jsonResponse));
		return null;
	}
}
