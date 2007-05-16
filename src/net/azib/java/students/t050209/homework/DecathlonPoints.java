package net.azib.java.students.t050209.homework;

/**
 * DecathlonPoints
 *
 * @author Kaupo Laan
 */
public enum DecathlonPoints {

	    RUN_100       (25.473,  18.0, 1.81, 1, 0),
	    LONG_JUMP     (0.14354, 220,  1.40, 0, 1),
	    SHOT_PUT      (51.39,   1.5,  1.05, 0, 1),
	    HIGH_JUMP     (0.8465,  75,   1.42, 0, 1),
	    RUN_400       (1.53775, 82,   1.81, 1, 0),
	    HURDLES_110   (5.74352, 28.5, 1.92, 1, 0),
	    DISCUS_THROW  (12.91,   4.0,  1.1,  0, 1),
	    POLE_VAULT    (0.2797,  100,  1.35, 0, 1),
	    JAVELIN_THROW (10.14,   7.0,  1.08, 0, 1),
	    RUN_1500      (0.03768, 480,  1.85, 1, 0);

	    private final double A;   
	    private final double B;
	    private final double C;
	    private final int RUNNING_EVENT;
	    private final int FIELD_EVENT;
	    
	    DecathlonPoints(double A, double B, double C, 
	    			    int RUNNING_EVENT, int FIELD_EVENT) {
	        this.A = A;
	        this.B = B;
	        this.C = C;
	        this.RUNNING_EVENT = RUNNING_EVENT;
	        this.FIELD_EVENT = FIELD_EVENT;
	    }
	    
	    //TODO - add some time to running events, convert meters to centimeters
	    
	    private double convertPerformance(double performance) {
	        if (this.A == LONG_JUMP.A || 
	        	this.A == HIGH_JUMP.A ||
	        	this.A == POLE_VAULT.A)
	        	performance = performance * 100;
	        return performance;
	    }
	    
	    public int runningEventsPoints(double performance) {
	        return (int)(A * Math.pow((B - convertPerformance(performance)), C));
	    }
	    
	    public int fieldEventsPoints(double performance) {
	    	return (int)(A * Math.pow((convertPerformance(performance) - B), C));
	    }
	    
	    public int eventPoints(double performance) {
	    	return (int)(runningEventsPoints(performance) * RUNNING_EVENT +
	    			 	 fieldEventsPoints(performance) * FIELD_EVENT);
	    }
	    
	    public boolean checkIfRunningEvent(){
	    	if (this.RUNNING_EVENT == 1)
	    		return true;
	    	else
	    		return false;
	    }
}
