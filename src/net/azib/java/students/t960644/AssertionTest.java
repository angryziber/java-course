package net.azib.java.students.t960644;

/**
 * AssertionTest
 *
 * @author t960644
 */
public class AssertionTest {

	public static void doSmth(Object ... ints) {
		for (Object value : ints){			
			System.out.println(value+" "+value.getClass().toString() );
		}
	}
	public static void main(String ... args) {
		// TODO Auto-generated method stub
		assert args.length >= 1: "Not enough parameters";
//		System.out.printf("Parameters: %s %s",args[0],args[1]);
		doSmth(1,"tere",14.4);
	}

}
