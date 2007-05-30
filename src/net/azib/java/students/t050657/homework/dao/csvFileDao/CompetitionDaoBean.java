package net.azib.java.students.t050657.homework.dao.csvFileDao;

import net.azib.java.students.t050657.homework.dao.CompetitionDao;
import net.azib.java.students.t050657.homework.model.Athlet;
import net.azib.java.students.t050657.homework.model.Competition;
import net.azib.java.students.t050657.homework.model.DecathlonCoeficient;
import net.azib.java.students.t050657.homework.model.InsufficientResultsException;
import net.azib.java.students.t050657.homework.model.Result;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * CompetitionDaoBean
 *
 * @author Boriss
 */
public class CompetitionDaoBean implements CompetitionDao{
	
	private static List<String> formatsInFile = Arrays.asList(
						new String[] {"sec", "m", "m", "m", "min:sec",
		  		  		              "sec", "m", "m", "m", "min:sec"});
	
	private String filepath = null;

	public Competition getCompetition(String countryCode, Date date, String description) {
		if(filepath == null) {
			return null;
		}else {
			Competition competition = new Competition();
			competition.setCountryCode(countryCode);
			competition.setEventDate(date);
			competition.setDescription(description);
			
			BufferedReader reader = null;
			try {
				reader = new BufferedReader(new InputStreamReader(
											new FileInputStream(filepath), "UTF8"));
			}
			catch (FileNotFoundException e) {
				System.out.println("File not found!");
			}
			catch (UnsupportedEncodingException e) {
				System.out.println("Encoding UTF8 not supported!");
			}

			try {
				while (reader.ready()) {
					String line = reader.readLine();
					line.trim();
					
					Athlet athlet = parseAthlet(line);
					athlet.setResult(parseResult(line));	
					
					competition.addAthlet(athlet);
				}
			}
			catch (IOException e) {
				System.out.println("IOException ???");
			}
			
			return competition;
		}
		
	}
	
	private static Athlet parseAthlet(String line) {
		Athlet athlet = new Athlet();
		
		String[] parts = line.split(",");

		DateFormat df = new SimpleDateFormat("dd.mm.yyyy");

		athlet.setName(parts[0].substring(parts[0].indexOf("\"")+1, parts[0].length()-1));
		try {
			athlet.setDateOfBirth(new Date(df.parse(parts[1]).getTime()));
		}
		catch (ParseException e) {
			System.out.println("Date format in file is wrong");
		}		
		athlet.setCountryCode(parts[2]);
		
		return athlet;
	}
	
	private static Result parseResult(String line){
		Result result = new Result();
		
		List<Double> results = new ArrayList<Double>();
		List<String> resList = Arrays.asList(line.split(","));

		int i = 0;
		for(DecathlonCoeficient decCoef : DecathlonCoeficient.values()) {
			Double res = decCoef.reduceToFormat(resList.get(i+3), formatsInFile.get(i));
			results.add(res);
			i++;
		}
		
		try {
			result.setResults(results);
		}catch(InsufficientResultsException e) {
			
		}

		return result;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
}
