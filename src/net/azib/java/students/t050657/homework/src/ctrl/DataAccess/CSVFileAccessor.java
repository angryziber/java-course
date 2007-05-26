package net.azib.java.students.t050657.homework.src.ctrl.DataAccess;

import net.azib.java.students.t050657.homework.src.Dao.CompetitionDao;
import net.azib.java.students.t050657.homework.src.Dao.CSVFileDao.CompetitionDaoBean;
import net.azib.java.students.t050657.homework.src.model.Competition;

import java.sql.Date;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * CSVFileAccessor
 *
 * @author Boriss
 */
public class CSVFileAccessor implements DataAccessor{
	
	private String filepath = null;

	public Competition getCompetition(String countryCode, Date date, String description) {
		BeanFactory beanFactory = new XmlBeanFactory(
				new ClassPathResource("../../../mapping/fbeans.xml",
				DBAccessor.class));
		
		CompetitionDaoBean competitionDao = (CompetitionDaoBean) beanFactory.getBean(CompetitionDao.class.getName());
		competitionDao.setFilepath(this.filepath);
		
		Competition competition = competitionDao.getCompetition(countryCode, date, description);
		System.out.println(competition);
		
		competition.calculateAndSetPlaces();
		
		return competition;
	}

	public CSVFileAccessor setFilepath(String filepath) {
		this.filepath = filepath;
		return this;
	}

}
