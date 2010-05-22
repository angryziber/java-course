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
			this.name = athlete.name;
			this.birthdate = athlete.birthdate;
			this.country = athlete.country;
			this.events = athlete.events;
		}
		
		/**
		 * Sets the position of this athlete. 
		 *
		 * @param position athletes position
		 */
		public void setPosition(String position){
			this.position = position;
		}
		
		/**
		 * Sets the score of this athlete. 
		 *
		 * @param score athletes score
		 */
		public void setScore(int score){
			this.score = score;	
		}
		
		/**
		 * Gets the position of this athlete. 
		 *
		 * @return athletes position
		 */
		public String getPosition(){
			return this.position;
		}
		
		/**
		 * Gets the score of this athlete. 
		 *
		 * @return athletes score
		 */
		public int getScore(){
			return this.score;		
		}
		
		private String position;
		private int score;
	}
	
	
	/**
	 * Sets output data.
	 * 
	 * @param dataSet list of output data
	 * @throws Exception if data cannot be written.
	 */
	public void set(List<Data> dataSet) throws Exception;
}
