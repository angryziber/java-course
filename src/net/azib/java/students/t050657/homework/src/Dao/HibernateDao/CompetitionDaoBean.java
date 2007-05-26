package net.azib.java.students.t050657.homework.src.Dao.HibernateDao;

import net.azib.java.students.t050657.homework.src.Dao.CompetitionDao;
import net.azib.java.students.t050657.homework.src.model.Competition;

import org.springframework.orm.hibernate3.HibernateTemplate;

public class CompetitionDaoBean implements CompetitionDao{
	
	private HibernateTemplate hibernateTemplate;
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public Competition getCompetition(String countryCode, java.sql.Date date, String description) {
		return (Competition) hibernateTemplate.findByNamedQueryAndNamedParam("Competition.getByDescription", 
				new String[] {"countryCode", "date", "description"},
				new Object[] {countryCode, date, description}).get(0);
	}
	
}
