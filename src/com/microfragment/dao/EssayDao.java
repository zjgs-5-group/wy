package com.microfragment.dao;

import com.microfragment.entity.Essay;

import java.util.List;

public interface EssayDao {
	public String showFrag(int Eno);
	public Essay publishFrag(int userId,String frag, String frgtitle,String fragImg, String category);
	
}
