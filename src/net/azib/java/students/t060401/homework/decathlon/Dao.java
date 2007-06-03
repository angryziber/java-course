package net.azib.java.students.t060401.homework.decathlon;

import net.azib.java.students.t060401.homework.util.HibernateUtil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Session;

/**
 * Data access object
 * 
 * Contains set of methods for making queries in database. 
 * 
 * @author t060401
 */
public class Dao {

	private static Logger log = Logger.getLogger(Dao.class.getName());

	/**
	 * Returns all athletes (with decathlon results) who participated competition with given ID.
	 * 
	 * @param competitionId competition ID
	 * @return returns list of athletes
	 */
	public static List<Athlete> getAthletesWithResults(long competitionId) {
		List<Athlete> athletes = new ArrayList<Athlete>();
		List<DecathlonResults> resultsList = getResults(competitionId);
		Iterator<DecathlonResults> resultsIter = resultsList.iterator();
		while (resultsIter.hasNext()) {
			DecathlonResults results = (DecathlonResults) resultsIter.next();
			long athleteId = results.getAthleteId();
			Athlete athlete = getAthlete(athleteId);
			athlete.setDecathlonResults(results);
			athletes.add(athlete);
		}
		HibernateUtil.getSessionFactory();
		return athletes;
	}

	/**
	 * Returns all decathlon competitions from database.
	 * 
	 * @return returns competition vector
	 */
	public static Vector<Object> getCompetitions() {
		List<Competition> result = new ArrayList<Competition>();
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();

			session.beginTransaction();

			result = session.createQuery("from Competition").list();

			session.getTransaction().commit();
		}
		catch (Exception e) {
			log.log(Level.SEVERE, "Database error "+e);
		}
		finally {
			HibernateUtil.getSessionFactory().close();
		}
		return new Vector<Object>(result);
	}

	/**
	 * Gets athlete by ID
	 * 
	 * @param id athlete ID
	 * @return returns athlete
	 */
	private static Athlete getAthlete(long id) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
		Athlete result = (Athlete) session.load(Athlete.class, new Long(id));
		session.getTransaction().commit();

		return result;
	}

	/**
	 * Returns all the results of competition with given ID
	 * 
	 * @param competitionId
	 * @return returns list of decathlon results
	 */
	private static List<DecathlonResults> getResults(long competitionId) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();

		List<DecathlonResults> result = session.createQuery("from DecathlonResults as r where r.competitionId = ?").setFloat(0, competitionId)
				.list();

		session.getTransaction().commit();
		return result;
	}
}
