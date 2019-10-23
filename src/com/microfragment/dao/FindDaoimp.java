package com.microfragment.dao;







import java.util.List;


import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;

import com.microfragment.entity.Essay;

import com.microfragment.util.HibernateSessionFactory;






public class FindDaoimp implements FindDao {
private Transaction transaction;
	@Override
	public Essay getEssay(int uno) {
		Session session=HibernateSessionFactory.getSession();
		Essay essay=(Essay)session.load(Essay.class, uno);
		return essay;
	}

	@SuppressWarnings("rawtypes" )
	@Override
	public List findJsonResponse() {
		
	
		
			Session session=HibernateSessionFactory.getSession();
			transaction=session.beginTransaction();
			String hql="select ualias,eno,b.uno as uno,etitle,econtent,eclass,edate,eimg,(select count(eno) from ethomb where eno=b.eno) as ThombNumber from user as a,essay as b where a.uno=b.uno  ORDER BY Edate desc";
			SQLQuery query= (SQLQuery) session.createSQLQuery(hql).
					addScalar("eclass",StandardBasicTypes.STRING).//4
				
			addScalar("econtent",StandardBasicTypes.STRING).//3
			addScalar("edate",StandardBasicTypes.STRING).//5
			addScalar("eimg",StandardBasicTypes.STRING).//6
			
			addScalar("ualias",StandardBasicTypes.STRING).
			addScalar("ThombNumber",StandardBasicTypes.INTEGER).
			addScalar("uno",StandardBasicTypes.INTEGER).
			addScalar("eno",StandardBasicTypes.INTEGER).//1
			addScalar("etitle",StandardBasicTypes.STRING).//2
			addScalar("ThombNumber",StandardBasicTypes.INTEGER)//7
			.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
			transaction.commit();
			return query.list();
			
			//HibernateSessionFactory.closeSession();
		
		
		
		
		
	}

	@SuppressWarnings("rawtypes" )
	@Override
	public List essaybyclass(String classsString) {
		Session session=HibernateSessionFactory.getSession();
		transaction=session.beginTransaction();
		String sql="";
		if(classsString.equals("全部")){
			sql="SELECT ualias,eno,b.uno,etitle,eimg,edate,econtent,eclass, (select count(eno) from ethomb where eno=b.eno) as ThombNumber FROM user as a,essay as b WHERE a.uno=b.uno  ORDER BY edate DESC,ThombNumber DESC";
		}else{
		
		 sql="SELECT ualias,eno,b.uno,etitle,eimg,edate,econtent,eclass, (select count(eno) from ethomb where eno=b.eno) as ThombNumber FROM user as a,essay as b WHERE a.uno=b.uno and b.Eclass='"+classsString+"' ORDER BY edate DESC,ThombNumber DESC";
		}
		SQLQuery query= (SQLQuery) session.createSQLQuery(sql).
				addScalar("eclass",StandardBasicTypes.STRING).//4
		addScalar("econtent",StandardBasicTypes.STRING).//3
		addScalar("edate",StandardBasicTypes.STRING).
		
		addScalar("eimg",StandardBasicTypes.STRING).//6
		addScalar("ualias",StandardBasicTypes.STRING).//1
		addScalar("etitle",StandardBasicTypes.STRING).//2
		addScalar("ThombNumber",StandardBasicTypes.INTEGER).
		addScalar("eno",StandardBasicTypes.INTEGER).
		addScalar("uno",StandardBasicTypes.INTEGER)//7
		.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		transaction.commit();
		System.out.println(query.list());	
		return query.list();
	}


	

}
