package net.azib.java.students.t092860.homework;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * AthleteData
 */
public class TestData {

	public static List<Output.Data> GetOutputData(){
		List<Output.Data> dataList = new ArrayList<Output.Data>();
		Output.Data data = new Output.Data(GetAthlete());
		data.setPosition("1");
		data.setScore(6000);
		dataList.add(data);		
		return dataList;
	}
	
	public static Athlete GetAthlete(){
		Athlete athlete = new Athlete();
		
		String trackPerf = "1:30";
		String fieldPerf = "20.45";

		try {
			athlete.setName("Name");
			athlete.setDate(new SimpleDateFormat("yyyy/MM/dd").parse("2000/10/20"));
			athlete.setCountry("EE");
			athlete.addEvent(Events.RACE_100M, Converter.stringToTime(trackPerf));
			athlete.addEvent(Events.LONG_JUMP, Double.valueOf(fieldPerf));
			athlete.addEvent(Events.SHOT_PUT, Double.valueOf(fieldPerf));
			athlete.addEvent(Events.HIGH_JUMP, Double.valueOf(fieldPerf));
			athlete.addEvent(Events.RACE_400M, Converter.stringToTime(trackPerf));
			athlete.addEvent(Events.HURDLES_110M, Converter.stringToTime(trackPerf));
			athlete.addEvent(Events.DISCUS_THROW, Double.valueOf(fieldPerf));
			athlete.addEvent(Events.POLE_VAULT, Double.valueOf(fieldPerf));
			athlete.addEvent(Events.JAVELIN_THROW, Double.valueOf(fieldPerf));
			athlete.addEvent(Events.RACE_1500M, Converter.stringToTime(trackPerf));
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return athlete;
	}
}
