package net.azib.java.students.t011861.homework;

import java.util.ArrayList;
import java.util.List;

/**
 * OutDataToScreen
 *
 * @author 011861
 */
public class OutDataToScreen {
	public void printToConsole(List<String[]> completeData) {
		List<? super String> printLine = null;
		printLine = new ArrayList<String>();
		System.out.println();
		for (String[] athleteData : completeData)
		{
			int columnNumber = athleteData.length;
			for (int k = 0; k<columnNumber; k++) 
			{	
				printLine.add(athleteData[k]);
				System.out.print(printLine.get(k).toString()+" ");
			}
			System.out.println();
			printLine.clear();	
		}
	}
}
