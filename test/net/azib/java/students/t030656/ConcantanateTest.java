package net.azib.java.students.t030656;

/**
 * ConcantanateTest
 *
 * @author t030656
 */
public class ConcantanateTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Concantenator con = new Concantenator();
		assert "abc123".equals(con.concanate("abc", "123")) :"concat() failed!";

	}

}
