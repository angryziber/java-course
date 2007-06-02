package net.azib.java.students.t030656.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;


/**
 * reader
 *
 * @author sprot
 */
public class Reader {

	/**
	 * constructor
	 */
	public Reader() {
	}
	/**
	 * Reads input from screen
	 * @return
	 */
	static Competition readFromScreen(){
		Competition comp = new Competition();
		InputStream in = System.in;
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		while (true) {
			try {
				System.out.print("Enter the competition name: ");
				comp.setName(reader.readLine());
				break;
			}
			catch (IOException e) {
				System.out.println("Wrong input. Try again!");
			}
		}
		boolean b = true;
		while (b) {
			Participant par = new Participant();
			par.setName(getParticipantName(reader));
			par.setDateOfBirth(getParticipantDateOfBirth(reader));
			par.setCountry(getParticipantCountry(reader));
			while (true) {
				try
				{
					par.setResults(getParticipantResults(reader));
					break;
				}
				catch(NumberFormatException ex){
					System.out.println("Wrong input. Not in correct format. Try again!");
				}
				catch(IllegalArgumentException ex){
					System.out.println("Wrong number of results (less on greater than 10). Try again!");
				}
				catch(Exception ex){
					ex.printStackTrace();
				}
			}
			comp.addParticipant(par);
			b = askContinue(reader);
		}		
		return comp;
	}

	/**
	 * @param reader
	 * @return
	 * @throws IOException
	 */
	private static String getParticipantName(BufferedReader reader){
		while (true) {
			try {
				System.out.print("Enter the participant name: ");
				String pName = reader.readLine();
				if(pName.length() != 0){
					return pName;
				}
			}
			catch (IOException e) {
				System.out.println("Wrong input. Try again!");
			}
			System.out.println("Wrong input. Name can not be empty. Try again!");
		}				
	}

	/**
	 * @param reader
	 * @return
	 * @throws IOException
	 */
	private static String getParticipantDateOfBirth(BufferedReader reader){
		while (true) {
			try {
				System.out.print("Enter the participants date of birth (dd.mm.yyyy): ");
				DateFormat df = new SimpleDateFormat("dd.mm.yyyy");
		        df.setLenient(false);
		        String strDate = reader.readLine();
		        df.format(df.parse(strDate));
				return strDate;
			}
			catch (IOException e) {
				System.out.println("Wrong input. Try again!");
			}
			catch (ParseException e) {
				System.out.println("Wrong input. Try again!");
			}
		}		
	}

	/**
	 * @param reader
	 * @return
	 * @throws IOException
	 */
	private static String getParticipantCountry(BufferedReader reader){
		while (true) {
			System.out.print("Enter the participants country (2 upercase letter code): ");
			String pCountry;
			try {
				pCountry = reader.readLine();
				if (pCountry.matches("[A-Z]{2}")) {
					/**
					 * check the aviability of this country code
					 */
					for(String str : Locale.getISOCountries())
					{
						if(str.matches(pCountry)){
							return pCountry;
						}
					}
					
				}else{
					System.out.println("Wrong format or wrong country code.");
				}	
			}
			catch (IOException e) {
				System.out.println("Wrong input. Try again!");
			}
			
		}		
	}
	
	private static boolean askContinue(BufferedReader reader){
		while(true){
			System.out.print("Insert another participant? \n" +
				"[1] Yes\n" +
				"[2] No\n " +
				": ");
			try {
				switch(Integer.parseInt(reader.readLine())){
				case 1:
					return true;
				case 2:
					return false;
				default:
					System.out.println("Wrong input");
				}
			}
			catch (NumberFormatException e) {
				System.out.println("Wrong input. Try again!");
			}
			catch (IOException e) {
				System.out.println("Wrong input. Try again!");
			}
		}
	}
	
	private static String[] getParticipantResults(BufferedReader reader){
		while (true) {
			System.out.print("Enter the participants results.\n " +
					"Delimiter results with coma (,). " +
					"Coma should represented as dot (.) \n " + 
					"like: 12.24,123.3: ");
			try {
				String str = reader.readLine();
				return str.split(",");
			}
			catch (IOException e) {
				System.out.println("Wrong input. Try again!");
			}
		}		
	}
}
