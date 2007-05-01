package net.azib.java.students.t011861;
import java.util.HashSet;
import java.util.Set;
/**
 * SetLearning
 *
 * @author t011861
 */
public class SetLearning {
	public static void main(String[] args) {
		Set set = new HashSet();
		set.add("a");
		set.add("b");
		set.add("z");
		set.add("x");
		
		for (Object e : set) {
			System.out.println(e);
		}
	}
}
