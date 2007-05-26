package net.azib.java.students.t050657.homework.src.Dao;

import java.sql.Date;

import net.azib.java.students.t050657.homework.src.model.Competition;

public interface CompetitionDao {

	public Competition getCompetition(String countryCode, Date date, String description);
}
