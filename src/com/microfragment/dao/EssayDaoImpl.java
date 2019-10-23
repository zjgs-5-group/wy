package com.microfragment.dao;

import java.text.SimpleDateFormat;
import java.util.Date;


import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;



import com.microfragment.entity.Essay;

import com.microfragment.util.HibernateSessionFactory;

public class EssayDaoImpl implements EssayDao {
	private Transaction transaction;
	@Override
	public String showFrag(int Eno) {
		Session session = HibernateSessionFactory.getSession();
		String hql = "from Essay as a where a.eno = '"+Eno+"'";
		transaction = session.beginTransaction();
		Query query = (Query)session.createQuery(hql);
		transaction.commit();
		Essay essay = (Essay)query.uniqueResult();
		if(essay!=null)
		{
			HibernateSessionFactory.closeSession();
			return essay.getEcontent();
		}
		HibernateSessionFactory.closeSession();
		return null;
	}
	@Override	
	public Essay publishFrag(int userId, String frag, String frgtitle,String fragImg, String category)
	{
		Session session = HibernateSessionFactory.getSession();
		try{
			transaction = session.beginTransaction();
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String t = sdf.format(date);
			Essay essay = new Essay(frgtitle,frag,t,category,userId,fragImg);
			session.save(essay);
			transaction.commit();
			return essay;		
		}catch(Exception e){
			transaction.rollback();
			throw new RuntimeException(e);
		}finally{
			HibernateSessionFactory.closeSession();
		}
	
		
	}
	
}
