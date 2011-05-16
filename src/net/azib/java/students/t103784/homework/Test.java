package net.azib.java.students.t103784.homework;

/**
 * Created by IntelliJ IDEA.
 * User: Ott Madis Ozolit
 * Date: 16.05.11
 * Time: 10:27
 * To change this template use File | Settings | File Templates.
 */
public class Test {

	public static void main(String[] args) {
		int i = 0;
		Double juust = 1.5;
		double[] performance = {0,0,0,0,0,0,0,0,0,0};
		for (i = 0; i<10; i++) {
			if (i==5) {
				juust = null;
			}
			performance[i] = juust;
			System.out.println(performance);
		}
	}
}
