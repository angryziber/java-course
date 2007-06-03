package decathlon;

/**
 * An interface for an {@link Event}t enum.
 * @author t020543
 */
public interface IEvent {
	
	/**
	 * Calculates decathlon points for a single event
	 * @param input - event raw result (a measurement in <i>m</i>, <i>cm</i> or <i>sec</i> )
	 * @return calculated points
	 * */
	abstract int calculateEvent(double input);
	
	/**
	 * Compares event result with current World Record.
	 * 
	 * @param input - event raw result ( a measurement in <i>m</i>, <i>cm</i> or <i>sec</i> )
	 * @return <b>true</b> - if input is equal or better than WR, if not - <b>false</b>
	 * */
	abstract boolean compareWorldRecord(double input);
}
