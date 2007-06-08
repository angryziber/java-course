package net.azib.java.students.t050657.homework.ctrl.dataAccess;

import net.azib.java.students.t050657.homework.dao.CompetitionDao;
import net.azib.java.students.t050657.homework.dao.csvFileDao.CompetitionDaoBean;
import net.azib.java.students.t050657.homework.model.Competition;
import net.azib.java.students.t050657.homework.model.InsufficientResultsException;

import java.util.List;

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

	/**
	 * Gets competition from source csv file
	 * @return list of competitions (in this implementation one or null)
	 */
	public List<Competition> getCompetition() {
		BeanFactory beanFactory = new XmlBeanFactory(
				new ClassPathResource("../../mapping/fbeans.xml",
				CSVFileAccessor.class));
		
		CompetitionDaoBean competitionDao = (CompetitionDaoBean) beanFactory.getBean(CompetitionDao.class.getName());
		competitionDao.setFilepath(this.filepath);
		
		List<Competition> competitionList = competitionDao.getCompetition();
		
		if(competitionList != null) {
			for(Competition competition : competitionList) {
				try {
					competition.calculateAndSetPlaces();
				}
				catch (InsufficientResultsException e) {
					System.out.println("IRE Exception!");
				}
			}
		}
	
		return competitionList;
	}

	/**
	 * Setter for filepath, use it, before wrap this to DataAcessor. 
	 * @param filepath to file, should be parsed
	 * @return CSVFileAcessor with setted path
	 */
	public CSVFileAccessor setFilepath(String filepath) {
		this.filepath = filepath;
		return this;
	}

}
