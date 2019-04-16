package com.microfragment.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;

import com.microfragment.util.HibernateSessionFactory;

public class MessageDaoimp implements MessageDao {

	@SuppressWarnings("rawtypes")
	@Override
	public List getMessageAudit(int uno, int eno) {
		Userinfo user=new UserDaoimp();
		if(user.getUser(uno)!= null){
			Session session=HibernateSessionFactory.getSession();
			String sql="SELECT eaudit from essay where uno="+uno+" and eno="+eno;
			SQLQuery query= (SQLQuery) session.createSQLQuery(sql).
					addScalar("eaudit",StandardBasicTypes.STRING)//4
					.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
			System.out.print(query.toString());
			return query.list();
		}
		HibernateSessionFactory.closeSession();
		return null;
		
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getNewFans(int uno) {
		Userinfo user=new UserDaoimp();
		if(user.getUser(uno)!= null){
			Session session=HibernateSessionFactory.getSession();
			String sql="SELECT factiveuno,(select Ualias from user where uno=b.Factiveuno) as NameOfFans from user as a,focu as b where a.uno=b.Fpassiveuno and a.uno="+uno;
			SQLQuery query= (SQLQuery) session.createSQLQuery(sql).
					addScalar("factiveuno",StandardBasicTypes.INTEGER).
					addScalar("NameOfFans",StandardBasicTypes.STRING)//4
					.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
			System.out.print(query.toString());
			return query.list();
		}
		HibernateSessionFactory.closeSession();
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getPrivateMess(int uno) {
		Userinfo user=new UserDaoimp();
		if(user.getUser(uno)!= null){
			Session session=HibernateSessionFactory.getSession();
			String sql="SELECT sunoactive,(select Ualias from user where uno=b.SUnoactive) as NameOfPrivate,Scontent from user as a,secret as b where a.uno=b.SUnopassive and a.uno="+uno;
			SQLQuery query= (SQLQuery) session.createSQLQuery(sql).
					addScalar("sunoactive",StandardBasicTypes.INTEGER).
					addScalar("NameOfPrivate",StandardBasicTypes.STRING).//4
					addScalar("scontent",StandardBasicTypes.STRING)
					.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
			System.out.print(query.toString());
			return query.list();
		}
		HibernateSessionFactory.closeSession();
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List showNewComment(int uno, String ctime) {
		Userinfo user=new UserDaoimp();
		if(user.getUser(uno)!= null){
			Session session=HibernateSessionFactory.getSession();
			String sql="SELECT (select Ualias from user where uno=b.CUnoactive) as NameOfComment ,(select Etitle from essay where eno=b.eno) as NameOfEssay,ccontent from user as a,comment as b ,essay as c where b.eno=c.eno and a.uno=c.Uno and c.uno="+uno+" and b.Cdate='"+ctime+"'";
			SQLQuery query= (SQLQuery) session.createSQLQuery(sql).
					addScalar("NameOfComment",StandardBasicTypes.STRING).
					addScalar("NameOfEssay",StandardBasicTypes.STRING).//4
					addScalar("ccontent",StandardBasicTypes.STRING)
					.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
			System.out.print(query.toString());
			return query.list();
		}
		HibernateSessionFactory.closeSession();
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List showClick(int uno, String ctime) {
		Userinfo user=new UserDaoimp();
		if(user.getUser(uno)!= null){
			Session session=HibernateSessionFactory.getSession();
			String sql="SELECT (select Ualias from user where uno=b.ETUnoactive) as NameOfClick ,(select Etitle from essay where eno=b.eno) as NameOfEssay from user as a,ethomb as b ,essay as c where b.eno=c.eno and a.uno=c.Uno and c.uno="+uno+" and b.etdate='"+ctime+"'";
			SQLQuery query= (SQLQuery) session.createSQLQuery(sql).
					addScalar("NameOfClick",StandardBasicTypes.STRING).
					addScalar("NameOfEssay",StandardBasicTypes.STRING).//4					
					setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
			System.out.print(query.toString());
			return query.list();
		}
		HibernateSessionFactory.closeSession();
		return null;
	}

}
