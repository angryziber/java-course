package net.azib.java.students.t020632;

/**
 * TestConcate
 *
 * @author t020632
 */
public class TestConcate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Concatenator020632 c = new Concatenator020632();
		
		assert "abc123".equals(c.concate("abc", "123")) : "concate() fails";

	}

}
