package net.azib.java.students.t060401.homework.decathlon;

import net.azib.java.students.t060401.homework.decathlon.model.AthleteVO;
import net.azib.java.students.t060401.homework.decathlon.model.CompetitionVO;
import net.azib.java.students.t060401.homework.decathlon.model.ResultsVO;
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
public class DecathlonDao {

	private static Logger log = Logger.getLogger(DecathlonDao.class.getName());

	/**
	 * Loads all the decathlon competitions from the database.
	 * 
	 * @return returns vector of competitions
	 */
	public static Vector<Object> getCompetitions() {
		List<CompetitionVO> result = new ArrayList<CompetitionVO>();
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();

			session.beginTransaction();

			result = session.createQuery("from CompetitionVO").list();

			session.getTransaction().commit();
		}
		catch (Exception e) {
			log.log(Level.SEVERE, "Database error: " + e);
		}
		return new Vector<Object>(result);
	}

	/**
	 * Loads athlete by ID from database
	 * 
	 * @param id athlete ID
	 * @return returns athlete
	 */
	public static AthleteVO getAthlete(long id) {
		AthleteVO result = new AthleteVO();
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();

			session.beginTransaction();
			result = (AthleteVO) session.load(AthleteVO.class, new Long(id));
			session.getTransaction().commit();
			HibernateUtil.getSessionFactory().close();
		}
		catch (Exception e) {
			log.log(Level.SEVERE, "Database error " + e);
		}
		return result;
	}

	/**
	 * Loads all the decathlon results of a competition with given ID
	 * 
	 * @param competitionId
	 * @return returns list of decathlon results
	 */
	public static List<ResultsVO> getResults(long competitionId) {
		List<ResultsVO> result = new ArrayList<ResultsVO>();
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();

			session.beginTransaction();

			result = session.createQuery("from ResultsVO as r where r.competitionId = ?").setFloat(0, competitionId).list();

			session.getTransaction().commit();
			HibernateUtil.getSessionFactory().close();
		}
		catch (Exception e) {
			log.log(Level.SEVERE, "Database error " + e);
		}
		return result;
	}
}
