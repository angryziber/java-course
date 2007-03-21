package net.azib.java.students.t030656;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ChoiceFormat;

/**
 * Scanning
 *
 * @author t030656
 */
public class Scanning {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		InputStream in = System.in;
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		System.out.println("Vana sa oled?");
		String line = reader.readLine();
		int age = Integer.parseInt(line);
		
		ChoiceFormat cf = new ChoiceFormat(new double[]{10, 20, 40}, 
				new String[]{"Tere poiss!", "Tere noormees!", "Tere härra!"});
		System.out.println(cf.format(age));
	}

}
