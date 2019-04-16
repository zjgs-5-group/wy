package com.microfragment.dao;

import java.util.List;

public interface MineDao {
	@SuppressWarnings("rawtypes")
	public List userCollect(int uno);
	@SuppressWarnings("rawtypes")
	public List getNumberOfFocuFansThomb(int uno);
	@SuppressWarnings("rawtypes")
	public List getUserOfMyFocu(int uno);
	@SuppressWarnings("rawtypes")
	public List getUaliasImgOfMyFansMyFocu(int uno);
	@SuppressWarnings("rawtypes")
	public List getUserInfo(int uno);
	@SuppressWarnings("rawtypes")
	public List tgetHistoryOfScan(int uno);

}
