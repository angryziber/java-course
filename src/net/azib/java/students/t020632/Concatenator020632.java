package net.azib.java.students.t020632;

/**
 * Concatenator020632
 *
 * @author t020632
 */
public class Concatenator020632 {
		
		public String concate(String a, String b){
			
			if(a == null){
				return b;
			}
			else if(b == null){
				return a;
			}
			
			return a + b;
		}
		
}
