package net.azib.java.students.t040750.homework.lesson3;

import net.azib.java.students.t040750.homework.lesson3.DuplicateRemoverImpl;;

/**
 * CollectionsMaster
 *
 * @author karpo
 */
public class CollectionsMaster{
	public static void main(String[] args) {
		
		String[] array = new String[10];
		
		array[0] = "Täna "; 
		array[1] = "on ";
		array[2] = "võrratult ";
		array[3] = "võrratult ";
		array[4] = "ilus ";
		array[5] = "on ";
		array[6] = "Täna ";
		array[7] = "päev!";
		array[8] = "ilus ";
		array[9] = "võrratult ";
			
		DuplicateRemoverImpl remDuplicate = new DuplicateRemoverImpl();
		
		System.out.println(remDuplicate.removeDuplicateStrings(array));
	}
}
