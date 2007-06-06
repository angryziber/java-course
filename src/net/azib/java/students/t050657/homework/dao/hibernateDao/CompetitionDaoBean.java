package net.azib.java.students.t050657.homework.dao.hibernateDao;

import net.azib.java.students.t050657.homework.dao.CompetitionDao;
import net.azib.java.students.t050657.homework.model.Competition;

import org.springframework.orm.hibernate3.HibernateTemplate;
/**
 * Implementation of CompetitionDao for MySql. 
 *
 * @author Boriss
 */
public class CompetitionDaoBean implements CompetitionDao{
	//машина, моё шаманство сильнее твоей тупости;
	private HibernateTemplate hibernateTemplate;
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public Competition getCompetition(String countryCode, java.sql.Date date, String description) {
		Competition competition = (Competition) hibernateTemplate.findByNamedQueryAndNamedParam("Competition.getByDescription", 
				new String[] {"countryCode", "date", "description"},
				new Object[] {countryCode, date, description}).get(0);
		return competition;
	}
	
}
