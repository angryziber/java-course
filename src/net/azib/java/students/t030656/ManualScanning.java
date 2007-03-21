package net.azib.java.students.t030656;

import java.io.InputStream;
import java.text.ChoiceFormat;
import java.util.Scanner;

/**
 * ManualScanning
 *
 * @author t030656
 */
public class ManualScanning {
	public static void main(String[] args) {
		InputStream in = System.in;
		
		Scanner scanner = new Scanner(in);
		
		System.out.println("Vana sa oled?");
		int age = scanner.nextInt(); 
		
		ChoiceFormat cf = new ChoiceFormat(new double[]{10, 20, 40}, 
				new String[]{"Tere laps!", "Tere noormees!", "Tere härra!"});
		System.out.println(cf.format(age));
	}
}
