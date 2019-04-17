package com.microfragment.dao;






import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;

import com.microfragment.entity.Essay;
import com.microfragment.util.FindJsonResponse;
import com.microfragment.util.HibernateSessionFactory;






public class FindDaoimp implements FindDao {

	@Override
	public Essay getEssay(int uno) {
		Session session=HibernateSessionFactory.getSession();
		Essay essay=(Essay)session.load(Essay.class, uno);
		return essay;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FindJsonResponse> findJsonResponse(int focusId) {
		
		FindDao findDao=new FindDaoimp();
		if(findDao.getEssay(focusId)!=null){
			Session session=HibernateSessionFactory.getSession();
			System.out.printf("1234456");
			String hql="select ualias,etitle,econtent,eclass,edate,eimg,(select count(eno) from Ethomb where eno=b.eno) as ThombNumber,(select count(eno) from collect where eno=b.eno ) as SaveNumber from user as a,essay as b where a.uno=b.uno and a.uno='"+focusId+"'";
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
		HibernateSessionFactory.closeSession();
		
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FindJsonResponse> essaybyclass(String classsString) {
		Session session=HibernateSessionFactory.getSession();
		String sql="SELECT ualias,etitle,eimg,edate,econtent,eclass, (select count(eno) from Ethomb where eno=b.eno) as ThombNumber,(select count(eno) from collect where eno=b.eno ) as SaveNumber FROM user as a,essay as b WHERE a.uno=b.uno and b.Eclass='"+classsString+"' ORDER BY ThombNumber DESC,SaveNumber DESC";
		SQLQuery query= (SQLQuery) session.createSQLQuery(sql).
				addScalar("eclass",StandardBasicTypes.STRING).//4
				addScalar("SaveNumber",StandardBasicTypes.INTEGER).//8
		addScalar("econtent",StandardBasicTypes.STRING).//3
		addScalar("edate",StandardBasicTypes.STRING).//5
		addScalar("eimg",StandardBasicTypes.STRING).//6
		addScalar("ualias",StandardBasicTypes.STRING).//1
		addScalar("etitle",StandardBasicTypes.STRING).//2
		addScalar("ThombNumber",StandardBasicTypes.INTEGER)//7
		.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		System.out.printf("754321");	
		System.out.println(query.list());	
		return query.list();
	}


	@SuppressWarnings("rawtypes")
	@Override
	public List acommandEssay(String classfy[],int uno[]) {
		Session session=HibernateSessionFactory.getSession();
		String hql="select ualias,etitle,econtent,eclass,edate,eimg,(select count(eno) from Ethomb where eno=b.eno) as ThombNumber,(select count(eno) from collect where eno=b.eno ) as SaveNumber from user as a,essay as b where a.uno=b.uno and (a.uno="+uno[0];
		for(int i=1;i<uno.length;i++){
			hql += " or a.uno="+uno[i];
		}
		
		for(int j=0;j<classfy.length;j++){
			hql += " or b.eclass='"+classfy[j]+"'";
		}
		hql += ")";
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
		System.out.printf("754321");	
		System.out.println(query.list());	
		return query.list();
	}

}
