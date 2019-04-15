package com.wy.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;



import com.wy.entity.User;
import com.wy.until.HibernateSessionFactory;

public class UserDaoImpl implements UserDao {
	private Transaction transaction;
	@Override
	public boolean login(String userphone, String userpassword) {
	if(userphone!=null&&userpassword!=null)
		{
			Session session = HibernateSessionFactory.getSession();
			String hql = "from User as a where a.uphone = '"+userphone+"'and a.upwd = '"+userpassword+"'";
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

	@Override
	public boolean setPassword(int uno,String useralias, String userpassword, String passwordble) {
		
		Session session = HibernateSessionFactory.getSession();
		String hql = "from User as a where a.uno = '"+uno+"'";
		Query query = (Query)session.createQuery(hql);
		User user = (User)query.uniqueResult();
		if((user!=null))
		{	
			if(userpassword.equals(passwordble))
			{
				transaction = session.beginTransaction();
				user.setUalias(useralias);
				user.setUpwd(userpassword);
				session.update(user);
				transaction.commit();
				HibernateSessionFactory.closeSession();
				return true;
			}
			else
			{
				HibernateSessionFactory.closeSession();
				return false;
			}
		}
		HibernateSessionFactory.closeSession();
		return false;
	}

	@Override
	public String setUserImg(int userID) {
		Session session = HibernateSessionFactory.getSession();
		String hql = "from User as a where a.uno = '"+userID+"'";
		Query query = (Query)session.createQuery(hql);
		User user = (User)query.uniqueResult();
		if(user!=null)
		{
			HibernateSessionFactory.closeSession();
			return user.getUimg();
		}
		HibernateSessionFactory.closeSession();
		return null;
	}

	@Override
	public User getPersonalInfo(int uno) {
		Session session = HibernateSessionFactory.getSession();
		String hql = "from User as a where a.uno = '"+uno+"'";
		Query query = (Query)session.createQuery(hql);
		User user = (User)query.uniqueResult();
		if(user==null){
			HibernateSessionFactory.closeSession();
			return null;
		}
		else
		{
			HibernateSessionFactory.closeSession();
			return user;
		}
	}

	@Override
	public boolean changePersonalData(int userId, String userImage, String userName, String userSex, String userArea) {
		Session session = HibernateSessionFactory.getSession();
		String hql = "from User as a where a.uno = '"+userId+"'";
		Query query = (Query)session.createQuery(hql);
		User user = (User)query.uniqueResult();
		if((user!=null))
		{
			transaction = session.beginTransaction();
			user.setUimg(userImage);
			user.setUalias(userName);
			user.setUsex(userSex);
			user.setUarea(userArea);
			session.update(user);
			transaction.commit();
			HibernateSessionFactory.closeSession();
			return true;
		}
		HibernateSessionFactory.closeSession();
		return false;
	}

	@Override
	public List<User> userFocusList(int userId) {
		Session session = HibernateSessionFactory.getSession();
		String hql = "select a.id.fpassiveuno from Focu a where a.id.factiveuno = '"+userId+"'";
		Query query = (Query)session.createQuery(hql);
		List<Integer> list = query.list();

		//System.out.println(list.get(1));
		List<User> users = new ArrayList<User>();
		for(int i=0;null!=list&&i<list.size();i++)
		{
			String hql2 = "from User as a where a.uno = '"+list.get(i)+"'";
			Query query2 = (Query)session.createQuery(hql2);
			User user = (User)query2.uniqueResult();
			users.add(user);
			//System.out.println(users.get(i).getUalias());
		}
		
		return users;
	}

	
 
}
