package com.wy.dao;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wy.entity.User;
import com.wy.entity.VerificationCode;
import com.wy.entity.VerificationCodeId;
import com.wy.until.HibernateSessionFactory;
import com.wy.until.PhoneCode;
public class PhoneImpl implements Phone {
	private Transaction transaction;
	@Override
	public boolean register(String userNumber) {
		if(userNumber!=null){
			Session session = HibernateSessionFactory.getSession();
			String hql = "from User as a where a.uphone = '"+userNumber+"'";
			Query query = (Query)session.createQuery(hql);
			User user = (User)query.uniqueResult();
			if(user==null)
			{
				PhoneCode pc = new PhoneCode();
				String code = pc.getPhonemsg(userNumber);
				System.out.println(code);
				Date date = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String t = sdf.format(date);
				VerificationCodeId vc = new VerificationCodeId(t,code);
				VerificationCode v = new VerificationCode(vc,userNumber);
				transaction = session.beginTransaction();
				session.save(v);
				transaction.commit();

				HibernateSessionFactory.closeSession();
				return true;
				
			}
		}
		HibernateSessionFactory.closeSession();
		return false;
	}
	@Override
	public boolean checkIn(String checkCode){
		Session session = HibernateSessionFactory.getSession();
		String hql = "select a.vphone from VerificationCode as a where a.id.vcode = '"+checkCode+"'";
		Query query = (Query)session.createQuery(hql);
		String phone = (String)query.uniqueResult();
		if(phone!=null)
		{
			User user = new User();
			user.setUphone(phone);
			transaction = session.beginTransaction();
			session.save(user);
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
			String hql = "from User as a where a.uphone = '"+phone+"'";
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
}
