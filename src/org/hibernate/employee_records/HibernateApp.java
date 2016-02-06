package org.hibernate.employee_records;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * 
 * @author aakash.gupta
 *
 */
public class HibernateApp {

	public static void main(String ...args) {
		Session session=configureHibernate();
		StoreDetails details=new StoreDetails();
		//details.storeDetails(session);
		//details.updateDetails(session, 4321);
		details.deleteDetails(session, 4321);
		session.close();
	}
	public static Session configureHibernate(){
		Configuration configuration=new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory=configuration.buildSessionFactory();
		Session session=sessionFactory.openSession();
		return session;
	}
}