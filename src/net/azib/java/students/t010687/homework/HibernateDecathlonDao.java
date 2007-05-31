package net.azib.java.students.t010687.homework;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 * HibernateStudentDao
 *
 * @author Matu
 */
public class HibernateDecathlonDao implements DecathlonDao {
	
	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public List<ResultsOfTheAthlet> getCompetition_id(int competition_id) {
		//List<ResultsOfTheAthlet> Results = hibernateTemplate.findByNamedQueryAndNamedParam("Decathlon.getCompetition_id", "competition_id", competition_id);
		//return Results;
		return (List<ResultsOfTheAthlet>) hibernateTemplate.findByNamedQueryAndNamedParam("Decathlon.getCompetition_id", "competition_id", competition_id);
	}

	public List<Competition> getCompetitions() {
		return (List<Competition>) hibernateTemplate.findByNamedQueryAndNamedParam("Decathlon.getCompetitions", "zero", 0);
	}

}
