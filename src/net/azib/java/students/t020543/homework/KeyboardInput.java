package decathlon;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * A class, which holds methods for manual input
 * @author t020543
 */
public class KeyboardInput implements Input{
	
	/**
	 * Calls method {@link #calculatePoints(IAthlete)} of {@link IPointCalculator}
	 * @param calculator - {@link IPointCalculator} interface
	 * @param man - {@link IAthlete} interface
	 */
	private int calculatePoints(IPointCalculator calculator, Athlete man){
		return calculator.calculatePoints(man);
	}
	/**
	 * Calls {@link #checkNegative(Athlete)} method of {@link IDataValidation} class
	 * @param check - {@link IDataValidation} interface
	 * @param man - {@link IAthlete} interface
	 */
	private boolean checkNegative(IDataValidation check, double input){
		return check.checkNegative(input);
	}
	
	/**
	 * Calls {@link #checkWorldRecord(Athlete)} method of {@link IDataValidation} class
	 * @param check - {@link IDataValidation} interface
	 * @param man - {@link IAthlete} interface
	 */
	private static boolean checkWorldRecord(IDataValidation checker, Athlete man){
		return checker.checkWorldRecord(man);
	}
	
	public List<Athlete> getData(){
		
		//set Locale to US, to have point "." as a decimal separator
		Locale.setDefault(Locale.US);
		Scanner scanner = null;
		
		try {		
			//stream creation
			InputStream in = System.in;
			scanner = new Scanner(in);
			
			List<Athlete> competitors = new ArrayList<Athlete>();
			
			while (true){ //loop for adding new athletes to the list
				
				System.out.println("Add athlete? (y/n)");
				String command = scanner.next();
				
				if (command.equals("y")) {
						
					IAthlete man = new Athlete();	
					competitors.add((Athlete)man);
					
					try {
						System.out.println("Name:");			
						String s = "\"" + scanner.next();
					 
						// loop to add all names of the athlete (one or more)
						while (true){
							System.out.println("Other names? (y/n)");
							String ans = scanner.next();
					
							if (ans.equals("y")){	
								System.out.println("Name:");			
								s = s + " " + scanner.next();
							}
							if (ans.equals("n"))break;
						}
						man.setName(s + "\""); 

						System.out.println("Birthday:");
						man.setBirthday(scanner.next());
							
						System.out.println("Country:");
						man.setCountry(scanner.next());
						
						
						double input;
						IDataValidation check = new DataValidation(); //DataValidation instance
						
						//array of possible event notes
						String [] frase = new String [] {
								"Sprint 100m (sec.msec):", 	"Long Jump(m.cm):",
								"Shot Put(m.cm):",	"High Jump(m.cm):", 
								"Sprint 400 m: \nmin: ", "Hurdles 110m (sec.msec):",
								"Discus Throw(m.cm):", "Pole Vault(m.cm):",
								"Javelin Throw(m.cm):","Race 1500 m: \nmin: " };
						
						//loop of adding event results 
						for (int i = 0; i<10; i++){
							if ((i == 4) || (i == 9) ) {
								
								/*Sprint 400m and Race 1500m*/
								while(true){
								System.out.println(frase[i]); 	// prints needed frase
								int min = scanner.nextInt();	// scans minutes
								System.out.println("sec.msec:");
								input = (60*min) + scanner.nextDouble(); //calculates value
									
									/*check for being negative*/
									if (!checkNegative(check,input)){
										man.set(i,input);	//if OK sets a value
										break;
									}
									else System.out.println("Input cannot be negative!");
								}
							}
							/* all other events*/
							else {
								while(true){
								System.out.println(frase[i]);	// prints needed frase
								input =	scanner.nextDouble();	//scans value
									
									/*check for being negative*/
									if (!checkNegative(check,input)){
										man.set(i, input);		//if OK sets a value
										break;
									}
									else System.out.println("Input cannot be negative!");
								}
							}
						}
						
						//calculating athlete's points	
						man.setScore(calculatePoints(new PointCalculator(), (Athlete)man ));	
						System.out.println("\nScore : " + man.getScore());
						
						//compare input with World Record 
						if(  checkWorldRecord(check, (Athlete)man) ) 
						{
							//if true - warn user
							System.out.println("Warning! Some input is greater than or equal to the World Record!");
							
							//Handling user's reaction on warning 
							System.out.println("Remove an athlete?(y/n)");
							while(true){
								String ans = scanner.next();
								if(ans.equals("n")) break;
								if(ans.equals("y"))	{
									competitors.remove(man);
									break;
								}
								else  System.out.println("Wrong answer!");	
							}
						}
					}
					catch (InputMismatchException e){
						System.out.println("Wrong input type. Use dot (\".\") as a decimal seperator.");
						competitors.remove(man); // delete object with wrong input
						continue;
					}		
				} //if
				
				if (command.equals("n"))break;		
		} //while
			
			return competitors;
	}//try
		finally {
			if (scanner != null) {				
				scanner.close(); //stream closing
			}
		}		
	}
}
