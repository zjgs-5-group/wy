package com.microfragment.dao;

import java.util.List;


import com.microfragment.entity.Essay;
import com.microfragment.util.FindJsonResponse;


public interface FindDao {
public Essay getEssay(int uno);
public List<FindJsonResponse> findJsonResponse(int foucusId);
public List<FindJsonResponse> essaybyclass(String classsString);
}