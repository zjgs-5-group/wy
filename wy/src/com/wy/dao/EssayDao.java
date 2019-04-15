package com.wy.dao;

public interface EssayDao {
	public String showFrag(int Eno);
	public void publishFrag(int userId,  int eno,String frag, String fragImg, String category);

}
