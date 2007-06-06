package net.azib.java.students.t050657.homework.ctrl.dataAccess;

import net.azib.java.students.t050657.homework.dao.CompetitionDao;
import net.azib.java.students.t050657.homework.dao.ResultsDao;
import net.azib.java.students.t050657.homework.dao.hibernateDao.ResultsDaoBean;
import net.azib.java.students.t050657.homework.model.Competition;
import net.azib.java.students.t050657.homework.model.InsufficientResultsException;

import java.sql.Date;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * DBAccessor implementation of DataAccessor with use of hibernate and MySql as data-layer.
 *
 * @author Boriss
 */
public class DBAccessor implements DataAccessor{
	
	private CompetitionDao comDao;
	private ResultsDao resDao;
	
	/**
	 * Constructs new DBAccessor 
	 *
	 */
	public DBAccessor() {
		BeanFactory beanFactory = new XmlBeanFactory(
				new ClassPathResource("../../mapping/hbeans.xml",
				DBAccessor.class));
		
		comDao = (CompetitionDao) beanFactory.getBean(CompetitionDao.class.getName());
		resDao = (ResultsDao) beanFactory.getBean(ResultsDaoBean.class.getName());
		
	}

	public Competition getCompetition(String countryCode, Date date, String description) {
		Competition competition = comDao.getCompetition(countryCode, date, description);
		
		competition = resDao.getCompetitionResults(competition);
		
		try {
			competition.calculateAndSetPlaces();
		}
		catch (InsufficientResultsException e) {
			System.out.println("IRE Exception!");
		}
		
		return competition;
	}
	
	public CompetitionDao getComDao() {
		return comDao;
	}
	public void setComDao(CompetitionDao comDao) {
		this.comDao = comDao;
	}

	public ResultsDao getResDao() {
		return resDao;
	}

	public void setResDao(ResultsDao resDao) {
		this.resDao = resDao;
	}
}
