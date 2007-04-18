package net.azib.java.students.t050209.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * HandleDecathlonIO
 *
 * @author Kaupo Laan
 */
public class HandleDecathlonIO {

	public static char sportsmanName[];
	public static char dateOfBirth[];
	
	private static double run100mResult,
						  longJumpResult,
						  shotPutResult,
						  highJumpResult,
						  run400mResult,
						  run110mHurdles,
						  discusThrowResult,
						  poleVaultResult,
						  javelinThrowResult,
						  run1500mResult;
	
	public static double userResults[] = {run100mResult, 
										  longJumpResult,
										  shotPutResult,
										  highJumpResult,
										  run400mResult,
										  run110mHurdles,
										  discusThrowResult,
										  poleVaultResult,
										  javelinThrowResult,
										  run1500mResult};
	
	public static double getUserInsertedValue() throws Exception, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		double value = Double.parseDouble(in.readLine());
		return value;
	}
	
	public static int manualInsertionSequence() throws Exception, IOException {
		int overallResult = 0;
		
		//insertName
		//insertDateOfBirth
		for (int i = 0; i < 10; i++)
		{
			System.out.print("Insert result (format x.xx): ");
			userResults[i] = getUserInsertedValue();
			overallResult = overallResult + 
					        DecathlonPoints.values()[i].eventPoints(userResults[i]);
		}
		
		return overallResult;
	}	

}
