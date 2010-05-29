package net.azib.java.students.t092859.homework.input;

import net.azib.java.students.t092859.homework.core.DecathlonResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Map.Entry;

/**
 * ConsoleResultFetcher
 *
 * @author konstantin
 */
public class ConsoleResultFetcher implements DecathlonResultFetcher{
	
	private Scanner input;
	
	public ConsoleResultFetcher(){
		input = new Scanner(System.in);
	}
	
	/**
	 * Fetches decathlon results from console
	 * interactively (asks user for each value).
	 * Input is checked to be matching with pattern,
	 * value is asked again if it does not match the pattern
	 * @return List of fetched decathlon results
	 */
	@Override
	public List<DecathlonResult> fetchResults() {
		List<DecathlonResult> results = new ArrayList<DecathlonResult>();

		while(true)
		{
			Map<String,String> messagesWithValues = new LinkedHashMap<String,String>();
			messagesWithValues.put("NAME|name (must contain letters only, consist of at least first and last name with first capital letter)", null);
			messagesWithValues.put("DOB|date of birth (in format of locale corresponding to country for which athlete is performing)", null);
			messagesWithValues.put("COUNTRY|country for which athlete is performing (ISO 2-letter code)", null);
			messagesWithValues.put("100M|100m sprint result (sec)", null);
			messagesWithValues.put("LONG_JUMP|long jump result (m)", null);
			messagesWithValues.put("SHOT_PUT|shot put result (m)", null);
			messagesWithValues.put("HIGH_JUMP|high jump result (m)", null);
			messagesWithValues.put("400M|400m sprint result ([min:]sec)", null);
			messagesWithValues.put("HURDLES|110m hurdles result (sec)", null);
			messagesWithValues.put("DISCUS_THROW|discus throw result (m)", null);
			messagesWithValues.put("POLE_VAULT|pole vault result (m)", null);
			messagesWithValues.put("JAVELIN_THROW|javelin throw result (m)", null);
			messagesWithValues.put("1500M|1500m race result ([min:]sec)", null);
		
			
			for(Entry<String, String> entry: messagesWithValues.entrySet())
			{
				while(true)
				{
					System.out.print("Enter " + entry.getKey().split("\\|")[1] + ":\n\t");
					String value = input.nextLine();
					if(value.matches(DecathlonResult.inputPatterns.get(entry.getKey().split("\\|")[0])))
					{
						entry.setValue(value);
						break;
					}
					System.out.println("Invalid value");
				}
			}
			
			DecathlonResult result = new DecathlonResult(messagesWithValues.values().toArray(new String[0]));
			int incorrectParam;
			if((incorrectParam = result.getValidationResult()) == -1)
				results.add(result);
			else
				System.out.println("Could not accept result: incorrect parameter " + incorrectParam);
			
			String continueAnswer;
			do{
				System.out.println("Add more results? y/n");
				continueAnswer = input.nextLine();
			}while(!continueAnswer.matches("y|n"));
			if(continueAnswer.equals("n"))
				break;
		}
		return results;
	}
	
	/**
	 * Used for tests
	 * @param mockInput - replaces stdin as input source
	 */
	void setTestInput (String mockInput){
		input = new Scanner(mockInput);
	}

}
