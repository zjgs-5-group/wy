package com.wy.dao;

import java.text.SimpleDateFormat;

import java.util.Date;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wy.entity.Comment;
import com.wy.entity.CommentId;
import com.wy.until.HibernateSessionFactory;

public class CommentDaoImpl implements CommentDao {
	private Transaction transaction;
	@Override
	public void FragComment(int uno,int eno,String str) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String t = sdf.format(date);
		Session session = HibernateSessionFactory.getSession();
		try{
			transaction = session.beginTransaction();
			CommentId cd = new CommentId(uno,eno,t);
			Comment ct = new Comment(cd,str);
			session.save(ct);
			transaction.commit();
		}catch(Exception e){
			transaction.rollback();
			throw new RuntimeException(e);
		}finally{
			HibernateSessionFactory.closeSession();
		}
	}
	@Override
	public String showComment(int userId, int fragId, String data) {
		Session session = HibernateSessionFactory.getSession();
		String hql = "select a.ccontent from Comment as a where a.id.cunoactive = '"+userId+"'and a.id.eno = '"+fragId+"'and a.id.cdate = '"+data+"'";
		Query query = (Query)session.createQuery(hql);
		String s = (String)query.uniqueResult();
		HibernateSessionFactory.closeSession();
		System.out.println(s);
		return s;
		
		
	}
}
