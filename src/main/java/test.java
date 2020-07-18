
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.apache.taglibs.standard.lang.jstl.test.beans.Factory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import attendance.model.Punch;
import attendance.model.time;

import _00_init.util.HibernateUtils;

public class test {
	@SuppressWarnings("null")
	public static void main(String[] args) {
	SessionFactory facotry = HibernateUtils.getSessionFactory();
	Session session = facotry.getCurrentSession();
	Transaction tx = null;
	String hql = "UPDATE punch p SET p.punchDate = :punchDate WHERE punchId = :punchId";
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	java.sql.Timestamp ctime2 = new java.sql.Timestamp(new java.util.Date().getTime());
	System.out.println(ctime2);
	Punch punch = new Punch();
	try {
		tx =session.beginTransaction();
	session.saveOrUpdate(punch);
	int n = session.createQuery(hql)
				   .setParameter("punchId", 3)
				   .setParameter("punchDate", ctime2)
                   .executeUpdate();
		tx.commit();
	}catch (Exception e) {
		if(tx != null) {
			tx.rollback();
			e.printStackTrace();
		}
	}
	}
	
//	public static void main(String[] args) {
//
//		SessionFactory factory = HibernateUtils.getSessionFactory();
//		Session session = factory.getCurrentSession();
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		java.sql.Timestamp ctime2 = new java.sql.Timestamp(new java.util.Date().getTime());
//		System.out.println(ctime2);
//		time tm1 = new time(null, ctime2);
//		Transaction tx = null;
//		try {
//			tx =session.beginTransaction();
//			session.saveOrUpdate(tm1);
//			tx.commit();
//		} catch (Exception e) {
//			if(tx != null) {
//				tx.rollback();
//				e.printStackTrace();
//			}
//		}
//	}

}
