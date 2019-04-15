package com.wy.dao;

import org.hibernate.Query;
import org.hibernate.Session;

import com.wy.until.HibernateSessionFactory;

public class ResponseDaoImpl implements ResponseDao {

	@Override
	public String showCommentReply(int Cno, int Eno) {
		Session session = HibernateSessionFactory.getSession();
		String hql = "select a.rcontent from Response as a where a.id.cno = '"+Cno+"'and a.id.eno = '"+Eno+"'";
		Query query = (Query)session.createQuery(hql);
		String s = (String)query.uniqueResult();
		HibernateSessionFactory.closeSession();
		System.out.println(s);
		return s;

	}

}
