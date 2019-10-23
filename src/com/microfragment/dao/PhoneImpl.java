package com.microfragment.dao;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.microfragment.entity.User;


import com.microfragment.util.HibernateSessionFactory;

public class PhoneImpl implements Phone {
	private Transaction transaction;
	
	@Override
	public boolean register(String userNumber,String pwd) {
		if(userNumber!=null){
			Session session = HibernateSessionFactory.getSession();
			String hql = "from User as a where a.phone = '"+userNumber+"'";
			Query query = (Query)session.createQuery(hql);
			User user = (User)query.uniqueResult();
			transaction = session.beginTransaction();
			if(user==null)
			{
				
				User user2=new User();
				user2.setPhone(userNumber);
				user2.setUpwd(pwd);
				session.save(user2);
				
				}
				
			transaction.commit();
			HibernateSessionFactory.closeSession();
			
				return true;
				
			}
		HibernateSessionFactory.closeSession();
		
		return false;
	}
	
	@Override
	public boolean resetPassword(String phone,String password, String passWordble) {
		if(password.equals(passWordble))
		{
			Session session = HibernateSessionFactory.getSession();
			String hql = "from User as a where a.phone = '"+phone+"'";
			Query query = (Query)session.createQuery(hql);
			User user = (User)query.uniqueResult();
			if(user!=null)
			{
				transaction = session.beginTransaction();
				user.setUpwd(password);
				session.update(user);
				transaction.commit();
				HibernateSessionFactory.closeSession();
				return true;
			}
		}
		HibernateSessionFactory.closeSession();
		return false;
	}
	
	@Override
	public boolean forgetpwd(String userNumber) {
		if(userNumber!=null){
			Session session = HibernateSessionFactory.getSession();
			
			String hql = "from User as a where a.phone = '"+userNumber+"'";
			Query query = (Query)session.createQuery(hql);
			User user = (User)query.uniqueResult();
			if(user!=null)
			{
				HibernateSessionFactory.closeSession();
				return true;
				
			}
		}
		HibernateSessionFactory.closeSession();
		return false;
	}
	
}
