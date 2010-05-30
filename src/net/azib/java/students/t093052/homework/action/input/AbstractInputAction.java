package net.azib.java.students.t093052.homework.action.input;

import net.azib.java.students.t093052.homework.Athlete;
import net.azib.java.students.t093052.homework.CompetitionType;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Comparator;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

/**
 * This class holds the common methods of all input actions
 * */
public abstract class AbstractInputAction implements InputAction {
	
	abstract DateFormat getDateFormat();
	
	Athlete createAthlete(String... data) {
		Athlete athlete = new Athlete();
		
		athlete.setName(data[0]);
		athlete.setDateOfBirth(convertToDate(data[1]));
		athlete.setCountry(data[2].toUpperCase());
		
		for (int i = 3, j = 0; i < data.length && 
				j < CompetitionType.values().length; i++, j++) {
			CompetitionType type = CompetitionType.values()[j];
			athlete.addResult(type, data[i]);
		}
		return athlete;
	}
	
	private Date convertToDate(String dateString) {
		try {
			return dateString != null ? getDateFormat().parse(dateString) : null;
		} catch (ParseException e) {
			throw new InputDataException("Date in invalid format", e);
		}
	}
	
	Set<Athlete> createAthleteSet() {
		return new TreeSet<Athlete>(new Comparator<Athlete>() {
			@Override
			public int compare(Athlete athlete, Athlete anotherAthlete) {
				int result = anotherAthlete.getPoints().compareTo(
						athlete.getPoints());
				return result != 0 ? result : athlete.getName().compareTo(
						anotherAthlete.getName());
			}
		});
	}
}
