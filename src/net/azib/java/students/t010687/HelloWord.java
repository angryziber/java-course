package net.azib.java.students.t010687;

//import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


/**
 * HelloWord
 *
 * @author t010687
 */
public class HelloWord {
	static Runnable[] DoSomething = {
			new Runnable() {
				public void run() {
					System.out.println("Code nr. 1");
				}
			},
			new Runnable() {
				public void run() {
					System.out.println("Code nr. 2");
				}
			}
			};
	static int b;
	static final String HELLO = null;
	;
	
	public static void main(String[] args) {
		String z = "ar";
		String g = "aw";
		
		if (z.substring(0,1).equals(g.substring(0,1))) {
			HelloWord.b = 8;
			Dog Koir = new Dog("Pitsu");
			System.out.println(Koir.toString());
			System.out.println(Koir.equals("Pitsu"));
		}
		else {
			HelloWord.b = 8;
			Dog Koir = new Dog("Nunnu");
			System.out.println(Koir.toString());
			System.out.println(Koir.equals("Nunnu"));
		}
		
		DoSomething[0].run();
		DoSomething[1].run();
		
		//boolean z = true;
		//Boolean f = new Boolean(true);
		
		//final int opa = 7;
		//Dog dog = new Dog("Kutsa");
		//char c = 'd';
		//char d = '\u0020';
			/*	
		BigDecimal db = new BigDecimal("1.025");
		BigDecimal db2 = BigDecimal.TEN ;
		db2.add(db);
		System.out.println(db2.add(db));
		//System.out.println(dog.name);
		//System.out.println(Integer.parseInt("1AF", 16));
		//String XX = "JamaLugu";
		//System.out.println(XX);
		 
		 */

	}
}






//import java.util.ArrayList;
//import java.util.List;

/*Runnable[] DoSomething = {
		new Runnable() {
			public void run() {
				System.out.println("Code nr. 1");
			}
		},
		new Runnable() {
			public void run() {
				System.out.println("Code nr. 2");
			}
		}
		};
a[0].run();*/