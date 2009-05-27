package net.azib.java.students.t030620.homework.util;

import net.azib.java.students.t030620.homework.input.InputType;
import net.azib.java.students.t030620.homework.output.OutputType;

/**
 * IOParams
 * bean containing input/output parameters for the application 
 * 
 * @author Maksim Konstantinov 030620
 */
public class IOParams {
	private InputType inputType;
	private OutputType outputType;
	private Object inputParam;
	private Object outputParam;
	public InputType getInputType() {
		return inputType;
	}
	public void setInputType(InputType inputType) {
		this.inputType = inputType;
	}
	public OutputType getOutputType() {
		return outputType;
	}
	public void setOutputType(OutputType outputType) {
		this.outputType = outputType;
	}
	public Object getInputParam() {
		return inputParam;
	}
	public void setInputParam(Object inputParam) {
		this.inputParam = inputParam;
	}
	public Object getOutputParam() {
		return outputParam;
	}
	public void setOutputParam(Object outputParam) {
		this.outputParam = outputParam;
	}
	
	

}
