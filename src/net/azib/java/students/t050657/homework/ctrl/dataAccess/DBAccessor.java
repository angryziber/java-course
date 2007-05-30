package net.azib.java.students.t050657.homework.ctrl.dataAccess;

import net.azib.java.students.t050657.homework.dao.CompetitionDao;
import net.azib.java.students.t050657.homework.model.Competition;

import java.sql.Date;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * DBAccessor
 *
 * @author Boriss
 */
public class DBAccessor implements DataAccessor{
	
	public Competition getCompetition(String countryCode, Date date, String description) {
		BeanFactory beanFactory = new XmlBeanFactory(
				new ClassPathResource("../../mapping/hbeans.xml",
				DBAccessor.class));
		
		CompetitionDao competitionDao = (CompetitionDao) beanFactory.getBean(CompetitionDao.class.getName());

		Competition competition = competitionDao.getCompetition(countryCode, date, description);
		
		competition.calculateAndSetPlaces();
		
		return competition;
	}
}
