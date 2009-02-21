package net.azib.java.students.t072073.lessons;

/**
 * Varargs
 *
 * @author janika
 * 
 * @comment klassi muutujad peaksid olema private, et väljaspoolt nendele 
 * ligi ei saaks keegi.
 * default keyword - package local - klassil puudub access keyword, 
 * nagu C-s friendly, ligipääsetav paketi piires. String on immutable ehk muutumatu väärtusega.
 * StringBuilder on nagu uus versioon StringBufferist.
 */
public class Varargs {
	
	/**
	* @comment kui tüüp on Object, siis saab nii stringe või arve argumendiks anda
	*Autoboxingut kasautatakse printimisel.
	*/
	public static void printAll(Object ... params){
		for (Object s : params) {
			System.out.println(s);
		} 
	}
	public static void main(String ... args) {
		printAll("a", "b");
		printAll();
		printAll("c");
		printAll(1, 2, 3);

	}

}
