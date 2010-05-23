package net.azib.java.students.t092875.codejam;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;

/**
 * SnapperSolver
 *
 * @author Mihhail
 */
public class SnapperSolver {
	public static void main(String[] args) throws IOException {
		File parent = new File(new File(".."), "java");
		File source = new File(parent, "A-small-attempt2.in");
		LineNumberReader reader = new LineNumberReader(new FileReader(source));
		
		File distination = new File(parent, "A-small.out");
		BufferedWriter writer = new BufferedWriter(new FileWriter(distination));
		String line;
		line = reader.readLine();
		Integer nTestCases = new Integer(line);
		for(int i=1; i <= nTestCases; i++){
			StringBuffer result = new StringBuffer("Case #"+i+": ");
			String[] lines = reader.readLine().split(" ");
			Long n = new Long(lines[0]);
			Long snaps = new Long(lines[1]);
			if(snaps==0){
				result.append("OFF");
			}else{
				long sumToLight = (long) Math.pow(2, n);
				if((snaps%sumToLight)==(sumToLight-1)){
					result.append("ON");
				}else{
					result.append("OFF");
				}	
			}
			writer.write(result.toString());
			if(i!=nTestCases){
				writer.newLine();
			}
			System.out.println(result);
		}
		reader.close();
		writer.close(); 
	}
}
