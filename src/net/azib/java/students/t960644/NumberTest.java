package net.azib.java.students.t960644;

//import java.math.BigDecimal;

/**
 * NumberTest
 *
 * @author t960644
 */
public class NumberTest {
	static int b;
	static final String HELLO = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
/*		Dog dog;
		dog = new Dog();
		NumberTest.b = 7;
		boolean b1 = b==7;
		Boolean b2 = new Boolean(false);
		char c = '大';
		BigDecimal db = new BigDecimal("2000.146878790878");
		BigDecimal db2 = BigDecimal.TEN;
		System.out.println(db.add(db2));
		byte[] b = new byte[] {4,10,20};
		System.out.println();*/
		Animal d = new Dog("Nupi",(byte)5);
		System.out.println(d.getName());
		System.out.println(d.getAge());
		
	}

}

