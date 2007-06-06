package net.azib.java.students.t050657.homework.ctrl.dataAccess;

import net.azib.java.students.t050657.homework.dao.CompetitionDao;
import net.azib.java.students.t050657.homework.dao.csvFileDao.CompetitionDaoBean;
import net.azib.java.students.t050657.homework.model.Competition;
import net.azib.java.students.t050657.homework.model.InsufficientResultsException;

import java.sql.Date;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * CSVFileAccessor implementation of DataAccessor with use of CSV as data-layer.
 *
 * @author Boriss
 */
public class CSVFileAccessor implements DataAccessor{
	
	private String filepath = null;

	public Competition getCompetition(String countryCode, Date date, String description) {
		BeanFactory beanFactory = new XmlBeanFactory(
				new ClassPathResource("../../mapping/fbeans.xml",
				CSVFileAccessor.class));
		
		CompetitionDaoBean competitionDao = (CompetitionDaoBean) beanFactory.getBean(CompetitionDao.class.getName());
		competitionDao.setFilepath(this.filepath);
		
		Competition competition = competitionDao.getCompetition(countryCode, date, description);
		
		try {
			competition.calculateAndSetPlaces();
		}
		catch (InsufficientResultsException e) {
			System.out.println("IRE Exception!");
		}
		
		return competition;
	}

	public CSVFileAccessor setFilepath(String filepath) {
		this.filepath = filepath;
		return this;
	}

}
