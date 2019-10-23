package com.microfragment.dao;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;



import com.microfragment.entity.Essay;

import com.microfragment.util.HibernateSessionFactory;



public class MineDaoimp implements MineDao {
	private Transaction transaction;
	

	@SuppressWarnings("rawtypes")
	@Override
	public List getUserInfo(int uno) {
		try {
			Session session=HibernateSessionFactory.getSession();
			transaction=session.beginTransaction();
			String hql="select ubg,uimg,ualias,usign from user where uno="+uno;
			SQLQuery query= (SQLQuery) session.createSQLQuery(hql).
					addScalar("ubg",StandardBasicTypes.STRING).
					addScalar("uimg",StandardBasicTypes.STRING).//4

			addScalar("ualias",StandardBasicTypes.STRING).//3
			addScalar("usign",StandardBasicTypes.STRING).//5
			setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
			transaction.commit();
		return query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	
	


	
	@Override
	public boolean deletemyessay(int uno,int eno) {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		transaction=session.beginTransaction();
		String hql = "from Essay as a where a.uno = "+uno+" and a.eno="+eno;
		Query query = (Query)session.createQuery(hql);
		transaction.commit();
		Essay essay = (Essay)query.uniqueResult();
		if(essay!=null){
			transaction = session.beginTransaction();
			session.delete(essay);
			transaction.commit();
			return true;
		}
		return false;
	}



	@SuppressWarnings("rawtypes")
	@Override
	public List getmyessay(int uno) {
		try {
			Session session=HibernateSessionFactory.getSession();
			transaction=session.beginTransaction();
			//System.out.printf("1234456");
			String hql="select eno,etitle,econtent,eclass,edate,eimg,(select count(eno) from ethomb where eno=b.eno) as ThombNumber from user as a,essay as b where a.uno=b.uno and a.uno="+uno+" ORDER BY Edate desc";
			SQLQuery query= (SQLQuery) session.createSQLQuery(hql).
					addScalar("edate",StandardBasicTypes.STRING).
					addScalar("etitle",StandardBasicTypes.STRING).//4
					
			addScalar("econtent",StandardBasicTypes.STRING).//3
			
			addScalar("eno",StandardBasicTypes.INTEGER).
			addScalar("eclass",StandardBasicTypes.STRING).//5
			addScalar("eimg",StandardBasicTypes.STRING).//6
			
			addScalar("ThombNumber",StandardBasicTypes.INTEGER)//7
			.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
			transaction.commit();
		return query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
