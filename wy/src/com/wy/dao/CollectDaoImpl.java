package com.wy.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wy.entity.Collect;
import com.wy.entity.CollectId;
import com.wy.until.HibernateSessionFactory;

public class CollectDaoImpl implements CollectDao {

	private Transaction transaction;
	@Override
	public void fragCollect(int userId, int fragId) {
		Session session = HibernateSessionFactory.getSession();
		try{
			transaction= session.beginTransaction();
			CollectId c = new CollectId(userId,fragId);
			Collect cc = new Collect(c);
			session.save(cc);
			transaction.commit();
		}catch(Exception e){
			transaction.rollback();
			throw new RuntimeException(e);
		}finally{
			HibernateSessionFactory.closeSession();
		}

	}

}
