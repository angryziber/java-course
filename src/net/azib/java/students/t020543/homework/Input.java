package decathlon;

import java.util.List;

/**
 * Input interface
 * @author t020543
 */
public interface Input {

	/**
	 * Reads data to the list of {@link Athlete} objects
	 * @return list of {@link Athlete} instances
	 */
	public abstract List<Athlete> getData();
	
}
