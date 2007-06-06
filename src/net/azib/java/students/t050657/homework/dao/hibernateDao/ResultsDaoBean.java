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
	
	private static List<String> formatsInDB = Arrays.asList(
			   new String[] {"sec", "m", "m", "m", "sec",
						  	 "sec", "m", "m", "m", "sec"});
	
	private HibernateTemplate hibernateTemplate;
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	public Competition getCompetitionResults(Competition competition) {
		Integer id = competition.getId();
		List<Result> results = (List<Result>) hibernateTemplate.findByNamedQueryAndNamedParam("Result.getByCompetitionId", "id", id);

		competition.addResults(results);
		competition = reduceResultsToFormat(competition);
		
		return competition;
	}
	
	private Competition reduceResultsToFormat(Competition competition) {
		Competition reducedCompetition = new Competition(competition);
		List<Result> results = new ArrayList<Result>();
		for(Result result : competition.getResults()) {
			result = reduceResultToFormat(result);
			try {
				result.calculateFinalScore();
			}
			catch (InsufficientResultsException e) {
				System.out.println("IRE exception!");
				e.printStackTrace();
			}
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

}
