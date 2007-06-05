package net.azib.java.students.t030726.homework.decathlon;

/**
 * This class implements all functions specific to Field Decathlon Events. The formula is cpecific here
 * @author Dennis Nikiforov
 *
 */
public class FieldDecathlonEvent extends GenericDecathlonEvent {
	protected int points = 0;
	protected boolean isCalulationComplete = false;
	protected double achievedResult = 0;
	
	
	/**
	 * This function computes the points according to the formula : Points = A*(P-B)C for Field Events
	 * A, B, C are taken from the super class. The points are always an integer (according to websites)
	 * @return int
	 */
	private int computePoints() {
		int points = (int)(super.getAParameter() * 
				Math.pow((this.achievedResult - super.getBParameter()), super.getCParameter()));
		
		return points;
		
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
	
	protected void saveRawResult(String result) {
		super.setRawResult(String.valueOf(result));
	}
	
	/**
	 * Construtor for the Field Event. Takes all necessary parameters for the instantiation to make sense. No parameter can be omitted,
	 * otherwise results cannot be calculated.
	 * @param double achievedResult
	 * @param double aParameter
	 * @param double bParameter
	 * @param double cParameter
	 * @throws Exception
	 */
	public FieldDecathlonEvent(double achievedResult, double aParameter, double bParameter, double cParameter) throws Exception {
		this.achievedResult = achievedResult;
		super.setAParameter(aParameter);
		super.setBParameter(bParameter);
		super.setCParameter(cParameter);
	}
}
