package net.azib.java.students.t030633.homework.view.in.hibernate.util;

import net.azib.java.students.t030633.homework.DecathlonCalculator;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * HibernateUtil is a helper class which takes care of startup and makes
 * accessing a SessionFactory convenient.
 * 
 * @author t030633
 */
public class HibernateUtil {

	private static SessionFactory sessionFactory;

	public static synchronized SessionFactory getSessionFactory() {
		if(sessionFactory == null) {// Create the SessionFactory from hibernate.cfg.xml
			sessionFactory = new Configuration()
				.configure(DecathlonCalculator.class.getResource("db.properties"))
				.buildSessionFactory();
		}
		return sessionFactory;
	}
	
	public static void setSessionFactory(SessionFactory factory) {
		HibernateUtil.sessionFactory = factory;
	}

}
