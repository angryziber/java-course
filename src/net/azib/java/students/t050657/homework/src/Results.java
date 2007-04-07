package net.azib.java.students.t050657.homework.src;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Results{
	
	private Map<DecathlonCoeficient, Double> results = new HashMap<DecathlonCoeficient, Double>();
	
	public Results() {
		
	}
	
	public void setResults(List<Double> resultList) throws InsufficientResultsException {
		if(resultList.size() != DecathlonCoeficient.EVENT_QUANT) {
			throw new InsufficientResultsException("Transferable list contains not enough results");
		}
		for(DecathlonCoeficient decCoef : DecathlonCoeficient.values()) {
			setResult(decCoef, resultList.get(decCoef.ordinal()));
		}
	}
	
	public void setResult(DecathlonCoeficient decCoef, double result) {
		double points = decCoef.evalPoints(result);
		results.put(decCoef, points);
	}
	
	public double getResult(DecathlonCoeficient decCoef) throws InsufficientResultsException {
		if(!results.containsKey(decCoef)) {
			throw new InsufficientResultsException("Result for requested event wasn't added");
		}
		return results.get(decCoef);
	}
	
	public double getFinalScore() throws InsufficientResultsException {
		if(results.size() != DecathlonCoeficient.EVENT_QUANT) {
			throw new InsufficientResultsException("Not all results were added, " +
					"can't calculate final score");
		}
		double result = 0;
		for(DecathlonCoeficient decCoef : DecathlonCoeficient.values()) {
			result += this.getResult(decCoef);
		}
		return result;
	}

	public Map<DecathlonCoeficient, Double> getResults() {
		return results;
	}
}
