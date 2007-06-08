package net.azib.java.students.t060401.homework.decathlon;

/**
 * DecathlonEvent
 *
 * @author jyrit
 */
public interface DecathlonEvent {

	/**
	 * @return returns points for the event which are calculated according to the official decathlon points formula
	 */
	public int getPoints();
	
	/**
	 * @return returns performance in meters if it's field event and seconds if it's running event
	 */
	public double getPerformance();
	
	/**
	 * @param performance performance to set
	 * @throws IllegalArgumentException
	 *             if performance value is null or negative
	 */
	public void setPerformance(double performance) throws IllegalArgumentException;
	
	/**
	 * Sets performance of an event. If it's running event, the performance should be given in seconds, if it's field event, the performance should be given in meters
	 * 
	 * @param performance performance to set
	 * @throws IllegalArgumentException
	 *             if performance value is null or negative
	 */
	public void setPerformance(String performance) throws IllegalArgumentException;
	
	/**
	 * @return returns enum type of the event
	 */
	public DecathlonEventEnum getEventKey();
}
