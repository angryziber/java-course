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
			values = userString.split(" ");
			
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
		}
		
		return inputOK;
		
	}
	
	public boolean parseOutput(String output){
		boolean outputOK = false;
		
		if(output.toLowerCase().equals("console")){
			this.output = new ConsoleOutput();
		}
		
		return outputOK;
	}
	
	public Input getInput(){
		return input;
	}
	
	public Output getOutput(){
		return output;
	}
	
	
}
