package net.azib.java.students.t001370.homework;

/**
 * Errors
 * Enum for holding possible errors 
 * @author maksim
 */
public enum Errors {
	ERROR_0001 ("Error 0001! Could not create HTML file."),
	ERROR_0002 ("Error 0002! Could not close stylesheet."),
	ERROR_0003 ("Error 0003! Could not write data to: "),
	ERROR_0004 ("Error 0004! Could not write to XML file."),
	ERROR_0005 ("Error 0005! Problems closing file write"),
	ERROR_0006 ("Error 0006! Problems reading CSV file='"),
	ERROR_0007 ("Error 0007! Ouput method is not valid."),
	ERROR_0008 ("Error 0008! Major error!"),
	ERROR_0009 ("Error 0009! Please check input argument: Input="),
	ERROR_0010 ("Error 0010! Please check output argument (Should be like '-csv'): Output="),
	ERROR_0011 ("Error 0011! Could not get competition results from input."),
	ERROR_0012 ("Error 0012! Cound not read from DB."),
	ERROR_0013 ("Error 0013! Cound not close all DB relations."),
	ERROR_0014 ("Error 0014! Number format is wrong. Try again."),
	ERROR_0015 ("Error 0015! Date format is frong. Try again."),
	ERROR_0016 ("Error 0016! Birthday format is wrong in CSV file. Check athlete: "),
	ERROR_0017 ("Error 0017! Athlete data in CSV not valid at line='"),
	ERROR_0018 ("Error 0018! Could not get data from CSV file."),
	ERROR_0019 ("Error 0019! Problems closing CSV file."),
	ERROR_0020 ("Error 0020! Input method is not valid: "),
	ERROR_0021 ("Error 0021! Could not get data from input."),
	ERROR_0022 ("Error 0022! Ahtlete result number format is wrong. Result will be set to '0.0'"),
	ERROR_0023 ("Error 0023! Country code does not match pattern. Try again."),
	ERROR_0024 ("Error 0024! db.properties file not found."),
	ERROR_0025 ("Error 0025! IO error reading db.priperties."),
	ERROR_0026 ("Error 0026! No input argument found."),
	ERROR_0027 ("Error 0027! No output argument found."),
	ERROR_0028 ("Error 0028! Input or output method is not set.");
	
	
	private String errorText;
	
	/**
	 * Errors constructor
	 * @param error - error description
	 */
	Errors(String error){
		this.errorText = error;
	}

	/**
	 * Get error description
	 * @return error description string
	 */
	public String getErrorText(){
		return this.errorText;
	}
}
