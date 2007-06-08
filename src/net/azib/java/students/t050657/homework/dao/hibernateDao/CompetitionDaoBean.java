package net.azib.java.students.t050657.homework.dao.hibernateDao;

import net.azib.java.students.t050657.homework.dao.CompetitionDao;
import net.azib.java.students.t050657.homework.model.Competition;

import java.util.List;

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
	
	/**
	 * Method gets all competitions from DB by named query
	 */
	public List<Competition> getCompetition(){
		return hibernateTemplate.findByNamedQuery("Competition.getCompetitions", null);
	}
	
}
