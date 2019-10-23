package com.microfragment.dao;


import java.util.List;

import com.microfragment.entity.User;

public interface UserDao {
	public User login(String userphone,String userpassword);
	public boolean setPassword(int uno,String useralias,String userpassword,String passwordble);
	public String setUserImg(int userID);	
	public User getPersonalInfo(int uno);
	public boolean changePersonalData (int userId, int userAge,String userName, String userSex, String userArea,String userSign);
	public List<User> userFocusList(int userId);
	public boolean setImage(int uno,String type,String path);
	public boolean setEssaymage(int eno,String path);
}
