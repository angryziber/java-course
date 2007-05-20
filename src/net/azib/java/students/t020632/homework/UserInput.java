package net.azib.java.students.t020632.homework;

/**
 * UserInput parses user input
 *
 * @author Marek Soobik t020632
 */
public class UserInput {
	
	private Input input;
	private Output output;
	private String userString;
	
	public UserInput(String userString){
		this.userString = userString;
	}
	
	/**
	 * Parses lines inserted by user
	 * 
	 * @return
	 */
	public String parseUserInput(){
		String [] values;
		String input;
		String output;
		
		if(userString != null){
			userString = userString.trim();
			if(userString.contains("\"")){
				int i = 0;
				values = new String [2];
				
				if(userString.charAt(0) == '"'){
					i++;
					while(userString.charAt(i) != '"'){
						i++;
					}
					values[0] = userString.substring(1,i);
					if(userString.substring(i+1, userString.length()).contains("\""))
						values[1] = userString.substring(i+3, userString.length() -1);
					else
						values[1] = userString.substring(i+2, userString.length());
				}
				else{
					while(userString.charAt(i) != ' '){
						i++;
					}
					values[0] = userString.substring(0,i);
					values[1] = userString.substring(i+2, userString.length() - 1);
				}
			}
			else{
				values = userString.split("\\s+");
			}
			
			if(values.length == 2){
				input = values[0].trim();
				output = values[1].trim();
				
				if(parseInput(input) != true){
					return "Input parameter " + input +  " is not correct!";
				}
				
				if(parseOutput(output) != true){
					return "Output parameter " + output + " is not correct!";
				}
				
			}
			else{
				return "Two parameters are required!";
			}
			
		}
		else{
			return "No input!\n";
		}
		
		return "Input OK";
	}
	
	/**
	 * Creates new Input object
	 * 
	 * @param 	input string
	 * @return	boolean value indicating whether Input object is created or not
	 */
	public boolean parseInput(String input){
		boolean inputOK = false;
		
		if(input.toLowerCase().equals("console")){
			this.input = new ConsoleInput();
			return true;
		}
		if(input.toLowerCase().equals("database")){
			this.input = new DatabaseInput(1, "jdbc:mysql://srv.azib.net:3306/decathlon");
			return true;
		}
		else if(input.toLowerCase().substring(input.length() - 3).equals("csv")){
			this.input = new CSVInput(input);
			return true;
		}
		
		System.out.println(input);
		return inputOK;
		
	}
	
	
	/**
	 * Creates new Output object
	 * 
	 * @param 	output string
	 * @return	boolean value indicating whether Output object is created or not
	 */
	public boolean parseOutput(String output){
		
		if(output.toLowerCase().equals("console")){
			//System.out.println("console");
			this.output = new ConsoleOutput();
			return true;
		}
		else if(output.toLowerCase().substring(output.length() - 3).equals("csv")){
			this.output = new CSVOutput(output);
			return true;
		}
		else if(output.toLowerCase().substring(output.length() - 3).equals("xml")){
			this.output = new XMLOutput(output);
			return true;
		}
		else if(output.toLowerCase().substring(output.length() - 3).equals("xsl")){
			this.output = new HTMLOutput(output);
			return true;
		}
		
		//System.out.println(output);
		return false;
	}
	
	public Input getInput(){
		return input;
	}
	
	public Output getOutput(){
		return output;
	}
	
	
}
