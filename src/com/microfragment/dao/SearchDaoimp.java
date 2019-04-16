package com.microfragment.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;

import com.microfragment.util.HibernateSessionFactory;

public class SearchDaoimp implements SerchDao{

	@SuppressWarnings("rawtypes")
	@Override
	public List serchEssayByTitle(String title) {
		
	
			Session session=HibernateSessionFactory.getSession();
			System.out.printf("1234456");
			String hql="select ualias,etitle,econtent,eclass,edate,eimg,(select count(eno) from Ethomb where eno=b.eno) as ThombNumber,(select count(eno) from collect where eno=b.eno ) as SaveNumber from user as a,essay as b where a.uno=b.uno and b.Etitle='"+title+"'";
			SQLQuery query= (SQLQuery) session.createSQLQuery(hql).
					addScalar("eclass",StandardBasicTypes.STRING).//4
					addScalar("SaveNumber",StandardBasicTypes.INTEGER).//8
			addScalar("econtent",StandardBasicTypes.STRING).//3
			addScalar("edate",StandardBasicTypes.STRING).//5
			addScalar("eimg",StandardBasicTypes.STRING).//6
			addScalar("ualias",StandardBasicTypes.STRING).//1
			addScalar("etitle",StandardBasicTypes.STRING).//2
			addScalar("ThombNumber",StandardBasicTypes.INTEGER)//7
			.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
			System.out.printf("654321");
			System.out.printf("754321");	
			return query.list();
		
	}

}
