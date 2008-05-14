package net.azib.java.students.t030633.homework.view.in.hibernate.util;

import net.azib.java.students.t030633.homework.view.in.hibernate.athletes.HibAthlete;
import net.azib.java.students.t030633.homework.view.in.hibernate.competitions.HibCompetition;
import net.azib.java.students.t030633.homework.view.in.hibernate.results.HibResult;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

/**
 * TestSchema
 * 
 * @author t030633
 */
public class TestSchema {

	public static void setTestDatabase() {
		HibernateUtil.setSessionFactory(new Configuration().configure(TestSchema.class.getResource("test.cfg.xml"))
				.buildSessionFactory());
	}

	public static void addAthlete(HibAthlete athlete) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(athlete);
		session.getTransaction().commit();
	}

	public static void addResult(HibResult result) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(result);
		session.flush();
		session.getTransaction().commit();
	}

	public static void addCompetition(HibCompetition competition) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(competition);
		session.getTransaction().commit();
	}

}
