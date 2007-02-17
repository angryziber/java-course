package net.azib.java.students.t020544;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * GetDataFromUser
 * 
 * @author Julija Kondratjeva
 */
public class GetDataFromUser {

		 
	public int getNumberFromUser() throws Exception, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("For what number do You want to know the answer?");
		int userNumber = Integer.parseInt(in.readLine());
		return userNumber;
	}

	

}
