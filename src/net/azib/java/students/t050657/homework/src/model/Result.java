package net.azib.java.students.t050657.homework.src.model;

import java.util.List;
import java.util.Map;

public class Result{
	
	private Map<DecathlonCoeficient, Double> results;
	
	public Result() {
		
	}
	
	public void setResults(List<Double> resultList) throws InsufficientResultsException {
		if(resultList.size() != DecathlonCoeficient.EVENT_QUANT) {
			throw new InsufficientResultsException("Transferable list contains not enough results");
		}
		for(DecathlonCoeficient decCoef : DecathlonCoeficient.values()) {
			setResult(decCoef, resultList.get(decCoef.ordinal()));
		}
	}
	
	private void setResult(DecathlonCoeficient decCoef, double result) {
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

}
