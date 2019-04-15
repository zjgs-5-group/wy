package com.wy.action;
//2.7 关注
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.wy.dao.FocuDao;
import com.wy.dao.FocuDaoImpl;
import com.wy.until.JsonRespense;

public class fragFocus {
	private JsonRespense jsonResponse = new JsonRespense();
	private int userId;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String execute() throws IOException{
		Gson gson = new Gson();
		ActionContext ctx = ActionContext.getContext();
		HttpServletResponse response = (HttpServletResponse)ctx.get(ServletActionContext.HTTP_RESPONSE);
		response.setContentType("text/json");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		FocuDao dao = new FocuDaoImpl();
		List<Integer> l = dao.fragFocus(userId);
		List<JsonRespense> jss = new ArrayList<JsonRespense>();
		for(int i=0;i<l.size()&&null!=l;i++)
		{
			JsonRespense temp = new JsonRespense();
			temp.setUno(l.get(i));
			jss.add(temp);
		}
		for(int i=0;null!=l&&i<l.size();i++)
		{
			out.print(gson.toJson(jss.get(i)));
		}
		return null;
	}
}
