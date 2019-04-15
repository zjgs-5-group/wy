package com.wy.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wy.entity.BrowsingHistory;
import com.wy.entity.BrowsingHistoryId;
import com.wy.until.HibernateSessionFactory;

public class BrowsingHistoryDaoImpl implements BrowsingHistoryDao {
	private Transaction transaction;
	@Override
	public void HistoryView(int userId, int fragid) {
		Session session = HibernateSessionFactory.getSession();
		try{
			transaction = session.beginTransaction();
			BrowsingHistoryId cjs = new BrowsingHistoryId(userId, fragid);
			BrowsingHistory b = new BrowsingHistory(cjs);
			session.save(b);
			transaction.commit();
		}catch(Exception e){
			transaction.rollback();
			throw new RuntimeException(e);			
		}finally{
			HibernateSessionFactory.closeSession();
		}
		
	}

}
