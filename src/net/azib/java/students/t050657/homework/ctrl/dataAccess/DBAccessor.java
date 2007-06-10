package net.azib.java.students.t050657.homework.ctrl.dataAccess;

import net.azib.java.students.t050657.homework.dao.CompetitionDao;
import net.azib.java.students.t050657.homework.dao.ResultsDao;
import net.azib.java.students.t050657.homework.dao.hibernateDao.ResultsDaoBean;
import net.azib.java.students.t050657.homework.model.Competition;

import java.util.List;

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
	 */
	public DBAccessor() {
		try {
			BeanFactory beanFactory = new XmlBeanFactory(
					new ClassPathResource("hbeans.xml",
							DBAccessor.class));
			comDao = (CompetitionDao) beanFactory.getBean(CompetitionDao.class.getName());
			resDao = (ResultsDao) beanFactory.getBean(ResultsDaoBean.class.getName());
		}catch (Exception e) {
			System.out.println("========= Database access for user denied! =========");
		}
		
	}
	
	/**
	 * Method fills competition with results from DB
	 * @param competition to be filled
	 * @return competition with results
	 */
	public Competition getResultsForCompetition(Competition competition) {
		Competition comp = resDao.getCompetitionResults(competition);
		return comp;
	}

	/**
	 * Method gets competitions from DB
	 */
	public List<Competition> getCompetition() {
		List<Competition> comp = comDao.getCompetition();
		return comp;
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
