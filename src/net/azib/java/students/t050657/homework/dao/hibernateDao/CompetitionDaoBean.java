package net.azib.java.students.t050657.homework.dao.hibernateDao;

import net.azib.java.students.t050657.homework.dao.CompetitionDao;
import net.azib.java.students.t050657.homework.model.Athlet;
import net.azib.java.students.t050657.homework.model.Competition;
import net.azib.java.students.t050657.homework.model.DecathlonCoeficient;
import net.azib.java.students.t050657.homework.model.InsufficientResultsException;
import net.azib.java.students.t050657.homework.model.Result;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.orm.hibernate3.HibernateTemplate;

public class CompetitionDaoBean implements CompetitionDao{
	
	private HibernateTemplate hibernateTemplate;
	
	private static List<String> formatsInDB = Arrays.asList(
			   new String[] {"sec", "m", "m", "m", "sec",
						  	 "sec", "m", "m", "m", "sec"});
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public Competition getCompetition(String countryCode, java.sql.Date date, String description) {
		Competition competition = (Competition) hibernateTemplate.findByNamedQueryAndNamedParam("Competition.getByDescription", 
				new String[] {"countryCode", "date", "description"},
				new Object[] {countryCode, date, description}).get(0);
		competition = reduceResultsToFormat(competition);
		return competition;
	}
	
	public Competition reduceResultsToFormat(Competition competition) {
		Competition reducedCompetition = new Competition(competition);
		Set<Athlet> aset = new TreeSet<Athlet>();
		for(Athlet a : competition.getAthlets()) {
			System.out.println(a.toString());
			a = reduceResultsToFormat(a);
			a.calculateAndSetFinalScore();
			aset.add(a);
		}
		reducedCompetition.setAthlets(aset);
		return reducedCompetition;
	}
	
	public Athlet reduceResultsToFormat(Athlet athlet) {
		Result result = athlet.getResult();
		Result reducedResult = new Result();
		int i = 0;
		for(DecathlonCoeficient decCoef : DecathlonCoeficient.values()) {		
			try {
				reducedResult.setResult(decCoef, decCoef.reduceToFormat(
						result.getResult(decCoef) + "", formatsInDB.get(i) + ""));
			}
			catch (InsufficientResultsException e) {
				System.out.println("Athlet " + athlet + " has no result in " + decCoef.getTitle());
			}
			i++;
		}
	
		athlet.setResult(reducedResult);
		return athlet;
	}
	
}
