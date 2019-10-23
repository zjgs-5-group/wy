package com.microfragment.dao;


import java.util.List;

public interface MineDao {
	@SuppressWarnings("rawtypes")
	public List getUserInfo(int uno);
	public boolean deletemyessay(int uno ,int eno);
	@SuppressWarnings("rawtypes")
	public List getmyessay(int uno);
}
