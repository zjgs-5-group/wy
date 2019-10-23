package com.microfragment.dao;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;

import com.microfragment.entity.Ethomb;
import com.microfragment.entity.EthombId;
import com.microfragment.util.HibernateSessionFactory;




public  class ThombDaoImpl implements ThombDao {

	private Transaction transaction;
	@Override
	public void clickOn(int userId, int fragId) {
		Session session = HibernateSessionFactory.getSession();
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		String t = sdf.format(date);
		
		transaction = session.beginTransaction();
		EthombId thombid1 = new EthombId(userId,fragId);
		
		Ethomb ethomb=(Ethomb)session.get(Ethomb.class, thombid1);		
		
		
		if(ethomb==null){	
			Ethomb td = new Ethomb();
			EthombId thombid = new EthombId(userId,fragId);
			td.setId(thombid);
			td.setEtdate(t);
			session.save(td);
		}else{
			session.delete(ethomb);
		}
		transaction.commit();
		HibernateSessionFactory.closeSession();
		}
	
	
	}
	


