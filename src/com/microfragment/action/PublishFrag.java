package com.microfragment.action;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;

import sun.misc.BASE64Decoder;

import com.microfragment.dao.EssayDao;
import com.microfragment.dao.EssayDaoImpl;
import com.microfragment.dao.UserDao;
import com.microfragment.dao.UserDaoImpl;
import com.microfragment.entity.Essay;
import com.microfragment.util.JsonResponse;

public class PublishFrag {
	private JsonResponse jsonResponse = new JsonResponse();
	private int userId;
	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getFragTitle() {
		return fragTitle;
	}


	public void setFragTitle(String fragTitle) {
		this.fragTitle = fragTitle;
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


	private String fragTitle;
	private String frag;
	private String fragImg;
	private String category;
	
	
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
		System.out.print("jiekoujzpceshi");
		PrintWriter out = response.getWriter();
		EssayDao dao = new EssayDaoImpl();
		BASE64Decoder decoder=new BASE64Decoder(); 
		String s1=URLDecoder.decode(frag,"UTF-8");
		String s2=URLDecoder.decode(fragTitle,"UTF-8");
		String s3=URLDecoder.decode(category,"UTF-8");
		
		Essay essay=dao.publishFrag(userId,s1,s2,"null",s3);	
		
        	byte[] b = decoder.decodeBuffer(fragImg);
            for(int i=0;i<b.length;++i)
            {
                if(b[i]<0)
                {
                    b[i]+=256;
                }
            }
            OutputStream out1 = null;
            System.out.print("124560"+essay.getEno());
            	out1 = new FileOutputStream("D:/myeclipse/workspace/.metadata/.me_tcat85/webapps/image/essay/"+essay.getEno()+".jpg");
            	System.out.println("124560"+essay.getEno());
          
            out1.write(b);
            out1.flush();
            out1.close();
        	
		

        
        

		 UserDao userDao=new UserDaoImpl();
		 
		 boolean c=userDao.setEssaymage(essay.getEno(),"http://192.168.43.249:8080/image/essay/"+essay.getEno()+".jpg");
		 if(c){
			 jsonResponse.setStatus("200");
			 jsonResponse.setImg_address("http://192.168.43.249:8080/image/essay/"+essay.getEno()+".jpg");
			jsonResponse.setEno(essay.getEno());
		 }else{
			 jsonResponse.setStatus("500");
		 }
		
		out.print(gson.toJson(jsonResponse));   
		return null;
	
	}
}
