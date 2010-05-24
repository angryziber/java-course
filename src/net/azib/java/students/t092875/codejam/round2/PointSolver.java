package net.azib.java.students.t092875.codejam.round2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * SnapperSolver
 *
 * @author Mihhail
 */
public class PointSolver {
	public static void main(String[] args) throws IOException {
		File parent = new File(new File(".."), "java");
		File source = new File(parent, "A-large(2).in");
		LineNumberReader reader = new LineNumberReader(new FileReader(source));
		
		File distination = new File(parent, "A-small.out");
		BufferedWriter writer = new BufferedWriter(new FileWriter(distination));
		String line;
		line = reader.readLine();
		Integer nTestCases = new Integer(line);
		for(int i=1; i <= nTestCases; i++){
			int lines = new Integer(reader.readLine());
			int result = 0;
			List<Double> cooficents = new ArrayList<Double>();
			List<Integer> floors1 = new ArrayList<Integer>(); 
			List<Integer> floors2 = new ArrayList<Integer>(); 
			for(int j=0; j<lines; j++){
				String[] floors = reader.readLine().split(" ");
				Double cooficent = new Double(floors[0])/new Double(floors[1]);
				floors1.add(new Integer(floors[0]));
				floors2.add(new Integer(floors[1]));
				if(!cooficents.contains(cooficent)){
					result += howMany(floors1,floors2,new Integer(floors[0]),new Integer(floors[1]));
				}else{
					result += cooficents.size()-1;
				}
				cooficents.add(cooficent);
			}
			System.out.println("Case #"+i+": "+result);
		}
		System.out.println("DONE!!!");
		reader.close();
		writer.close(); 
	}
	
	public static int howMany(List<Integer> floors1,List<Integer> floors2,int A, int B){
		int howMany = 0;
		for (Integer integer : floors1) {
			if(integer>A && floors2.get(howMany)<B || integer<A && floors2.get(howMany)>B){
				howMany++;
			}
		}
		return howMany;
	}
	
	public static int howMany2(List<Double> cooficents, Double cooficent){
		int howMany = 0;
		for (Double double1 : cooficents) {
			if(double1 == cooficent){
				howMany++;
			}
		}
		return howMany;
	}
}
