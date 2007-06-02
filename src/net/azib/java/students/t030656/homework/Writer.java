package net.azib.java.students.t030656.homework;


/**
 * Writer
 *
 * @author Sprot
 */
public class Writer {

	/**
	 * 
	 */
	public Writer() {
	}
	
	public static void writeToScreen(Competition comp){
		System.out.println("Competition: " + comp.getName());
		System.out.println("Participants:");
		for(Participant p : comp.getParticipants()){
			System.out.print(p.getName() + "\t" +
				p.getCountry() + "\t" + 
				p.getDateOfBirth() + ":\n\t");
			for(String str : p.getStrResults()){
				System.out.print(str +"\t");
			}
		}
	}
}
