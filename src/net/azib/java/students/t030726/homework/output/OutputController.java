package net.azib.java.students.t030726.homework.output;

import net.azib.java.students.t030726.homework.decathlon.RatedDecathlonCompetition;


/**
 * The output controller. Abstracts lower levels of output for the upper layers
 * @author NTAdmin
 *
 */
public class OutputController {
	
	private OutputType chosenType = OutputType.SCREEN_OUTPUT;
	private String outputFilePath = null;
	private IOutput targetController = null;
	
	/**
	 * Constructor for screen dumps
	 * @param output
	 * @param outputType
	 * @throws Exception
	 */
	public OutputController(RatedDecathlonCompetition output, OutputType outputType) throws Exception {
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
	public OutputController(RatedDecathlonCompetition output, OutputType outputType, String outFilePath) throws Exception {
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
	private void typeSwitcher(OutputType outputType, RatedDecathlonCompetition output) throws Exception {
		IOutput outputControl = null;
		switch(outputType) {
		case SCREEN_OUTPUT:
			outputControl = new ScreenOutput(output);
			break;
		case CSV_OUTPUT:
			outputControl = new CommaSeparatedValuesOutput(this.outputFilePath, output);
			break;
		case XML_OUTPUT:
			outputControl = new MarkupLanguageOutput(this.outputFilePath, output);
			break;
		case HTML_OUTPUT:
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
	public OutputType getSelectedType() throws Exception {
		return this.chosenType;
	}
	
	/**
	 * Dumps the content to disk (or screen), depending on the inputType setting
	 * @throws Exception 
	 *
	 */
	public void flush() throws Exception {
		this.targetController.dump();
	}
	
	
}
