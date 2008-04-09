package net.azib.java.students.t030633.homework.Model;

import java.util.Date;
import java.util.EnumMap;

/**
 * Interface for building athletes.
 *
 * @author t030633
 */
public interface AthleteBuilder {

	public abstract AthleteBuilder name(String name);

	public abstract AthleteBuilder date(Date date);

	public abstract AthleteBuilder country(String country);

	public abstract AthleteBuilder results(EnumMap<Event, Double> results);

	public abstract Athlete build();

}