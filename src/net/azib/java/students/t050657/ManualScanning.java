package net.azib.java.students.t050657;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ChoiceFormat;

/**
 * Scanning
 *
 * @author t050657
 */
public class ManualScanning {


	public static void main(String[] args) throws IOException {
		
		InputStream is = System.in;
		BufferedReader reader = new BufferedReader(
									new InputStreamReader(is));
		String line = reader.readLine();
		int i = Integer.parseInt(line);
		
		ChoiceFormat sf = new ChoiceFormat(
							new double[]{0,5,15,20},
							new String[]{"unborned 8)","kid","teenager","student"});
		
		System.out.println(sf.format(i));
		
	}

}
