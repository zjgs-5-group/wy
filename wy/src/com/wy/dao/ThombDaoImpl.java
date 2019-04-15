package com.wy.dao;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wy.entity.Thomb;
import com.wy.entity.ThombId;
import com.wy.until.HibernateSessionFactory;

public class ThombDaoImpl implements ThombDao {

	private Transaction transaction;
	@Override
	public void clickOn(int userId, int fragId) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String t = sdf.format(date);
		Session session = HibernateSessionFactory.getSession();
		try{
			transaction = session.beginTransaction();
			Thomb td = new Thomb();
			ThombId thombid = new ThombId(userId,fragId,t);
			td.setId(thombid);
			session.save(td);
			transaction.commit();
		}catch(Exception e){
			transaction.rollback();
			throw new RuntimeException(e);
		}finally{
			HibernateSessionFactory.closeSession();
		}
	}

}
