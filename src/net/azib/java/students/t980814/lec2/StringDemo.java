package net.azib.java.students.t980814.lec2;

/**
 * StringDemo
 *
 * @author t980814
 */
public class StringDemo {
	public static void main(String[] args) {
		String s1 = "sa";
		String s2 = "s";
		
		s2 += "a";
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));

// String sees on char[] massiiv ja start ja length parameetrid.
//   start ja length ei pruugi olla char[] otsmised väärtused
// Kui tehakse uus string, mis on eelmise Stringi substring, siis
// kasutatakse sama mäluvälja char[] ja muudetakse lihtsalt
// start ja length parameetreid.
	
		
		String s = "";
		for(int i = 1; i <= 10; i++) {
			s += i + " ";
			// väga ebaefektiivne suurte korduste korral, kuna igal iteratsioonil
			// luuakse 2 uut objekti (StringBuilder ja String)
			// Allpool on parem lahendus kasutades StringBuilder-it
		}
		System.out.println(s);
		
		StringBuilder sb = new StringBuilder("");
		for(int i = 1; i <= 10; i++) {
			sb.append(i).append(' ');
		}
		System.out.println(sb.toString());
	
		
	}
}
