package net.azib.java.students.t020543.homework;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * A class, which hilds methods for reading data from database
 * @author t020543
 */
public class DataBaseInput implements Input {
	
	/**
	 * Interacts with a user, to select needed competition to work out
	 * @param list of {@link Competition} available in database
	 * @return needed competition id-number
	 */
	private static int getChoice(List<Competition> list){

		Scanner scanner = null;

		try {
				InputStream in = System.in;
				scanner = new Scanner(in);	
				int choice;
				
				System.out.println("Choose the competition:");	
				//prints out all available competitions
				for (int i=0; i < list.size(); i++){
					System.out.println(list.get(i).asString());	
				}
				while (true){
					System.out.println("Choice:");	
					// scanning integer input
					choice = scanner.nextInt();
					
					//handling enourmous input
					if ( choice > 0  && choice <= list.size()) 
						return choice;	
					else  System.out.println("Wrong input!");	
				}
		}
		//handling not-integer input
		catch (InputMismatchException e){
			System.out.println("Wrong input type! Must be a number");
			return 0;
		}
		finally {
			if (scanner != null) 
			{
				scanner.close();
			}
		}
	}
	
	public List<Athlete> getData(){
		
		List<Athlete> athletes = new ArrayList<Athlete>();
		IDataAccessor dba = new DataAccessor();
		
		try{
			/*
			 Connection to the particula database. 
			 Because only one DB available, non-interactive method was implemented.
			 (Link URL, password and login are hardcoded)
			 */
			dba.initializeConnection("jdbc:mysql://srv.azib.net:3306/decathlon?user=java&password=java");
			
			//reading competition's data from DB
			List<Competition> list = dba.makeQueryForCompetition();
			
			//receive competition id, chosen by the user
			int choice = getChoice(list); 
			
			//reading athletes' data from DB
			athletes = dba.makeQueryForAthlete(choice);
			
			//closing connection to the DB
			dba.releaseConnection();
		}
		catch (Exception e)	{
				System.out.println("Unexpected Error! Check your Internet connection!");
				dba.releaseConnection();
		}
		return athletes;
	}
}
