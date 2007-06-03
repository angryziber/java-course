package decathlon;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

/**
 * A class holds methode needed for transforming CSV string 
 * into values of the {@link Athlete} class members. 
 * @author t020543
 */
public class StringConvertor implements IStringConvertor {
		
	/**
	 * Calls {@link PointCalculator} method {@link #calculatePoints(IAthlete)}
	 * <br> using {@link IPointCalculator} interface
	 * @param calculator - {@link IPointCalculator} interface
	 * @param man - {@link IAthlete} interface
	 */
	private int calculatePoints (IPointCalculator calculator, IAthlete man){
		return calculator.calculatePoints(man);
	}
	
	/**
	 * Converts string input into <b>double</b> value
	 * @param data - String to be converted
	 * @return  number(double)
	 * @throws IOException
	 * @throws InputMismatchException
	 */
	private double toDouble(String data)throws IOException, InputMismatchException{
		
		Scanner scan = null;	// creating scanner
		
		try{
			scan = new Scanner(data);
			return  scan.nextDouble();
		}
		finally {	if (scan != null) {
						scan.close(); // closing scanner
					}
				}
		}	
	
	/**
	 * Transforms string, which looks like  "x:xx.xx" or "xx.xx" into double value
	 * @param data - String to be converted
	 * @return <b>double</b> value
	 * @throws IOException
	 * @throws InputMismatchException
	 * @throws RuntimeException
	 */
	private double toSec(String data) throws IOException, InputMismatchException, RuntimeException {
		
		Scanner scan = null;	// creating scanner
		try {
			//looking for ":" delimiter
			if (data.contains(":"))
			{
				scan = new Scanner(data).useDelimiter(":\\s*");
				/*
					In CSV file number before ":" means minutes
					Converting to seconds using toDouble(String method)
				*/
				return 60 * scan.nextInt() + toDouble(scan.next());
			}
			else return toDouble(data); 
			}
			finally {	
					if (scan != null) {
						scan.close();	// closing scanner
						}
			}
		}
	
	@Override
	public Athlete toAthlete(String input, IAthlete man) {
		
		//set Locale to US, to have point "." as a decimal separator
		Locale.setDefault(Locale.US); 
		
		//scanner uses coma "," as a delimiter
		Scanner scan = new Scanner(input).useDelimiter(",\\s*");
		try{
					
			//scanning input
			while (scan.hasNext())
			{					
			//Reading value between comas, writing to Athlete object
			man.setName(scan.next());
			man.setBirthday(scan.next());
			man.setCountry(scan.next());	
			
			man.setSprint100(scan.nextDouble());
			man.setLongJump(scan.nextDouble());
			man.setShotPut(scan.nextDouble());		
			man.setHighJump(scan.nextDouble());
			man.setSprint400(toSec(scan.next()));	// making transformations, if needed 
			man.setHurdles110(scan.nextDouble());
			man.setDiscusThrow(scan.nextDouble());;
			man.setPoleVault(scan.nextDouble());
			man.setJavelinThrow(scan.nextDouble());
			man.setRace1500(toSec(scan.next()));	// making transformations, if needed
		
			man.setScore(calculatePoints(new PointCalculator(), man));			
			}
			return (Athlete)man;
		}
		//Exception handling
		catch (IOException e){
			System.out.println("ERROR! Unable to read data!");
			return null;
		}
		catch (InputMismatchException e){
			System.out.println("Wrong data type! Check the source file!");
			return null;
		}		
		finally {
			scan.close();		// closing scanner
		}
	}
}	 
	
	

