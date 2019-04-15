package com.wy.dao;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wy.until.HibernateSessionFactory;

public class FocuDaoImpl implements FocuDao {
	private Transaction transaction;
	@Override
	public List<Integer> fragFocus(int userId) {
		Session session = HibernateSessionFactory.getSession();
		String hql = "select a.id.fpassiveuno from Focu a where a.id.factiveuno = '"+userId+"'";
		Query query = (Query)session.createQuery(hql);
		List<Integer> list = query.list();
		
		return list;
	

	}

}
