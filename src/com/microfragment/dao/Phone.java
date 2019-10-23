package com.microfragment.dao;




public interface Phone {
	public boolean register(String userNumber,String pwd);
	public boolean resetPassword(String phone,String password,String passWordble);
	public boolean forgetpwd(String userNumber);

}
