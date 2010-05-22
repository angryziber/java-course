package net.azib.java.students.t050720.homework;


/**
 * <b>ArgumentsParser</b>
 * <br />
 * Parses entered string list for the program.
 * First string is assumed to be the input type/location, eg. {@code -console} or {@code -csv}.
 * If the input source needs a parameter (all except -console), then the next string is the parameter.
 * Then, the output type/location.
 * Finally, if the output destination needs a parameter (all except {@code -console}), then the last string is assumed to be the parameter.
 * 
 * The default input and output locations are {@code -console} for both.
 * 
 * @author Marek
 */
public class ArgumentsParser {
	
	private String iType="-console";
	private String iParam="";
	private String oType="-console";
	private String oParam="";

	/**
	 * Creates ArgumentsParser object and parses the passed strings.
	 * After creation, the object can be queried for the individual arguments.
	 * @param args Contains the arguments to be parsed
	 */
	public ArgumentsParser(String[] args) {
		if(args.length<2) return;
		for(String t:args) if(t==null) return;
		iType=args[0].isEmpty() ? "-console":args[0];
		int oTypeIndex=2;
		if(iType.contentEquals("-console")) oTypeIndex=1;
		else iParam=args[1];
		
		if(args.length<oTypeIndex+1) return;
		oType=args[oTypeIndex].isEmpty() ? "-console" : args[oTypeIndex];
		if(oType.contentEquals("-console") || args.length<oTypeIndex+2) return;
		else oParam=args[oTypeIndex+1];
	}

	/**
	 * Returns the input type stored, either the default or custom. Returned string always starts with a dash, for example "-console"
	 * @return String with the input type stored.
	 */
	public String inputType() {
		return iType;
	}

	/**
	 * Returns the parameter for input, if any. Otherwise returns an empty String.
	 * @return String with custom parameter for input.
	 */
	public String inputParams() {
		return iParam;
	}

	/**
	 * Returns the output type stored, either the default or custom. Returned string always starts with a dash, for example "-console"
	 * @return String with the output type stored.
	 */
	public String outputType() {
		return oType;
	}

	/**
	 * Returns the parameter for output, if any. Otherwise returns an empty String.
	 * @return String with custom parameter for output.
	 */
	public String outputParams() {
		return oParam;
	}

}
