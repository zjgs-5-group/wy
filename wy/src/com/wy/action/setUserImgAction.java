package com.wy.action;
//1.2.4设置用户头像 返回图片路径
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.wy.dao.UserDao;
import com.wy.dao.UserDaoImpl;
import com.wy.until.JsonRespense;

public class setUserImgAction {
	private JsonRespense jsonResponse = new JsonRespense();
	private int uno;
	public int getUno() {
		return uno;
	}
	public void setUno(int uno) {
		this.uno = uno;
	}
	public String execute() throws IOException{
		Gson gson = new Gson();
		ActionContext ctx = ActionContext.getContext();
		HttpServletResponse response = (HttpServletResponse)ctx.get(ServletActionContext.HTTP_RESPONSE);
		response.setContentType("text/json");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		UserDao dao = new UserDaoImpl();
		String str = dao.setUserImg(uno);
		if(str==null)jsonResponse.setImg_address(null);
		else
			jsonResponse.setImg_address(str);
		out.print(gson.toJson(jsonResponse));   
		return null;
	}
}
