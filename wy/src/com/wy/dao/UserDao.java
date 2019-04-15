package com.wy.dao;

import java.util.List;

import com.wy.entity.User;

public interface UserDao {
	public boolean login(String userphone,String userpassword);
	public boolean setPassword(int uno,String useralias,String userpassword,String passwordble);
	public String setUserImg(int userID);	
	public User getPersonalInfo(int uno);
	public boolean changePersonalData (int userId, String userImage, String userName, String userSex, String userArea);
	public List<User> userFocusList(int userId);
}
