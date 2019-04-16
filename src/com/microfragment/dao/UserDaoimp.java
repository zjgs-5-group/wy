package com.microfragment.dao;



import org.hibernate.Session;
import org.hibernate.Transaction;

import com.microfragment.entity.User;
import com.microfragment.util.HibernateSessionFactory;
public class UserDaoimp implements Userinfo {
private Transaction transaction;
	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		Session session =HibernateSessionFactory.getSession();
		try{
			transaction=session.beginTransaction();
			session.save(user);
			transaction.commit();
		}catch(Exception e){
			transaction.rollback();
			e.printStackTrace();
		}finally {
			HibernateSessionFactory.closeSession();
		}
				}
	@Override
	public User getUser(int uno) {
		Session session =HibernateSessionFactory.getSession();
		User user=(User)session.load(User.class,uno);
		
		return user;
	}

}
