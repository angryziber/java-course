package net.azib.java.students.t040729.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Interactive console input implementation.
 * Lets data to be typed in from the console.
 *
 * @author ValleTon
 */
public class ConsoleDataReader implements CompetitionDataIn {
	private List<Athlete> athletes = new ArrayList<Athlete>();
	Properties properties;
	private BufferedReader input;
	
	/**
	 * Default constructor which initialises console in.
	 */
	
	public ConsoleDataReader() {
		input = new BufferedReader(new InputStreamReader(System.in));
	}
	
	/**
	 * Alternative constructor for differenct input.
	 * @param input defines input other than System.in
	 */
	public ConsoleDataReader(BufferedReader input) {
		this.input = input;
	}

	@Override
	public List<Athlete> getCompetitionData() throws Exception {
		return doAskingAndGetList();
	}

	private List<Athlete> doAskingAndGetList() throws Exception {
		Athlete athlete;
		String choice;
		byte eventChoice = -1;
		printStartupMessages();
		
		Event[] events = Event.values();
		
		int i=0;
		outer:
		while (true){
			i++;
			System.out.println("Competitor #"+i);
			
			athlete = inputAthleteDataAndGetAthlete(input);
			
			System.out.println("Now the results from each event..");
			
			for (Event evt : events){
				inputEventData(input, athlete, evt);
			}
			
			athletes.add(athlete);
			
			while(true){
				choice = getInput(input,"\nEnter:\n[x] to finish\n[1-10] to make corrections in results\nAnything else to continue with new athlete\nMake a choice: ","(1[0])|(.*)");
				try{
					eventChoice = Byte.parseByte(choice);
				}catch(NumberFormatException e){
					eventChoice = -1;
				}
			
				if (choice.equals("x")){
					break outer;
				}else if (eventChoice>0 && eventChoice < 11){
					inputEventData(input, athlete, events[eventChoice-1]);
				}else{
					break;
				}
			}
		}
		return athletes;
	}

	private Athlete inputAthleteDataAndGetAthlete(BufferedReader in) throws Exception {
		String inName;
		String inBirthDate;
		String inCountryCode;

		inName = null;
		inBirthDate = null;
		inCountryCode = null;
		inName = getInput(in,"Name: ","");
		inBirthDate = getInput(in,"Birthdate (dd.mm.yyyy): ","(0[1-9]|[12][0-9]|3[01]).(0[1-9]|1[012]).(19|20)\\d\\d");
		inCountryCode = getInput(in,"ISO 2 Letter Country Code: ","[A-Z]{2}");
		
		return new Athlete(new Name(inName),new BirthDate(inBirthDate,"dd.MM.yyyy"),new Country(inCountryCode));
	}

	private void inputEventData(BufferedReader in, Athlete athlete, Event evt) throws Exception {
		String tmpInputString;
		String[] resultTime;
		if (evt.isTrackEvent()){
			tmpInputString = getInput(in,evt.toString()+" [m:ss.SS or ss.SS]: ","([0-9]:)?([0-5]?[0-9])(\\.[0-9]+)?");
			if (tmpInputString.contains(":")){
				resultTime = tmpInputString.split(":");
				athlete.insertEventResult((byte) evt.ordinal(), Integer.parseInt(resultTime[0])*60 + Float.parseFloat(resultTime[1]));
			}else{
				athlete.insertEventResult((byte) evt.ordinal(), Float.parseFloat(tmpInputString));
			}
		}else{
			athlete.insertEventResult((byte) evt.ordinal(), Float.parseFloat(getInput(in,evt.toString()+" [e.g. 19.57]: ","[0-9]*\\.?[0-9]+")));
		}
	}
	
	private void printStartupMessages(){
		System.out.println("Competition data input.");
		System.out.println("-----------------------");
		System.out.println();
		System.out.println("Abort anytime with CTRL+C or finish when data is inserted.");
		System.out.println();
	}
	
	private String getInput(BufferedReader in, String message, String patternString) throws Exception{
		if (patternString.isEmpty()){
			patternString = ".+";
		}
		Pattern pattern = Pattern.compile(patternString);

		String input = "";
		
		while (true) {
			System.out.print(message);
			try {
				input = in.readLine();
				Matcher m = pattern.matcher(input);
				if (m.matches()){
					break;
				}else{
					System.out.println("Entered value is not valid. Try again.");
				}		
			}catch (IOException e) {
				System.err.println("There was an error while reading console input. Try again.");
			}catch (Exception e){
				throw new Exception("\nConsole input terminated.");
			}
		}
		return input;
	}

	@Override
	public void setAppProperties(Properties properties) {
		this.properties = properties;
	}
}
