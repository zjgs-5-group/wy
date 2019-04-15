package com.wy.action;
//9.2 文章更新的推送
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.wy.dao.UserDao;
import com.wy.dao.UserDaoImpl;
import com.wy.entity.User;
import com.wy.until.JsonRespense;

public class UFL {
	private JsonRespense jsonResponse = new JsonRespense();
	private int userId;

	public String execute() throws IOException{
		Gson gson = new Gson();
		ActionContext ctx = ActionContext.getContext();
		HttpServletResponse response = (HttpServletResponse)ctx.get(ServletActionContext.HTTP_RESPONSE);
		response.setContentType("text/json");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		UserDao dao = new UserDaoImpl();
		List<User> users= dao.userFocusList(userId);
		List<JsonRespense> jss = new ArrayList<JsonRespense>();
		for(int i=0;null!=users&&i<users.size();i++)
		{
			JsonRespense temp = new JsonRespense();
			temp.setAlias(users.get(i).getUalias());
			temp.setImg_address(users.get(i).getUimg());
			jss.add(temp);
		}
		for(int i=0;null!=users&&i<users.size();i++)
		{
			out.print(gson.toJson(jss.get(i)));
		}
		return null;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
}
