package com.microfragment.dao;

import java.util.List;


import com.microfragment.entity.Essay;



public interface FindDao {
public Essay getEssay(int uno);
@SuppressWarnings("rawtypes")
public List findJsonResponse();
@SuppressWarnings("rawtypes")
public List essaybyclass(String classsString);



}
