package com.microfragment.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;

import com.microfragment.util.HibernateSessionFactory;

public class MineDaoimp implements MineDao {

	@SuppressWarnings("rawtypes")
	@Override
	public List userCollect(int uno) {
		Session session=HibernateSessionFactory.getSession();
		System.out.printf("1234456");
		String hql="select (select ualias from user where uno=b.uno) as NameOfAuthor,etitle,econtent,eclass,edate,eimg,(select count(eno) from Ethomb where eno=b.eno) as ThombNumber,(select count(eno) from collect where eno=b.eno) as SaveNumber from essay as b,collect as c where c.eno=b.eno and c.uno="+uno;
		SQLQuery query= (SQLQuery) session.createSQLQuery(hql).
				addScalar("NameOfAuthor",StandardBasicTypes.STRING).
				addScalar("eclass",StandardBasicTypes.STRING).//4
				addScalar("SaveNumber",StandardBasicTypes.INTEGER).//8
		addScalar("econtent",StandardBasicTypes.STRING).//3
		addScalar("edate",StandardBasicTypes.STRING).//5
		addScalar("eimg",StandardBasicTypes.STRING).//6
		addScalar("etitle",StandardBasicTypes.STRING).//2
		addScalar("ThombNumber",StandardBasicTypes.INTEGER)//7
		.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
			
	return query.list();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getNumberOfFocuFansThomb(int uno) {
		Session session=HibernateSessionFactory.getSession();
		System.out.printf("1234456");
		String hql="select (select count(Fpassiveuno) from focu where Factiveuno="+uno+") as NumberOfMyFocu,(select count(Factiveuno) from focu where Fpassiveuno="+uno+") as NumberOfMyFans,(select count(ETUnoactive) from essay as b,ethomb as a where b.uno = "+uno+" and a.eno=b.eno) as NumberOfMyThomb";
		SQLQuery query= (SQLQuery) session.createSQLQuery(hql).
				addScalar("NumberOfMyFocu",StandardBasicTypes.INTEGER).
				addScalar("NumberOfMyFans",StandardBasicTypes.INTEGER).//8
		addScalar("NumberOfMyThomb",StandardBasicTypes.INTEGER)//7
		.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
			
	return query.list();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getUserOfMyFocu(int uno) {
		Session session=HibernateSessionFactory.getSession();
		System.out.printf("1234456");
		String hql="select ualias,uimg from user as a,focu as b where b.Fpassiveuno=a.uno and b.Factiveuno="+uno;
		SQLQuery query= (SQLQuery) session.createSQLQuery(hql).
				addScalar("ualias",StandardBasicTypes.STRING).
				addScalar("uimg",StandardBasicTypes.STRING).//4
		setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
			
	return query.list();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getUaliasImgOfMyFansMyFocu(int uno) {
		Session session=HibernateSessionFactory.getSession();
		System.out.printf("1234456");
		String hql="select ualias as NameOfMyFans,uimg from user,focu where Factiveuno=uno and Fpassiveuno="+uno;
		SQLQuery query= (SQLQuery) session.createSQLQuery(hql).
				addScalar("NameOfMyFans",StandardBasicTypes.STRING).
				addScalar("uimg",StandardBasicTypes.STRING).//4
		setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
			
	return query.list();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getUserInfo(int uno) {
		Session session=HibernateSessionFactory.getSession();
		String hql="select ubg,uimg,ualias,usign from user where uno="+uno;
		SQLQuery query= (SQLQuery) session.createSQLQuery(hql).
				addScalar("ubg",StandardBasicTypes.STRING).
				addScalar("uimg",StandardBasicTypes.STRING).//4

		addScalar("ualias",StandardBasicTypes.STRING).//3
		addScalar("usign",StandardBasicTypes.STRING).//5
		setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
			
	return query.list();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List tgetHistoryOfScan(int uno) {
		Session session=HibernateSessionFactory.getSession();
		System.out.printf("1234456");
		String hql="select distinct ualias as authorname ,etitle,econtent,eclass,hsdate,(select count(eno) from Ethomb where eno=b.eno) as ThombNumber,(select count(eno) from collect where eno=b.eno) as SaveNumber from user as a,essay as b,hscan  as c where c.eno=b.eno and a.uno=b.uno and c.uno ="+uno;
		SQLQuery query= (SQLQuery) session.createSQLQuery(hql).
				addScalar("authorname",StandardBasicTypes.STRING).
				addScalar("etitle",StandardBasicTypes.STRING).//4
				addScalar("SaveNumber",StandardBasicTypes.INTEGER).//8
		addScalar("econtent",StandardBasicTypes.STRING).//3
		addScalar("eclass",StandardBasicTypes.STRING).//5
		addScalar("eimg",StandardBasicTypes.STRING).//6
		addScalar("hsdate",StandardBasicTypes.STRING).//2
		addScalar("ThombNumber",StandardBasicTypes.INTEGER)//7
		.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
			
	return query.list();
	}

}
