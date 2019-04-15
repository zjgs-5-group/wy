package com.wy.dao;

public interface CommentDao {
	public void FragComment(int cunoactive,int eno,String ccontent);
	public String showComment(int userId,int fragId,String data);
}
