package net.azib.java.students.t050657.homework.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Result class represents the full row of results in decathlon competition
 * Helps to contain, convert and calculate final score. 
 *
 * @author Boriss
 */

public class Result implements Comparable<Result>{
	
	private Integer id;
	private Map<DecathlonCoeficient, Double> results = new HashMap<DecathlonCoeficient, Double>();
	
	private Athlet athlet;
	private double finalScore;
	private String place;
	
	/**
	 * Class instance Constructor
	 */
	public Result() {

	}
	
	public Result(Integer id) {
		this.id = id;
	}
	
	/**
	 * Overrides Object's toString method
	 */
	@Override
	public String toString(){	
		String result = null;
		
		if(this.finalScore == 0) {
			try {
				this.calculateFinalScore();
			}
			catch (InsufficientResultsException e) {
				System.out.println("IRE in toString()");
			}			
		}
		result = this.getPlace() + this.getAthlet() + ", "+ this.getFinalScore() + ", ";
		for(DecathlonCoeficient decCoef : DecathlonCoeficient.values()) {
			result = result.concat((results.get(decCoef) + ", "));
		}
		
		return result;
	}

	/**
	 * Method to set row of results 
	 * @param resultList should contain full row of results
	 * @throws InsufficientResultsException is thrown, 
	 * if resultList contains less or more that ten results 
	 */
	public void setResults(List<Double> resultList) throws InsufficientResultsException {
		if(resultList.size() != DecathlonCoeficient.EVENT_QUANT) {
			throw new InsufficientResultsException("Transferable list contains not enough results");
		}
		if(results.size() > 0) {
			results.clear();
			System.out.println("Cleared!");
		}
		for(DecathlonCoeficient decCoef : DecathlonCoeficient.values()) {
			setResult(decCoef, resultList.get(decCoef.ordinal()));
		}
	}
	
	/**
	 * Result map getter
	 * @return map of row results, contains values that were setted (not converted results)
	 */
	public Map<DecathlonCoeficient, Double> getResults() {
		return results;
	}
	
	/**
	 * Convert results to points
	 * @return list of converted results 
	 */
	public List<Double> getConvertedResults(){
		List<Double> list = new ArrayList<Double>();
		for(DecathlonCoeficient decCoef : DecathlonCoeficient.values()) {
			double points = decCoef.evalPoints(results.get(decCoef));
			list.add(points);
		}
		return list;
	}

	/**
	 * Add result to results. 
	 * @param decCoef represents decathlon event
	 * @param result that was shown in competition. It should be "clean" result, not converted points
	 */
	public void setResult(DecathlonCoeficient decCoef, double result) {
		results.put(decCoef, result);
	}
	
	/**
	 * Result getter
	 * @param decCoef represents decathlon event
	 * @return result that was shown in competition.
	 * @throws InsufficientResultsException is thrown, if result for requested competition were not added
	 */
	public double getResult(DecathlonCoeficient decCoef) throws InsufficientResultsException {
		if(!results.containsKey(decCoef)) {
			throw new InsufficientResultsException("Result for requested event wasn't added");
		}
		return results.get(decCoef);
	}
	
	/**
	 * Allows calculate final score for decathlon competition 
	 * @return final score
	 * @throws InsufficientResultsException is thrown, if not all ten results were inserted
	 */
	public void calculateFinalScore() throws InsufficientResultsException {
		if(results.size() != DecathlonCoeficient.EVENT_QUANT) {
			throw new InsufficientResultsException("Not all results were added, " +
					                               "can't calculate final score");
		}
		double result = 0;
		for(DecathlonCoeficient decCoef : DecathlonCoeficient.values()) {
			result += decCoef.evalPoints(this.getResult(decCoef));
		}
		this.finalScore = result;
	}

