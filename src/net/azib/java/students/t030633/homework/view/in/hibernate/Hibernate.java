package net.azib.java.students.t030633.homework.view.in.hibernate;

import net.azib.java.students.t030633.homework.model.Athlete;
import net.azib.java.students.t030633.homework.model.AthleteBuilder;
import net.azib.java.students.t030633.homework.model.Event;
import net.azib.java.students.t030633.homework.view.in.Input;
import net.azib.java.students.t030633.homework.view.in.hibernate.athletes.HibAthlete;
import net.azib.java.students.t030633.homework.view.in.hibernate.competitions.HibCompetition;
import net.azib.java.students.t030633.homework.view.in.hibernate.results.HibResult;
import net.azib.java.students.t030633.homework.view.in.hibernate.util.HibernateUtil;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import org.hibernate.Query;
import org.hibernate.Session;

/**
 * Database input with Hibernate.
 * 
 * @author t030633
 */
public class Hibernate implements Input {

	private String search;

	@SuppressWarnings("unchecked")
	// Hibernate doesn't have generics
	public List<Athlete> read(AthleteBuilder builder) throws IOException {

		// Set Hibernate logging level to severe
		Logger.getLogger("org.hibernate").setLevel(java.util.logging.Level.SEVERE);

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<Athlete> list = new LinkedList<Athlete>();

		try {
			session.beginTransaction();

			Query query = session.createQuery("from HibCompetition as c where c.id = ? or c.name = ?");
			try {
				int searchById = Integer.parseInt(search);
				query.setInteger(0, searchById).setString(1, search);
			}
			catch (NumberFormatException e) {
				query.setInteger(0, 0).setString(1, search);
			}
			// Get requested competitions
			List competitions = query.list();

			// Get all results from the competition (only one competition should
			// match)
			Set results = ((HibCompetition) competitions.get(0)).getResults();

			// Fill the list with athletes
			for (Iterator it = results.iterator(); it.hasNext();) {
				HibResult result = (HibResult) it.next();
				HibAthlete athlete = result.getAthlete();
				builder.name(athlete.getName());
				builder.date(athlete.getDob());
				builder.country(athlete.getCountry());

				builder.addResult(Event.R100M, round(result.getRace_100m()));
				builder.addResult(Event.LONGJ, round(result.getLong_jump()));
				builder.addResult(Event.SHOT, round(result.getShot_put()));
				builder.addResult(Event.HIGH, round(result.getHigh_jump()));
				builder.addResult(Event.R400M, round(result.getRace_400m()));
				builder.addResult(Event.R110MH, round(result.getHurdles_110m()));
				builder.addResult(Event.DISCUS, round(result.getDiscus_throw()));
				builder.addResult(Event.POLE, round(result.getPole_vault()));
				builder.addResult(Event.JAVELIN, round(result.getJavelin_throw()));
				builder.addResult(Event.R1500M, round(result.getRace_1500m()));

				list.add(builder.build());
			}

			session.getTransaction().commit();
		}
		finally {
			HibernateUtil.getSessionFactory().close();
		}
		return list;

	}

	private double round(float dbInputFloat) {
		return ((double) Math.round(dbInputFloat * 100) / 100);
	}

	public void setParameters(String... param) {
		search = param[1]; // Parameter 1 should be a search criterion
	}

}
