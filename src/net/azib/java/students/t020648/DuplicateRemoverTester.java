package net.azib.java.students.t020648;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DuplicateRemoverTester {

	public static void main(String [] args){
		
		String [] arrayOfStrings = {"a", "z", "b", "u", "z"};
		DuplicateRemover remover = new DuplicateRemoverImpl();
		String [] result = remover.removeDuplicateStrings(arrayOfStrings);
				
		for(int i=0;i<result.length;i++){
			System.out.println(result[i]);
		}
	}	
}
