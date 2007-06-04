package input;

import decathlon.DecathlonChampionship;

/**
 * The interface defines the standard functions, which are expected by the InputController.
 * @author Deniss Nikiforov
 *
 */
public interface IInput {

	public boolean hasNext();
	
	public DecathlonChampionship getNext() throws InstantiationException, Exception;
}
