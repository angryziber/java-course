package net.azib.java.students.t030726.homework.input;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import net.azib.java.students.t030726.homework.decathlon.DecathlonChampionship;

/**
 * The input controller class abstracts the lower-level operations and provides a common interface for all possible input methods.
 * @author Deniss Nikiforov
 *
 */
public class InputController {
	IInput controllerInput = null;
	private String csvFilePath = null;
	private String mysqlURL = null;
	private String mysqlPassword = null;
	private String mysqlUsername = null;
	private int mysqlCompetitionID = 0;
	
	private InputType selectedInputType = InputType.CONSOLE_INPUT;
	
	/**
	 * A Constructor for console input
	 * @param inputType
	 * @throws Exception
	 */
	public InputController(InputType inputType) throws Exception {
		this.selectedInputType = inputType;
		this.typeSwitcher(inputType);
	}
	
	/**
	 * A Constructor for CSV input
	 * @param inputType
	 * @param csvFilePath
	 * @throws Exception
	 */
	public InputController(InputType inputType, String csvFilePath) throws Exception {
		this.csvFilePath = csvFilePath;
		this.typeSwitcher(inputType);
	}
	
	/**
	 * A Constructor for database input
	 * @param inputType
	 * @param serverURL
	 * @param serverUsername
	 * @param serverPassword
	 * @param targetCompetition
	 * @throws Exception
	 */
	public InputController(InputType inputType, String serverURL, String serverUsername, String serverPassword, int targetCompetition) throws Exception {
		this.mysqlCompetitionID = targetCompetition;
		this.mysqlPassword = serverPassword;
		this.mysqlURL = serverURL;
		this.mysqlUsername = serverUsername;
		this.typeSwitcher(inputType);
	}
	
	private void typeSwitcher(InputType inputType) throws Exception {
		switch(inputType) {
		case CONSOLE_INPUT:
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			this.controllerInput = new KeyboardInput(br);
			break;
		case CSV_INPUT:
			this.controllerInput = new CommaSeparatedValuesInput(this.csvFilePath);
			break;
		case MYSQL_INPUT:
			this.controllerInput = new SQLInput(this.mysqlURL, this.mysqlUsername, this.mysqlPassword, this.mysqlCompetitionID);
			break;
		default:
			throw new Exception("Invalid input type");
		}
	}
	
	/**
	 * Returns a numeric representation of the selected input type
	 * @return
	 */
	public InputType getSelectedInputType() {
		return this.selectedInputType;
	}
	
	
	/**
	 * Returns true if there is something to read
	 * @return
	 */
	public boolean hasNext() {
		return this.controllerInput.hasNext();
		
	}
	
	/**
	 * Returns the next object from the iterator.
	 * @return
	 * @throws InstantiationException
	 * @throws Exception
	 */
	public DecathlonChampionship getNext() throws InstantiationException, Exception {
		return this.controllerInput.getNext();
		
	}
	
	
}
