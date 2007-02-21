package net.azib.java.students.t020556;

/**
 * <b>DuplicateRemoverImplTest</b> tests the DuplicateRemoverImpl class
 *
 * @author t020556
 */
public class DuplicateRemoverImplTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DuplicateRemoverImpl dri = new DuplicateRemoverImpl();
		String[] strs = {"tere", "hehe", "tere", "haha"};
		String[] strs2 = dri.removeDuplicateStrings(strs);

		System.out.println("strs were first:");
		for(String str : strs){
			System.out.println(str);
		}
		System.out.println();
		
		System.out.println("strs are now:");
		for(String str : strs2){
			System.out.println(str);
		}
	}
}
