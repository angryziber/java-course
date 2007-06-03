package net.azib.java.students.t060401.homework.util;

/**
 * HibernateUtil
 * 
 * Sets up SessionFactory which takes care of starting Hibernate's Session
 * A SessionFactory is responsible for one database and may only use one XML configuration file (hibernate.cfg.xml)
 * @author t060401
 */

import java.net.URL;

import org.hibernate.*;
import org.hibernate.cfg.*;

public class HibernateUtil {

	private static final SessionFactory sessionFactory;

	static {
		try {
			URL url = HibernateUtil.class.getResource("hibernate.cfg.xml");
			// Create the SessionFactory from hibernate.cfg.xml
			sessionFactory = new Configuration().configure(url).buildSessionFactory();
		}
		catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	/**
	 * @return returns SessionFactory for opening and closing sessions
	 */
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
