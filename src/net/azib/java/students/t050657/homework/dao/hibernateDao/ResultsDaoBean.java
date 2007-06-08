package net.azib.java.students.t050657.homework.dao.hibernateDao;

import net.azib.java.students.t050657.homework.dao.ResultsDao;
import net.azib.java.students.t050657.homework.model.Competition;
import net.azib.java.students.t050657.homework.model.DecathlonCoeficient;
import net.azib.java.students.t050657.homework.model.InsufficientResultsException;
import net.azib.java.students.t050657.homework.model.Result;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 * ResultsDaoBean
 *
 * @author Boriss
 */
public class ResultsDaoBean implements ResultsDao{
	
	/**
	 * Data format in DB. By default it is so. Can be setted using setter.
	 */
	private static List<String> formatsInDB = Arrays.asList(
			   new String[] {"sec", "m", "m", "m", "sec",
						  	 "sec", "m", "m", "m", "sec"});
	
	private HibernateTemplate hibernateTemplate;
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	/**
	 * Method fills competitions by results from database
	 * using named query with parameter (competition id)
	 */
	public Competition getCompetitionResults(Competition competition) {
		Integer id = competition.getId();
		List<Result> results = (List<Result>) hibernateTemplate.findByNamedQueryAndNamedParam("Result.getByCompetitionId", "id", id);
		
		if(competition.getResults().isEmpty() == true) { 
			competition.addResults(results);
			competition = reduceResultsToFormat(competition);
			for(Result result : competition.getResults()) {
				try {
					result.calculateFinalScore();
				}
				catch (InsufficientResultsException e) {
					System.out.println("IRE exception!");
					e.printStackTrace();
				}
			}
		}

		return competition;
	}

	private Competition reduceResultsToFormat(Competition competition) {
		Competition reducedCompetition = new Competition(competition);
		List<Result> results = new ArrayList<Result>();
		for(Result result : competition.getResults()) {
			result = reduceResultToFormat(result);
			results.add(result);
		}
		reducedCompetition.addResults(results);
		return reducedCompetition;
	}
	
	private Result reduceResultToFormat(Result result) {
		Result reducedResult = new Result();
		reducedResult.copyResult(result);
		int i = 0;
		for(DecathlonCoeficient decCoef : DecathlonCoeficient.values()) {		
			try {
				reducedResult.setResult(decCoef, decCoef.reduceToFormat(
						result.getResult(decCoef) + "", formatsInDB.get(i) + ""));
			}
			catch (InsufficientResultsException e) {
				System.out.println("IRE exception!");
				e.printStackTrace();
			}
			i++;
		}
		return reducedResult;
	}

	public static List<String> getFormatsInDB() {
		return formatsInDB;
	}

	public static void setFormatsInDB(List<String> formatsInDB) {
		ResultsDaoBean.formatsInDB = formatsInDB;
	}
	
	

}
