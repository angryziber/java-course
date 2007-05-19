package net.azib.java.students.t020632.homework;

/**
 * UserInput
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
	
	public String parseUserInput(){
		String [] values;
		String input;
		String output;
		
		if(userString != null){
			userString = userString.trim();
			values = userString.split("\\s+");
			
			if(values.length == 2){
				input = values[0].trim();
				output = values[1].trim();
				
				if(parseInput(input) != true){
					return "Input parameter is not correct!";
				}
				
				if(parseOutput(output) != true){
					return "Output parameter is not correct!";
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
		
		return inputOK;
		
	}
	
	public boolean parseOutput(String output){
		
		if(output.toLowerCase().equals("console")){
			System.out.println("console");
			this.output = new ConsoleOutput();
			return true;
		}
		else if(output.toLowerCase().substring(output.length() - 3).equals("csv")){
			this.output = new CSVOutput(output);
			System.out.println(output.substring(output.length() - 3));
			return true;
		}
		else if(output.toLowerCase().substring(output.length() - 3).equals("xml")){
			this.output = new XMLOutput(output);
			System.out.println(output.substring(output.length() - 3));
			return true;
		}
		else if(output.toLowerCase().substring(output.length() - 4).equals("html")){
			this.output = new CSVOutput(output);
			System.out.println(output.substring(output.length() - 4));
			return true;
		}
		System.out.println(output.substring(output.length() - 3));
		System.out.println(output.substring(output.length() - 4));
		
		
		return false;
	}
	
	public Input getInput(){
		return input;
	}
	
	public Output getOutput(){
		return output;
	}
	
	
}
