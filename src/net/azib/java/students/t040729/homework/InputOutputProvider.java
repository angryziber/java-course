package net.azib.java.students.t040729.homework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Provides input and output implementations depeding on
 * given arguments.
 *
 * @author ValleTon
 */
public class InputOutputProvider {
	private static final String CMD_LINE_ERROR = "Required command-line parameters are missing!\nTip: <program> -<input-method> [input-parameters] -<output-method> [output-parameters]\n\nInput methods available:\n-console\n-csv <input file>\n-db <competition ID or name>\n\nOutput methods available:\n-console\n-csv <output file>\n-xml <output file>\n-html <output file>";
	private CompetitionDataIn input = null;
	private CompetitionDataOut output = null;
	
	private void setOutputImplementation(int index, String[] args) throws Exception{
		if (args[index].equals("-console")){
			output = new ConsoleDataWriter();
		}else if (args[index].equals("-csv")){
			output = new CsvDataWriter(args[index+1]);
		}else if (args[index].equals("-xml")){
			output = new XmlDataWriter(args[index+1]);
		}else if (args[index].equals("-html")){
			output = new HtmlDataWriter(args[index+1]);
		}
	}
	
	/**
	 * @param args Arguments which determine input and output.
	 * @throws Exception
	 */
	InputOutputProvider(String[] args) throws Exception{

		try{	
			if (args[0].equals("-console")){
				input = new ConsoleDataReader();
				setOutputImplementation(1, args);
			}else if (args[0].equals("-csv")){
				input = new CsvDataReader(args[1]);
				setOutputImplementation(2, args);
			}else if (args[0].equals("-db")){
				Properties dbProperties = getDbProperties();
				input = new MySqlDataReader(args[1], dbProperties);
				setOutputImplementation(2, args);
			}
			if (input==null || output==null){
				throw new IllegalArgumentException(CMD_LINE_ERROR);
			}
			
			Properties properties = getAppProperties();
			input.setAppProperties(properties);
			output.setAppProperties(properties);
		} catch (ArrayIndexOutOfBoundsException e){
			throw new Exception(CMD_LINE_ERROR);
		} catch (Exception e){
			throw e;
		}
	}
	
	/**
	 * @return Corresponding input implementation
	 */
	public CompetitionDataIn getInput(){
		return input;
	}
	
	/**
	 * @return Corresponding output implementation
	 */
	public CompetitionDataOut getOutput(){
		return output;
	}
	
	/**
	 * @return Properties for database manipulation
	 * @throws Exception
	 */
	public Properties getDbProperties() throws Exception{
		return getProperties("db.properties");
	}
	
	/**
	 * @return Properties for application
	 * @throws Exception
	 */
	public Properties getAppProperties() throws Exception{
		return getProperties("app.properties");
	}
	
	private Properties getProperties(String fileName) throws Exception{
		Properties properties = new Properties();
		FileInputStream in = null;
		try {
			in = new FileInputStream(getClass().getResource(".").getPath()+fileName);
	
			try {
				properties.load(in);
			}
			catch (IOException e) {
				throw new Exception("Cannot load properties from file "+fileName+"!");
			}
			
			try {
				in.close();
			}
			catch (IOException e) {
				throw e;
			}	
		}
		catch (FileNotFoundException e1) {
			throw new Exception("Cannot open property file "+fileName+"!");
		}
		
		return properties;
	}
}
