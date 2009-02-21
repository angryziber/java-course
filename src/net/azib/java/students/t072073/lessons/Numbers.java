package net.azib.java.students.t072073.lessons;

import java.math.BigInteger;

/**
 * Numbers
 *
 * @author janika
 */
public class Numbers {
	// ei ole hea mote kasutada floati, sest t2psus kaob 2ra.
	//parem variant: rahasummasid saab esitada sentidena
	public static void main(String[] args) {
		double f = 1.0;
		f -= 0.9;
		System.out.println(f);
		
		if (f <= 0.1){
			System.out.println("Saab osta!");
		}
		/*primitiivtüüpidel on wrapper klassid, kus on 
		olemas abimeetodi ja konstandid, mida saab kasutada.
		Wrapper-klasse ei tasu kasutada primitiibtüüpide asemel,
		sest v6tavad rohkem m2lu.
		vt. ka Autoboxing - automaatne omistamine?
		*/ 
		Integer o = new Integer("5");
		System.out.println(o.intValue());
		
		BigInteger i = new BigInteger("2000123456788999990000001");
		i.add(BigInteger.ONE); //ei omista i-le uut v22rtust
		i = i.add(BigInteger.ONE); //nyyd omistame
		System.out.println(i);
	}
}
