package com.wy.dao;

public interface Phone {
	public boolean register(String userNumber);
	public boolean checkIn(String checkCode);
	public boolean resetPassword(String phone,String password,String passWordble);
}
