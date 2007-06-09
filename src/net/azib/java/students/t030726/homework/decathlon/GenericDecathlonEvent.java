package net.azib.java.students.t030726.homework.decathlon;
import net.azib.java.lessons.logging.JavaUtilLogging;

import java.lang.NullPointerException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This is the source class for all decathlon events. It has the basic functionality, which is common for all events (like A, B, C parameters,
 * which are used in the formulas
 * @author Dennis Nikiforov
 * 
 */
public class GenericDecathlonEvent {
	private double aParameter = 0.0;
	private double bParameter = 0.0;
	private double cParameter = 0.0;
	private String rawResult = "";
	private Logger log = null;
	
	/**
	 * A getter for the raw result. 
	 * @return
	 */
	public String getRawResult() {
		return this.rawResult;
	}
	
	/**
	 * A setter for the raw result
	 * @param result
	 */
	public void setRawResult(String result) {
		this.rawResult = result;
	}
	
	/**
	 * Constructor is only needed to instantiate the logger
	 *
	 */
	public GenericDecathlonEvent() {
		this.log = Logger.getLogger(JavaUtilLogging.class.getName());
	}
	
	
	/**
	 * A parameter is being set here (parameter from the points calculation formula)
	 * @param parameter
	 * @throws InvalidDataFormatException
	 */
	public void setAParameter(double parameter) throws InvalidDataFormatException {
		if(parameter < 0 || parameter == 0) {
			this.log.log(Level.SEVERE, "A Parameter had an invalid value (" + String.valueOf(parameter) + ")");
			throw new InvalidDataFormatException();
		}
		this.aParameter = parameter;
	}
	
	/**
	 * B parameter is being set here (parameter from the points calculation formula)
	 * @param parameter
	 * @throws InvalidDataFormatException
	 */
	public void setBParameter(double parameter) throws InvalidDataFormatException {
		if(parameter < 0 || parameter == 0) {
			this.log.log(Level.SEVERE, "B Parameter had an invalid value (" + String.valueOf(parameter) + ")");
			throw new InvalidDataFormatException();
			
		}
		this.bParameter = parameter;
	}

	/**
	 * C parameter is being set here (parameter from the points calculation formula)
	 * @param parameter
	 * @throws InvalidDataFormatException
	 */
	public void setCParameter(double parameter) throws InvalidDataFormatException {
		if(parameter < 0 || parameter == 0) {
			this.log.log(Level.SEVERE, "C Parameter had an invalid value (" + String.valueOf(parameter) + ")");
			throw new InvalidDataFormatException();
		}
		this.cParameter = parameter;
	}
	
	/**
	 * A parameter is being read here(parameter from the points calculation formula)
	 * @return double
	 * @throws InvalidDataFormatException
	 */
	public double getAParameter() {
		if(this.aParameter == 0) {
			this.log.log(Level.SEVERE, "A Parameter was null when referenced");
			throw new NullPointerException();
		}
		return this.aParameter;
	}
	
	/**
	 * B parameter is being read here(parameter from the points calculation formula)
	 * @return double
	 * @throws InvalidDataFormatException
	 */
	public double getBParameter() {
		if(this.bParameter == 0) {
			this.log.log(Level.SEVERE, "B Parameter was null when referenced");
			throw new NullPointerException();
		}
		return this.bParameter;
	}
	
	/**
	 * C parameter is being read here(parameter from the points calculation formula)
	 * @return double
	 * @throws InvalidDataFormatException
	 */
	public double getCParameter() {
		if(this.cParameter == 0) {
			this.log.log(Level.SEVERE, "C Parameter was null when referenced");
			throw new NullPointerException();
		}
		return this.cParameter;
	}
	
	
}
