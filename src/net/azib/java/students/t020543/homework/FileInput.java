package decathlon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class FileInput implements Input {
	
	/**
	 * Calls {@link IStringConvertor} method {@link #toAthlete(String, IAthlete)}
	 * @param convertor - {@link IStringConvertor} interface
	 * @param input	- string input to be converted
	 * @param man	- empty {@link IAthlete} object
	 */
	private IAthlete toAthlete(IStringConvertor convertor, String input, IAthlete man){
		return convertor.toAthlete(input, man);
	}
	
	/**
	 * Calls {@link #checkAllNegative(IDataValidation, Athlete)} method of {@link IDataValidation} class
	 * @param check - {@link IDataValidation} interface
	 * @param man - {@link IAthlete} interface
	 */
	private boolean checkAllNegative(IDataValidation check, IAthlete man){
		return check.checkAllNegative(man);
	}
	
	/**
	 * Calls {@link #checkWorldRecord(IDataValidation, Athlete)} method of {@link IDataValidation} class
	 * @param check - {@link IDataValidation} interface
	 * @param man - {@link IAthlete} interface
	 */
	private static boolean checkWorldRecord(IDataValidation checker, IAthlete man){
		return checker.checkWorldRecord(man);
	}
	
	/**
	 * Interacts with a user, to read source filename or path
	 * @return file name or path
	 */
	private static String getFileName(){

	Scanner scanner = null;		//scanner initialization

		try {
			InputStream in = System.in;	//creating stream
			scanner = new Scanner(in);	
		
			System.out.println("Enter the file name (path):");
			String source = scanner.next();	//read file name or path
			return source;
		}
		finally {
			if (scanner != null) 
			{
				scanner.close();	//closing stream
			}
		}
	}	
	
	public List<Athlete> getData(){
	
		Scanner scanner = null;
		List<Athlete> athletes = new ArrayList<Athlete>();
		
		String source = getFileName();	//receive source name
	
		try {
			//input stream creation
			scanner = new Scanner(new BufferedInputStream(new FileInputStream(source)), "UTF-8");
			
			//read file loop (until EOF field)
			while (scanner.hasNext())
				{	 
					// new Athlete instance
					IAthlete man = new Athlete();
					
					//reading the CSV string and convering to values
					man = toAthlete(new StringConvertor() , scanner.nextLine(), man);	
					IDataValidation check = new DataValidation();
					
					//check input for being negative
					if(checkAllNegative(check, man)) 
					{
						//if negative - warn user and ignore data
						System.out.println("Wrong data! Input cannot be negative! Check the source file!");
						System.out.println("Input ignored.");
					}
					// if OK. adding Athlete instance to the list
					else athletes.add((Athlete)man);
					
					//check for enormous input 
					if(checkWorldRecord(check, man) ) 
					{
						//if true - warn user
						System.out.println("Warning! Input is greater than or equal to the World Record!");
					}
				}
			return athletes;
			}
		//Exception handling
		catch (IOException e){
			System.out.println("Unable to read data!");
			return athletes;
			}
		catch (NoSuchElementException e){
			System.out.println("File is empty!");
			return athletes;
		}
		finally {
				if (scanner != null) 
					{
					scanner.close();	//stream clocing
					}
			}
	}	
	
}