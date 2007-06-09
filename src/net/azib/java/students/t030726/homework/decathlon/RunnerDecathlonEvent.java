package net.azib.java.students.t030726.homework.decathlon;

import net.azib.java.lessons.logging.JavaUtilLogging;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This is a class, which implements all functionality, which is specific for running events. The time conversions (minutes:seconds to seconds)
 * and the formula are specific here
 * @author Dennis Nikiforov
 *
 */
public class RunnerDecathlonEvent extends GenericDecathlonEvent {
	private int points = 0; //The final point score
	private boolean isCalulationComplete = false; //Holds a flag whether the points have already been calculated
	private double timeResult; //This is the time in seconds (some passed as min:sec, so needs to be parsed)
	private double handTime = 0.0; //storing the hand time. This is applicable to some runner events (see official formula)
	private Logger log = null;
	/**
	 * Attemps to parse the incomming result (time achieved on the event) from the child classes. 
	 * The time can come in min:sec or just sec format. This function deals with this and convers everything into seconds
	 * @param String result
	 * @return double
	 * @throws Exception
	 */
	private double parseIncomingResult(String result) throws Exception {
		double resultInSeconds = 0.0;
		try {
			//If Number is passed in seconds (as for some events), this will not fail
			resultInSeconds = Double.parseDouble(result);
			this.log.log(Level.FINE, "We got seconds as a proper value: " + result);
		} catch(Exception ex) {
			try {
				String[] splitTime = result.split(":");
				//We expect the time to be min:sec, if it is not, then we break (throw an exception)
				if(splitTime.length < 2) {
					throw new InvalidDataFormatException();
				}
				int minutes = Integer.parseInt(splitTime[0]);
				double seconds = Double.parseDouble(splitTime[1]);
				resultInSeconds = minutes * 60 + seconds;
				
			} catch (Exception innerEx) {
				this.log.log(Level.SEVERE, "We have a bad exception for result " + result, innerEx);
				throw innerEx;
			}
		}
		//The result cannot be 0 or negative
		if(resultInSeconds == 0 || resultInSeconds < 0) {
			this.log.log(Level.SEVERE, "Result is negative!");
			throw new InvalidDataFormatException();
		}
		return resultInSeconds;
		
	}
	
	/**
	 * This function computes the points according to the formula : Points = A*(B-P)C for Running Events 
	 * A, B, C are taken from the super class. The points are always an integer (according to websites), so its just casted to
	 * an int
	 * @return int
	 */
	private int computePoints() {
		int final_result = (int)(super.getAParameter() * 
					Math.pow((super.getBParameter() - (this.timeResult + this.handTime)), super.getCParameter()));
		return final_result;
	}
	
	/**
	 * This is the wrapper function for computePoints. It is implemented to allow multiple queries to this function without having to
	 * recalculate the result
	 * @return int
	 */
	public int getPoints() {
		if(!this.isCalulationComplete) {
			this.points = this.computePoints();
			this.isCalulationComplete = true;
		}
		return this.points;
		
	}
	
	/**
	 * Sets the Hand Time, which is additional time added to thew achieved result in some events. If not set here, 
	 * it defaults to zero. If it is zero, then this should not be called! 
	 * add 0.24 for hand times for the 100 and 110 Hurdles; 
	 * add 0.14 for hand times in the 400m;
	 * @param double handTime
	 * @throws InvalidDataFormatException
	 */
	public void setHandTime(double handTime) throws InvalidDataFormatException {
		//Hand time cannot be less than zero. If it is zero, then it shouldn't be set here, as zero is default
		if(handTime < 0  || handTime == 0) {
			this.log.log(Level.SEVERE, "We got a negative or zero hand time");
			throw new InvalidDataFormatException();
		}
		this.handTime = handTime;
	}
	
	/**
	 * Construtor for the Runner Event. Takes all necessary parameters for the instantiation to make sense. No parameter can be omitted,
	 * otherwise results cannot be calculated.
	 * @param String achievedResult
	 * @param double aParameter
	 * @param double bParameter
	 * @param double cParameter
	 * @throws Exception
	 */
	public RunnerDecathlonEvent(String achievedResult, double aParameter, double bParameter, double cParameter) throws Exception {
		//We need to get seconds out of the incomming data
		this.log = Logger.getLogger(JavaUtilLogging.class.getName());
		super.setRawResult(achievedResult);
		this.timeResult = this.parseIncomingResult(achievedResult);
		super.setAParameter(aParameter);
		super.setBParameter(bParameter);
		super.setCParameter(cParameter);
	}
	
}
