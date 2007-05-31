package net.azib.java.students.t030656.homework;

import java.util.Scanner;

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
	
	static Competition readFromScreen(){
		Competition comp = new Competition();
		Scanner kbdIn = new Scanner(System.in);
		
		System.out.print("Enter the competition name: ");  
		comp.setName(kbdIn.nextLine());
		
		boolean b = true;
		while(b)
		{
			System.out.print("Enter the participant name: ");
			String pName = kbdIn.nextLine();
			
			System.out.print("Enter the participants date of birth (dd.mm.yyyy): ");
			String pDoB = kbdIn.nextLine();
			
			System.out.print("Enter the participants country (2 letter code): ");
			String pCountry = kbdIn.nextLine();
			
			kbdIn.useDelimiter(",");
			System.out.print("Enter the participants results.\n " +
					"delimiter results with coma (,). Coma should represented as dot (.) \n " +
					"like: 12.24,123.3: ");
			double[] arrResult = new double[10];
			
			for(int i=0; i < 10; i++){
				arrResult[i] = kbdIn.nextDouble();
			}
			
			comp.addParticipant(new Participant(pName, pCountry, pDoB, arrResult));
			
			System.out.print("Insert another participant \n" +
					"[1] Yes\n" +
					"[2] No\n " +
					": ");
			if(kbdIn.nextInt() != 1){
				b = false;
			}
			
		}
		return comp;
	}
}
