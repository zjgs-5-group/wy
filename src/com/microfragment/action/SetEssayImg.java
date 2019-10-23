package com.microfragment.action;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.microfragment.dao.UserDao;
import com.microfragment.dao.UserDaoImpl;
import com.microfragment.util.JsonResponse;
import com.opensymphony.xwork2.ActionContext;

import sun.misc.BASE64Decoder;

public class SetEssayImg {
	private JsonResponse jsonResponse = new JsonResponse();
	private int eno;
	public int getEno() {
		return eno;
	}
	public void setEno(int eno) {
		this.eno = eno;
	}
	private String upload;
	
	public String getUpload() {
		return upload;
	}
	public void setUpload(String upload) {
		this.upload = upload;
	}
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
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");  
        response.setHeader("Access-Control-Max-Age", "3600");  
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        PrintWriter out = response.getWriter();
        BASE64Decoder decoder=new BASE64Decoder(); 
        
        try {
        	byte[] b = decoder.decodeBuffer(upload);
            for(int i=0;i<b.length;++i)
            {
                if(b[i]<0)
                {
                    b[i]+=256;
                }
            }
            OutputStream out1 = null;
            
            	out1 = new FileOutputStream("D:/myeclipse/workspace/.metadata/.me_tcat85/webapps/image/essay"+uno+".jpg");
            
          
            out1.write(b);
            out1.flush();
            out1.close();
        	} catch (IOException e) {
        	e.printStackTrace();
        	}       

		 UserDao userDao=new UserDaoImpl();
		 
		 boolean c=userDao.setEssaymage(eno,"http://192.168.43.249:8080/image/essay/"+uno+".jpg");
		if(c){
			jsonResponse.setStatus("200");
		}
		else
		{
			jsonResponse.setStatus("500");
		}
		out.print(gson.toJson(jsonResponse));
		return null;
	}
}
