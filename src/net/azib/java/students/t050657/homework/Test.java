package net.azib.java.students.t050657.homework;

import net.azib.java.students.t050657.homework.src.ctrl.DataAccess.DBAccessor;
import net.azib.java.students.t050657.homework.src.ctrl.DataAccess.DataAccessor;
import net.azib.java.students.t050657.homework.src.ctrl.DataOutput.CSVFileWriter;
import net.azib.java.students.t050657.homework.src.ctrl.DataOutput.DataWriter;
import net.azib.java.students.t050657.homework.src.ctrl.DataOutput.XMLFileWriter;
import net.azib.java.students.t050657.homework.src.model.Competition;

import java.io.IOException;
import java.sql.Date;

/**
 * Test
 *
 * @author Boriss
 */
public class Test {
	
	public static void main(String[] args) {
		
		DataAccessor dataAccess = new DBAccessor();
		
		Date date = Date.valueOf("2006-03-18");
		
		Competition competition = dataAccess.getCompetition("PL", date, 
				"DECATHLON4BEER in Krakow");
		
		DataWriter csvWriter = new CSVFileWriter();
		DataWriter xmlWriter = new XMLFileWriter();
		
		try {
			csvWriter.writeCompetition(competition);
			xmlWriter.writeCompetition(competition);
		}catch(IOException e) {
			//
		}

	}

}
