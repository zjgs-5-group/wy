package com.microfragment.dao;


import java.util.ArrayList;
import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.microfragment.entity.Essay;
import com.microfragment.entity.User;
import com.microfragment.util.HibernateSessionFactory;

public class UserDaoImpl implements UserDao {
	private Transaction transaction;
	@Override
	public User login(String userphone, String userpassword) {
	if(userphone!=null&&userpassword!=null)
		{
			Session session = HibernateSessionFactory.getSession();
			String hql = "from User as a where a.phone = '"+userphone+"'and a.upwd = '"+userpassword+"'";
			Query query = (Query)session.createQuery(hql);
			User user = (User)query.uniqueResult();
			if(user!=null)
			{
				HibernateSessionFactory.closeSession();
				return user;
			}
		}
		HibernateSessionFactory.closeSession();
		return null;
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
	public boolean changePersonalData(int userId, int userAge,String userName, String userSex, String userArea,String userSign) {
		Session session = HibernateSessionFactory.getSession();
		String hql = "from User as a where a.uno = '"+userId+"'";
		Query query = (Query)session.createQuery(hql);
		User user = (User)query.uniqueResult();
		if((user!=null))
		{
			transaction = session.beginTransaction();
			user.setUage(userAge);
			user.setUalias(userName);
			user.setUsex(userSex);
			user.setUarea(userArea);
			user.setUsign(userSign);
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
		@SuppressWarnings("unchecked")
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
	
	@Override
	public boolean setImage(int uno,String type,String path) {
		
		
		Session session = HibernateSessionFactory.getSession();
		String hql = "from User as a where a.uno = '"+uno+"'";
		
		Query query = (Query)session.createQuery(hql);
		System.out.println("query");
		System.out.println(query);
		User user = (User)query.uniqueResult();
		if((user!=null))
		{
			transaction = session.beginTransaction();
			if(type.equals("head")){
				user.setUimg(path);
			}else if(type.equals("bg")){
				user.setUbg(path);
			}
			
			session.update(user);
			transaction.commit();
			HibernateSessionFactory.closeSession();
			return true;
		}
		HibernateSessionFactory.closeSession();
		return false;
	}

	@Override
	public boolean setEssaymage(int eno,String path) {
		Session session = HibernateSessionFactory.getSession();
		String hql = "from Essay as a where a.eno="+eno;
		
		Query query = (Query)session.createQuery(hql);
		Essay essay = (Essay)query.uniqueResult();
		if(essay!=null)
		{
			transaction = session.beginTransaction();
			
				essay.setEimg(path);
				System.out.print("jinruhanshu"+essay.getEno());
				
			
			
			session.update(essay);
			transaction.commit();
			HibernateSessionFactory.closeSession();
			return true;
		}
		HibernateSessionFactory.closeSession();
		return false;
	}

	
 
}
