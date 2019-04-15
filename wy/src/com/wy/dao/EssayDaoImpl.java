package com.wy.dao;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wy.entity.Audit;
import com.wy.entity.Essay;

import com.wy.until.HibernateSessionFactory;

public class EssayDaoImpl implements EssayDao {
	private Transaction transaction;
	@Override
	public String showFrag(int Eno) {
		Session session = HibernateSessionFactory.getSession();
		String hql = "from Essay as a where a.eno = '"+Eno+"'";
		Query query = (Query)session.createQuery(hql);
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
	public void publishFrag(int userId,  int eno,String frag, String fragImg, String category)
	{
		Session session = HibernateSessionFactory.getSession();
		try{
			transaction = session.beginTransaction();
			Essay essay = new Essay(eno,null,frag,null,category,userId,fragImg,null);
//			essay.setEno(eno);
//			essay.setEcontent(frag);
//			essay.setEimg(fragImg);
//			essay.setEclass(category);
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String t = sdf.format(date);
			Audit audit = new Audit(eno,t,"审核中");
//			audit.setEno(eno);
//
//			audit.setAdate(t);
//			audit.setAstate("审核中");
			session.save(audit);
			session.save(essay);
			transaction.commit();

		}catch(Exception e){
			transaction.rollback();
			throw new RuntimeException(e);
		}finally{
			HibernateSessionFactory.closeSession();
		}
	
		
	}
}
