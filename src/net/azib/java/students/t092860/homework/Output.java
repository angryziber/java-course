package net.azib.java.students.t092860.homework;

import java.util.List;

/**
 * Output
 *
 * @author scythe
 */
interface Output{

	public class Data extends Athlete {
		
		Data(){}
		Data(Athlete athlete)
		{
			athleteName = athlete.athleteName;
			athleteBirthdate = athlete.athleteBirthdate;
			athleteCountry = athlete.athleteCountry;
			athleteEvents = athlete.athleteEvents;
		}
		
		public void setPosition(String position){
			athletePosition = position;
		}
		
		public void setScore(int score){
			athleteScore = score;	
		}
		
		public String getPosition(){
			return athletePosition;
		}
		
		public int getScore(){
			return athleteScore;		
		}
		
		private String athletePosition;
		private int athleteScore;
	}
	
	public void set(List<Data> dataSet) throws Exception;
}
