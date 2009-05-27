package net.azib.java.students.t030620.homework.util;



import java.util.Properties;
import net.azib.java.students.t030620.homework.beans.DecathleteScoreKeeper;
import net.azib.java.students.t030620.homework.enums.Competition;
import net.azib.java.students.t030620.homework.input.InputType;
import net.azib.java.students.t030620.homework.output.OutputType;
import java.io.File;
import java.io.InputStream;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Utils
 *
 * @author Lord HellBunny
 */
public class Utils {
	
	private static final SimpleDateFormat DATE_FORMAT  = new SimpleDateFormat("dd.MM.yyyy");


	
	public static IOParams getIOParams(String[] args ) throws Exception {
		 
		if(args.length < 2) {
			throw new Exception("Insufficient parameter amout");
		}
		
		
		
		InputType inputType   = null;
		Object inputParam     = null;		
		File outputParam      = null;
		OutputType outputType = null;
		
		try {
			inputType = getInputType(args[0]);
		} catch (Exception e) {
		}
		
		if(inputType == null) {
			try {
				outputType = getOutputType(args[0]);
			} catch (Exception e) {
				
			}
		}
		
		if(inputType == null && outputType == null) {
			StringBuilder sbInput = new StringBuilder();
			for(OutputType value : OutputType.values()) {
				sbInput.append(" '-" +value.name().toLowerCase()+ "' ");
			}
			
			StringBuilder sbOutput = new StringBuilder();
			for(InputType value : InputType.values()) {
				sbOutput.append(" '-" +value.name().toLowerCase()+ "' ");
			}
			
			throw new Exception("Invalid input/output type specified. Allowed input types are:"+sbInput.toString()+". Allowed output types are: "+sbOutput.toString());
		}
		
		int nextArg = 2;
		if(inputType != null) {
			if(inputType != InputType.CONSOLE){ inputParam = getInputParam(inputType, args[1]); }
			else {nextArg = 1;}
		} else {
			if(outputType != OutputType.CONSOLE){ outputParam = getOutputParam(outputType, args[1]); } 
			else {nextArg = 1;}
		}
		
		if(inputType != null) {
			try {
				outputType = getOutputType(args[nextArg]);
			} catch (Exception e) {
				StringBuilder sbOutput = new StringBuilder();
				for(InputType value : InputType.values()) {
					sbOutput.append(" '-" +value.name().toLowerCase()+ "' ");
				}
				throw new Exception("Invalid output type specified.  Allowed output types are: "+sbOutput.toString());
			}
		} else {
			try {
				inputType = getInputType(args[nextArg]);
			} catch (Exception e) {
				StringBuilder sbInput = new StringBuilder();
				for(OutputType value : OutputType.values()) {
					sbInput.append(" '-" +value.name().toLowerCase()+ "' ");
				}
				throw new Exception("Invalid input type specified. Allowed input types are:"+sbInput.toString());
			}
		}
		
		nextArg++;
		
		
		if(outputParam != null) {
			if(inputType != InputType.CONSOLE){
				try {
					 inputParam = getInputParam(inputType, args[nextArg]);
				} catch (ArrayIndexOutOfBoundsException e ) {
					throw new Exception ("No input param for type "+inputType.name().toLowerCase()+" specified");
				}	
			}
		} else {
			if(outputType != OutputType.CONSOLE){ 
				try {
					outputParam = getOutputParam(outputType, args[nextArg]); 
				} catch (ArrayIndexOutOfBoundsException e ) {
					throw new Exception ("No output param for type "+outputType.name().toLowerCase()+" specified");
				}
			} 
		}
		
		IOParams params = new IOParams();
		params.setInputType(inputType);
		params.setInputParam(inputParam);
		params.setOutputType(outputType);
		params.setOutputParam(outputParam);
		
		return params;
		
	}
	
	
	
	private static Object getInputParam(InputType inputType, String param) throws Exception {
		Object inputParam = null;
		if(inputType == InputType.DB) {
			try {
				inputParam = (Object)Integer.valueOf(param);
			} catch (NumberFormatException nfe) {
				inputParam = param;
			}
		} else if(inputType == InputType.CSV) {
			File file = new File(param);
			if(!file.exists()) { throw new Exception("The specified CSV input file doesn't exist");}
			inputParam = file;
		}
		
		return inputParam;
	}
	
	private static File getOutputParam(OutputType outputType, String param) {
		return new File(param);
	}
	
	private static InputType getInputType(String type) throws Exception {
		return InputType.valueOf(type.substring(1).toUpperCase());
	}
	
	private static OutputType getOutputType(String type) throws Exception {

		return OutputType.valueOf(type.substring(1).toUpperCase());
		
	}
	
	
	
	public static Timestamp parseTimestamp(String string, int lineNr) throws Exception {
		try {	
			return new Timestamp(DATE_FORMAT.parse(string).getTime());
		} catch (Exception nfe) {
			if(lineNr == -1) {
				throw new Exception("Invalid data-of-birth parameter ("+string+")");
			} else {
				throw new Exception("Invalid data-of-birth parameter ("+string+") in line "+lineNr+"");
			}
		}

	}
	
	
	
	public static String formatSeconds(double seconds)  {
		double minutes = seconds/60;
		int iPart = (int) minutes;
		double fPart = minutes - iPart;
		return iPart+":"+ formatDecimal(fPart*60);
	}
	
	public static double parseSeconds(String string, int lineNr) throws Exception {
		String[] params = string.trim().split(":");
		
		
		try {
			double minutes = 0, seconds = 0;
			if(params.length == 2) {
				minutes = Double.parseDouble(params[0]) * 60;
				seconds = Double.parseDouble(params[1]);
			} else {
				seconds = Double.parseDouble(params[0]);
			}
			
			return  minutes + seconds;
			
		} catch (Exception e) {
			if(lineNr == -1) {
				throw new Exception("Invalid min:sec parameter ("+string+")");
			} else {
				throw new Exception("Invalid min:sec parameter ("+string+") in line "+lineNr+"");
			}
		}
		
	}
	
	public static double parseDouble(String string, int lineNr) throws Exception {
		try {
			return Double.parseDouble(string.trim());
		} catch (Exception e) {
			if(lineNr == -1) {
				throw new Exception("Invalid distance parameter ("+string+")");
			} else {
				throw new Exception("Invalid distance parameter ("+string+") in line "+lineNr+"");
			}
		}
	}
	
	
	
	public static String formatDate(Timestamp date) {
		if(date == null) return "00.00.0000";
		return DATE_FORMAT.format(date);
	}
	
	public static String formatDecimal (double decimal) {
		
		DecimalFormat f = new DecimalFormat("##.##");
		DecimalFormatSymbols s = f.getDecimalFormatSymbols();
		s.setDecimalSeparator('.');
		f.setDecimalFormatSymbols(s);
		return f.format(decimal);
	}
	
	public static void prompt(String txt) {
		System.out.println(txt);
	}
	
	public static Properties getProperties(String fileName, Class<?> c)  throws Exception {
		Properties props = new Properties();
		try {
			InputStream in = c.getResourceAsStream(fileName);
			props.load(in);
			in.close();
		} catch (Exception e) {
			return null;
		}
		return props;
	}
	
}
