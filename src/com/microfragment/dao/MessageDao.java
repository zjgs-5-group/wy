package com.microfragment.dao;

import java.util.List;

public interface MessageDao {
@SuppressWarnings("rawtypes")
public List getMessageAudit(int uno,int eno);
@SuppressWarnings("rawtypes")
public List getNewFans(int uno);
@SuppressWarnings("rawtypes")
public List getPrivateMess(int uno);
@SuppressWarnings("rawtypes")
public List showNewComment(int uno,String ctime);
@SuppressWarnings("rawtypes")
public List showClick(int uno,String ctime);
}
