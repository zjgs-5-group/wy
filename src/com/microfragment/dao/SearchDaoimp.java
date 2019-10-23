package com.microfragment.dao;

import java.util.Arrays;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;

import com.microfragment.util.HibernateSessionFactory;

public class SearchDaoimp implements SerchDao{
private Transaction transaction;
	@SuppressWarnings("rawtypes")
	@Override
	public List serchEssayByTitle(String title) {
		
	
			Session session=HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			System.out.printf("1234456");
			if(!title.equals("")){
				String[] strings=title.split("");
				List list =Arrays.asList(strings);
				
				
				
				String hql="select eno,a.uno as uno,ualias,etitle,econtent,eclass,edate,eimg,(select count(eno) from ethomb where eno=b.eno) as ThombNumber from user as a,essay as b where a.uno=b.uno and b.Etitle like '%";
				for(int i=0;i<list.size();i++){
					hql+=list.get(i)+"%";
				}
				hql+="' ORDER BY edate desc";
				SQLQuery query= (SQLQuery) session.createSQLQuery(hql).
						addScalar("eclass",StandardBasicTypes.STRING).//4
						addScalar("ThombNumber",StandardBasicTypes.INTEGER).//8
						addScalar("eno",StandardBasicTypes.INTEGER).//8
						addScalar("uno",StandardBasicTypes.INTEGER).//8
				addScalar("econtent",StandardBasicTypes.STRING).//3
				addScalar("edate",StandardBasicTypes.STRING).//5
				addScalar("eimg",StandardBasicTypes.STRING).//6
				addScalar("ualias",StandardBasicTypes.STRING).//1
				addScalar("etitle",StandardBasicTypes.STRING).//2
				
				setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
				transaction.commit();
				System.out.printf("654321");
				System.out.printf("754321");	
				return query.list();
			}
			
		return null;
	}

}
