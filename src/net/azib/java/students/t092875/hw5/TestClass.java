package net.azib.java.students.t092875.hw5;

/**
 * TestClass
 *
 * @author Mihhail
 */
public class TestClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = {1000,1,20,3,4,5};
		System.out.println(findmax(a));
	}
	
	public static int findmax(int[] i){
		int j=0;
		for(int z=0; z<i.length; z++){
			if(i[z]>i[j]){
				j = z;
			}
		}
		return j;
	}

}
