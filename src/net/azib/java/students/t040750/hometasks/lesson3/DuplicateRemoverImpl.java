package net.azib.java.students.t040750.hometasks.lesson3;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * DuplicateRemoverImpl
 *
 * @author karpo
 */
public class DuplicateRemoverImpl{ 	//kui klassi nime lõpus on Impl, siis 
									//võib implements keywordi ära jätta.
									//Eeldab, et on ainult 1 implementatsioon baasklassist

	public String[] removeDuplicateStrings(String[] array) {
		Set<String> set = new LinkedHashSet<String>(Arrays.asList(array));
		
		return set.toArray(new String[set.size()]);
	}
	
	

}