	/**
	 * Indicates whether some other result is "equal to" this one.
	 * Method was written to use result object with Set, so it compares results id.
	 */
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Result)) {
			return false;
		}
		Result result = (Result) obj;
		if(this.id == result.id) {
			return true;
		}else return false;
	}
	
	/**
	 * Method compare two results (finalScore).
	 * Method uses <i>calculateAndSetFinalScore</i> method.<br><br>
	 * Return value depends on:
	 * <ul>
	 * 	<li>if results id are equal - return 0.</li>
	 *  <li>if first result has <i>less</i> final score return 1</li>
	 *  <li>if first rewsult has <i>upper</i> final score return -1 </li>
	 * </ul>
	 * It was designed for using with Collection.sort() method. 
	 * So better results are higher after sort and different sortings goes right.
	 */
	public int compareTo(Result result) {
		final int BETTER_RESULT = -1;
		final int EQUAL_RESULT = 0;
		final int LESS_RESULT = 1;
		
		if(this.id == result.id) {
			return EQUAL_RESULT;
		}
				
		if(this.finalScore  == 0) {
			try {
				this.calculateFinalScore();
			}
			catch (InsufficientResultsException e) {
				e.printStackTrace();
			}
		}
				
		if(result.finalScore == 0) {
			try {
				result.calculateFinalScore();
			}
			catch (InsufficientResultsException e) {
				e.printStackTrace();
			}
		}
	
		if (this.getFinalScore() > result.getFinalScore()) {
			return BETTER_RESULT;
		}
		else {
			return LESS_RESULT;
		}
	}
	
	/**
	 * Copy one result to another
	 */
	public void copyResult(Result resultToCopy) {
		this.id = resultToCopy.id;
		this.results = resultToCopy.results;
		this.athlet = resultToCopy.athlet;
		this.finalScore = resultToCopy.finalScore;
		this.place = resultToCopy.place;
	}

	public Athlet getAthlet() {
		return athlet;
	}

	public String getPlace() {
		return place;
	}

	public void setAthlet(Athlet athlet) {
		this.athlet = athlet;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public double getFinalScore() {
		return finalScore;
	}

	// *********************** SMART SETTERS FOR HIBERNATE *************************//
	/**
	 * Setters for concrete competition
	 * @param value to be inserted
	 */
	public void setRace100(Double value) {
		results.put(DecathlonCoeficient.M_100, value);
	}
	
	public void setLongJump(Double value) {
		results.put(DecathlonCoeficient.LONG_JUMP, value);
	}
	
	public void setShotPut(Double value) {
		results.put(DecathlonCoeficient.SHOT_PUT, value);
	}
	
	public void setHighJump(Double value) {
		results.put(DecathlonCoeficient.HIGH_JUMP, value);
	}
	
	public void setRace400(Double value) {
		results.put(DecathlonCoeficient.M_400, value);
	}
	
	public void setHurdles(Double value) {
		results.put(DecathlonCoeficient.M_110_HURDLES, value);
	}
	
	public void setDiscusThrow(Double value) {
		results.put(DecathlonCoeficient.DISCUS_THROW, value);
	}
	
	public void setPoleVault(Double value) {
		results.put(DecathlonCoeficient.POLE_VAULT, value);
	}
	
	public void setJavelinThrow(Double value) {
		results.put(DecathlonCoeficient.JAVELIN_THROW, value);
	}
	
	public void setRace1500(Double value) {
		results.put(DecathlonCoeficient.M_1500, value);
	}
	
	//	 *********************** SMART GETTERS FOR HIBERNATE *************************//
	public Double getRace100() {
		return this.results.get(DecathlonCoeficient.M_100);
	}
	public Double getLongJump() {
		return this.results.get(DecathlonCoeficient.LONG_JUMP);
	}
	public Double getShotPut() {
		return this.results.get(DecathlonCoeficient.SHOT_PUT);
	}
	public Double getHighJump() {
		return this.results.get(DecathlonCoeficient.HIGH_JUMP);
	}
	public Double getRace400() {
		return this.results.get(DecathlonCoeficient.M_400);
	}
	public Double getHurdles() {
		return this.results.get(DecathlonCoeficient.M_110_HURDLES);
	}
	public Double getDiscusThrow() {
		return this.results.get(DecathlonCoeficient.DISCUS_THROW);
	}
	public Double getPoleVault() {
		return this.results.get(DecathlonCoeficient.POLE_VAULT);
	}
	public Double getJavelinThrow() {
		return this.results.get(DecathlonCoeficient.JAVELIN_THROW);
	}
	public Double getRace1500() {
		return this.results.get(DecathlonCoeficient.M_1500);
	}
	
}
