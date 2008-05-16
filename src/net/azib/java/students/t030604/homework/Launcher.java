package net.azib.java.students.t030604.homework;


import net.azib.java.students.t030604.homework.parser.ParserException;
import net.azib.java.students.t030604.homework.writer.WriterException;

import java.util.List;

/**
 * Launches the whole thing. Responsible for parsing
 * command line args, initializing parsers.
 * @author Aleksandr Ivanov
 * <a href="mailto:aleks21@gmail.com">contact</a>
 */
public class Launcher {
	
	/**
	 * main method
	 * @param args command line args
	 */
	public static void main (String[] args) {
		if (args == null || args.length == 0) {
			displayUsageAndExit();
		}
		CommandLineArgument inputMethod = getArgument(args[0]);
		if (inputMethod == null || inputMethod.getParser() == null || (inputMethod.isMustHaveParam() && args.length <=2) ) {
			displayUsageAndExit();
		}
		CommandLineArgument outputMethod = getArgument(args[inputMethod.isMustHaveParam()? 2 : 1]);
		
		if (outputMethod == null 
				|| outputMethod.getWriter() == null 
				|| (outputMethod.isMustHaveParam() && inputMethod.isMustHaveParam() && args.length != 4)
				|| (outputMethod.isMustHaveParam() ^ inputMethod.isMustHaveParam() && args.length != 3)
				|| (!outputMethod.isMustHaveParam() && !inputMethod.isMustHaveParam() && args.length != 2)) {
			displayUsageAndExit();
		}
		
		 
		List<AthleteScore> records = null;
		IDataParser parser = null;
		IDataWriter output = null;
		try {
			parser = inputMethod.getParser().newInstance();
			parser.setup(inputMethod.isMustHaveParam()? args[1] : null);
			records = parser.parseData();
			records = DataProcessor.process(records);
			output = outputMethod.getWriter().newInstance();
			output.setup(
					outputMethod.isMustHaveParam() && inputMethod.isMustHaveParam()
					? args[3] 
					: outputMethod.isMustHaveParam() ^ inputMethod.isMustHaveParam()
							? args[2]
							: null);
			output.output(records);
		} catch (WriterException fatal) {
			System.out.println(fatal.getMessage());
		} catch (ParserException fatal) {
			System.out.println(fatal.getMessage());
		} catch (Exception fatal) {
			System.out.println(fatal.getMessage());
		}
		finally {
			try {
				if(output != null) {output.cleanup();}
			} catch(WriterException ignored) {}
		
			try {
				if (parser != null) {parser.cleanup();}
			}catch (ParserException ignored){}
		}
	}
	
	private static CommandLineArgument getArgument(String name) {
		for (CommandLineArgument arg : CommandLineArgument.values()) {
			if(arg.getName().equals(name)){
				return arg;
			}
		}
		return null;
	}
	
	//prints usage and exits
	private static void displayUsageAndExit(){
		System.out.println("<program> -<input-method> [input-parameters] -<output-method> [output-parameters]");
		System.exit(0);
	}

}
