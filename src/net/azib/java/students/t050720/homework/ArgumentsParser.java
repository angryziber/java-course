package net.azib.java.students.t050720.homework;


/**
 * ArgumentsParser
 *
 * @author Marek
 */
public class ArgumentsParser {
	
	private String iType="-console";
	private String iParam="";
	private String oType="-console";
	private String oParam="";

	/**
	 * @param args
	 */
	public ArgumentsParser(String[] args) {
		if(args.length==0) return;
		iType=args[0];
		int oTypeIndex=2;
		if(iType.contentEquals("-console")) oTypeIndex=1;
		else iParam=args[1];
		
		oType=args[oTypeIndex];
		if(oType.contentEquals("-console")) return;
		else oParam=args[oTypeIndex+1];
	}

	/**
	 * @return
	 */
	public String inputType() {
		return iType;
	}

	/**
	 * @return
	 */
	public String inputParams() {
		return iParam;
	}

	/**
	 * @return
	 */
	public String outputType() {
		return oType;
	}

	/**
	 * @return
	 */
	public String outputParams() {
		return oParam;
	}

}
