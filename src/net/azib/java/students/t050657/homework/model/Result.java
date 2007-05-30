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

public class Result{
	
	private Integer id;
	private Map<DecathlonCoeficient, Double> results = new HashMap<DecathlonCoeficient, Double>();
	
	/**
	 * Class instance Constructor
	 */
	public Result() {
		
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
	 * Convert result to points
	 * @param decCoef represents event for computation
	 * @return points getted for the event
	 */
	public Double getConvertedResult(DecathlonCoeficient decCoef) {
		double res = ((int)(decCoef.evalPoints(results.get(decCoef))*100))/100;
		return res;
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
	public double getFinalScore() throws InsufficientResultsException {
		if(results.size() != DecathlonCoeficient.EVENT_QUANT) {
			throw new InsufficientResultsException("Not all results were added, " +
					                               "can't calculate final score");
		}
		double result = 0;
		for(DecathlonCoeficient decCoef : DecathlonCoeficient.values()) {
			result += decCoef.evalPoints(this.getResult(decCoef));
		}

		return result;
	}

	/**
	 * Indicates whether some other result is "equal to" this one.
	 * All results contains in compares to the same decathlon event result in other result.
	 * If each result is equal to another - objects are equal.
	 * If two results were not setted to one decathlon event - objects are equal.
	 * @return true, if results are equal, false otherwise 
	 */
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Result)) {
			return false;
		}
		
		Result res = (Result) obj;
		
		for(DecathlonCoeficient decCoef : DecathlonCoeficient.values()) {
			Double thisRes = null;
			Double resRes = null;
			
			try {
				thisRes = this.getResult(decCoef);
			}
			catch (InsufficientResultsException e) {
				try {
					resRes = res.getResult(decCoef);
				}
				catch (InsufficientResultsException ex) {
					// Both results are not setted. They are equals
				}
				finally {
					if(thisRes != resRes)
						return false;
				}
			}				
				
			try {
				resRes = res.getResult(decCoef);
			}
			catch (InsufficientResultsException e) {
				//ignore
			}			
			
			if (thisRes != resRes) {
				return false;
			}
		}
		
		return true;
	}

	
	// *********************** SMART SETTERS *************************//
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
	
	
	//	 *********************** SMART GETTERS *************************//
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
