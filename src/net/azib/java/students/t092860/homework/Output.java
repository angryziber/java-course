package net.azib.java.students.t092860.homework;

import java.util.List;

/**
 * Interface class to be implemented in order to write data.
 */
public interface Output{
	
	/**
	 * Data class used to hold athletes info.
	 */
	public class Data extends Athlete {
		
		/**
		 * Default constructor
		 */
		Data(){}
		
		/**
		 * Constructor
		 @param athlete data to be reused
		 */
		Data(Athlete athlete) {
			athleteName = athlete.athleteName;
			athleteBirthdate = athlete.athleteBirthdate;
			athleteCountry = athlete.athleteCountry;
			athleteEvents = athlete.athleteEvents;
		}
		
		/**
		 * Sets the position of this athlete. 
		 *
		 * @param position athletes position
		 */
		public void setPosition(String position){
			athletePosition = position;
		}
		
		/**
		 * Sets the score of this athlete. 
		 *
		 * @param score athletes score
		 */
		public void setScore(int score){
			athleteScore = score;	
		}
		
		/**
		 * Gets the position of this athlete. 
		 *
		 * @return athletes position
		 */
		public String getPosition(){
			return athletePosition;
		}
		
		/**
		 * Gets the score of this athlete. 
		 *
		 * @return athletes score
		 */
		public int getScore(){
			return athleteScore;		
		}
		
		private String athletePosition;
		private int athleteScore;
	}
	
	
	/**
	 * Sets output data.
	 * 
	 * @param dataSet list of output data
	 * @throws Exception if data cannot be written.
	 */
	public void set(List<Data> dataSet) throws Exception;
}
