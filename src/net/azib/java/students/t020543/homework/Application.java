package net.azib.java.students.t020543.homework;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;

/**
 * An appliable class, containing main() method and implementing user interface.<br>
 * Also, it has sorting, ranking and duplicate removing funcionality.
 * @author t020543
 */
public class Application {
		
	/**
	 * Calls for {@link Input} interface method <i>getData()</i>
	 * @param input - needed {@link Input} interface
	 */
	private static List<Athlete> getData(Input input) {
		return input.getData();	
	}	
	
	/**
	 * Calls for {@link IOutput} interface method <i>saveTo(Set<Competitor>, String)</i>
	 * @param output  - needed  {@link IOutput} interface
	 * @param set to be written
	 * @param destination - file name or path
	 */
	private static void saveTo(IOutput output, Set<Competitor> set, String destination ){
		output.saveFile(set, destination);
	}
	
	/**
	 * Writes ranks to the set of {@link Competition} objects
	 * @param set - set to be ranked
	 */
	private static void setRank(Set<Competitor> set){
		
		/* Copy set into new ArrayList (easier access with index of an element) */
		ArrayList <Competitor> standings = new ArrayList <Competitor>();
		standings.addAll(set);
		
		System.out.println("\nTotal number of athletes: " + standings.size());
		
		//avoiding null size of list (IndexOutOfBoundsException)
		if ( standings.size()>0){
		standings.get(0).setPlace(1);
		}
		
		/* giving the same place for equal scores */
		/* if scores are different - set the index */
		
		for (int i=1; i < standings.size(); i++){
			if(standings.get(i).getMan().getScore() == standings.get(i-1).getMan().getScore() )
			{
				standings.get(i).setPlace(standings.get(i-1).getPlace());
			}		
			else standings.get(i).setPlace(i+1);
		}	
		standings.clear();
	}
	
	/**
	 * Start point for the program. Interacts with user and 
	 * calls IO interfaces <b>{@link Input}</b> and <b>{@link IOutput}</b>
	 *<br>
	 * User Interface is a set of loops, asking for an input and saving options,
	 * chjsen by the user.
	 * <br><br> Only one competition at a time!
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner scanner = null;	
		
		try{	
			//stream enabling
			InputStream inp = System.in;
			scanner = new Scanner(inp);
			
			String input, output;	// for user choice of I/O options
			String destCSV = "decathlon.txt";	// file output defaults
			String destXML = "decathlon.xml";
			String destHTML = "decathlon.html";
		
			boolean quitOn = false, 	// quit from a program flag
					csvEnabled = false, // boolean flags for remembering output options
					xmlEnabled = false, 
					htmlEnabled = false, 
					screenEnabled = false;
			
			List<Athlete> athletes = new ArrayList<Athlete>();
					
			System.out.println( "**************** DECATHLON ****************");			
			System.out.println( "Choose where to take the input from:");
			System.out.println("(1)CSV file \n(2)Database \n(3)Manual input \n(q)Quit");
	
		while(true)	{	//select input and output options loop
	
			//---------- USER INTERFACE -----------------
			while(true){ // input select loop
				
				System.out.println( "Choice:");	
				input = scanner.next();
				
				//simple input validation
				if (input.equals("1") || input.equals("2") || input.equals("3"))	
					break; //saving input choice
				if (input.equals("q")) {
					quitOn = true;
					break;
				}  
				else System.out.println("Wrong Command!"); 
				}
			if(quitOn) break;	// program quit
				
			System.out.println( "Choose where to output results:");	
			System.out.println("(1)CSV file \n(2)XML file \n(3)HTML file \n(4)Screen \n(q)Quit");	
			
			// output select loop
			do{	
				//single choice loop (with validation)
				while(true){ 
					System.out.println( "Choice:");	
					output = scanner.next();
					//scanning the choice
					if (output.equals("1")){
						System.out.println( "Enter the file name or path (define the format yourself):");
						destCSV = scanner.next();
						csvEnabled = true;
						break;
					}
					if (output.equals("2")){
						System.out.println( "Enter the file name or path (define the format yourself):");
						destXML = scanner.next();
						xmlEnabled = true;
						break;
					}
					if (output.equals("3")){
						System.out.println( "Enter the file name or path (define the format yourself):");
						destHTML= scanner.next();
						htmlEnabled = true;
						break;
					}
					if (output.equals("4")){
						screenEnabled = true;
						break;
					}
					if (output.equals("q")){
						quitOn = true;
						break;
					}
					//simple input validation
					else System.out.println("Wrong Command!");
					} 
				if(quitOn) break; // quit from loop
				
				// user selects additional output destination
				System.out.println( "Else output? (y/n)");	
				String ans = scanner.next();
				if(ans.equals("n")) break;
				if(ans.equals("y"))	continue;
				else  System.out.println("Wrong answer!");	
			} while (true);
			
			/* if no output chosen and quit enabled -> quit from the program */
			if( quitOn && (!(csvEnabled | xmlEnabled | htmlEnabled | screenEnabled)) ) break;
			
			System.out.println( "\n-------- OK. CHOICE IS DONE ---------\n");
			
			
			//---------- INPUT INTERFACE -----------------
			if(input.equals("1")){
				//read from CSV file
				athletes = getData(new FileInput());
			}
			if(input.equals("2")){
				//read from database
				athletes = getData(new DataBaseInput());
			}
			if(input.equals("3")){
				//read from keyboard
				athletes = getData(new KeyboardInput());
			}
			
				
			//---------- WORKING WITH DATA -----------------
			
			// sorting
			Collections.sort(athletes);
			
			// duplicate removing
			Set<Competitor> competitors = new TreeSet<Competitor>();
			
			//adding using constructor: Competitor(Athlete object)
			for (int i=0; i < athletes.size(); i++){
				competitors.add( new Competitor(athletes.get(i)));
			}
		
			// ranking
			setRank(competitors);
			
			
			//---------- OUTPUT INTERFACE -----------------
			if (screenEnabled) 
			{	//output to the screen
				System.out.println( "\n-------- Standings Sorted. No Duplications ---------\n");
				Iterator<Competitor> it = competitors.iterator();  
				while (it.hasNext()) { 
					System.out.println( it.next().asString());	
				}
				screenEnabled = false;
			}
			if(csvEnabled){
				//output to the CSV file
				saveTo(new CsvOutput(), competitors, destCSV);
				System.out.println( "\n------- CSV File saved -------");
				csvEnabled = false;
			}
			if(xmlEnabled){	
				//output to the XML file
				saveTo(new XmlOutput(), competitors, (destXML + ".xml"));
				System.out.println( "\n------- XML File saved -------");
				xmlEnabled = false;
			}
			if(htmlEnabled){
				//output to the HTML file
				saveTo(new HtmlOutput(), competitors, (destHTML + ".html"));
				System.out.println( "\n------- HTML File saved -------");
				htmlEnabled = false;
			}
			//if all output done -> quit 
			if(!(csvEnabled | xmlEnabled | htmlEnabled | screenEnabled)) break;
		
		}
			System.out.println( "\n**************** END ****************\n");			
		}
		//Exception handling
		catch(NullPointerException e){
			System.out.println( "NULL was read as input!");
		}
		catch(NoSuchElementException e){
			System.out.println( "Cannot read an element!");
		}
		finally{	
			if (scanner != null) {
				scanner.close();	//stream closing
			}
		}
	}
								
}
	






