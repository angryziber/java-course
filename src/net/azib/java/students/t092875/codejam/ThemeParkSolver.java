package net.azib.java.students.t092875.codejam;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.LinkedList;
import java.util.Queue;

import junit.framework.TestCase;

/**
 * ThemeParkSolver
 *
 * @author Mihhail
 */
public class ThemeParkSolver {
	public static void main(String[] args) throws IOException {
		File parent = new File(new File(".."), "java");
		File source = new File(parent, "C-large.in");
		LineNumberReader reader = new LineNumberReader(new FileReader(source));
		
		File distination = new File(parent, "result.out");
		BufferedWriter writer = new BufferedWriter(new FileWriter(distination));
		
		String line = reader.readLine();
		Integer nTestCases = new Integer(line);
		
		
		for(int i=1; i <= nTestCases; i++){
			line = reader.readLine();
			String[] data = line.split(" ");
			long rides = new Long(data[0]);
			long places = new Long(data[1]);
			long queueSize = new Long(data[2]);
			Queue<Long> riders = new LinkedList<Long>();
			line = reader.readLine();
			data = line.split(" ");
			
			for(int j=0; j<queueSize; j++){
				riders.offer(new Long(data[j]));
			}
			long summ = 0;
			if(queueSize == 0){
				summ = 0;
			}else if(queueSize == 1){
				summ = riders.peek()*rides;
			}else if(getTotalSumOfRiders(riders)<=places){
				summ = getTotalSumOfRiders(riders)*rides;
			}else if(isOne(riders)){
				summ = rides*places;
			}else{
				for(int j=1; j<=rides; j++){
					int subSum = 0;
					int groupsWent = 0;
					while(subSum<=places){
						if(subSum+riders.peek()>places || groupsWent==riders.size()){
							groupsWent = 0;
							break;
						}
						long group = riders.poll();
						subSum += group;
						riders.offer(group);
						groupsWent++;
					}
					summ += subSum;
				}
			}
			
			writer.write("Case #"+i+": "+summ);
			if(i != nTestCases){
				writer.newLine();
			}
		}
		reader.close();
		writer.close();
		System.out.println("DONE!");
	}
	
	public static long getTotalSumOfRiders(Queue<Long> q){
		long sum = 0;
		for (Long long1 : q) {
			sum += long1;
		}
		return sum;
	}
	
	public static boolean isOne(Queue<Long> q){
		for (Long long1: q) {
			if(long1>1){
				return false;
			}
		}
		return true;
	}
}
