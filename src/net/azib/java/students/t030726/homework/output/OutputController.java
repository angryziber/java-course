package output;

import decathlon.RatedDecathlonCompetition;

/**
 * The output controller. Abstracts lower levels of output for the upper layers
 * @author NTAdmin
 *
 */
public class OutputController {
	public static final int SCREEN_OUTPUT = 1;
	public static final int CSV_OUTPUT = 2;
	public static final int XML_OUTPUT = 3;
	public static final int HTML_OUTPUT = 4;
	
	private int chosenType = 0;
	private String outputFilePath = null;
	private IOutput targetController = null;
	
	/**
	 * Constructor for screen dumps
	 * @param output
	 * @param outputType
	 * @throws Exception
	 */
	public OutputController(RatedDecathlonCompetition output, int outputType) throws Exception {
		this.chosenType = outputType;
		this.typeSwitcher(outputType, output);
	}
	
	/**
	 * Constructor for other types of output (all other types require only 1 path as parameter)
	 * @param output
	 * @param outputType
	 * @param outFilePath
	 * @throws Exception
	 */
	public OutputController(RatedDecathlonCompetition output, int outputType, String outFilePath) throws Exception {
		this.chosenType = outputType;
		this.outputFilePath = outFilePath;
		this.typeSwitcher(outputType, output);
	}
	
	/**
	 * Switching between types and instantiating the correct object
	 * @param outputType
	 * @param output
	 * @throws Exception
	 */
	private void typeSwitcher(int outputType, RatedDecathlonCompetition output) throws Exception {
		IOutput outputControl = null;
		switch(outputType) {
		case OutputController.SCREEN_OUTPUT:
			outputControl = new ScreenOutput(output);
			break;
		case OutputController.CSV_OUTPUT:
			outputControl = new CommaSeparatedValuesOutput(this.outputFilePath, output);
			break;
		case OutputController.XML_OUTPUT:
			outputControl = new MarkupLanguageOutput(this.outputFilePath, output);
			break;
		case OutputController.HTML_OUTPUT:
			outputControl = new HyperTextOutput(this.outputFilePath, output);
			break;
		default:
			
		}
		this.targetController = outputControl;
	}
	
	/**
	 * A getter for the active output type
	 * @return
	 */
	public int getSelectedType() {
		return this.chosenType;
	}
	
	/**
	 * Dumps the content to disk (or screen)
	 *
	 */
	public void flush() {
		this.targetController.dump();
	}
	
	
}
