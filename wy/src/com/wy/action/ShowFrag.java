package com.wy.action;
// 2.6 显示片段内容
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.wy.dao.EssayDao;
import com.wy.dao.EssayDaoImpl;
import com.wy.until.JsonRespense;

public class ShowFrag {
	private JsonRespense jsonResponse = new JsonRespense();
	private int eno;
	public String execute() throws IOException{
		Gson gson = new Gson();
		ActionContext ctx = ActionContext.getContext();
		HttpServletResponse response = (HttpServletResponse)ctx.get(ServletActionContext.HTTP_RESPONSE);
		response.setContentType("text/json");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();

		EssayDao dao = new EssayDaoImpl();
		String c = dao.showFrag(eno);
		if(c==null)jsonResponse.setEssay_content(null);
		else
			jsonResponse.setEssay_content(c);
		out.print(gson.toJson(jsonResponse));
		return null;
	}
	public int getEno() {
		return eno;
	}
	public void setEno(int eno) {
		this.eno = eno;
	}
}
