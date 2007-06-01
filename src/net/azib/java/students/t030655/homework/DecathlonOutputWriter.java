package net.azib.java.students.t030655.homework;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.PriorityQueue;

/**
 * DecathlonOutputWriter
 *
 * @author Triin Nestor
 */
public class DecathlonOutputWriter {
	
	private PriorityQueue<Competitor> competitionResults (PriorityQueue<Competitor> competitorsQueue){
		PriorityQueue<Competitor> compQueue = new PriorityQueue<Competitor>(competitorsQueue);
		int l = compQueue.size();	//number of competitors in PriorityQueue
		int[] masPoints = new int[l];	//array for points
		String[] masPlaces = new String[l];	//array for places
		Competitor competitor = null;
		int m = 0;	//iterator
		//competitors' points to array of points
		while ((competitor = compQueue.poll())!= null){
			masPoints[m] = competitor.getTotalPoints();
			m++;
		}
		//scanning points to find place-sharing
		int j=0;
		int count=0;
		int k =0;
		for (int i = 0; i < l; ){
			j = i + 1;	//i and j are iterators
			count = 0;	//counter to count the number of same points
			//counting the number of same points
			while ((j<l) && (masPoints[i] == masPoints[j])){
				count++;
				j++;
			}
			k = i;
			//inserting correct places to masPlaces
			if (k == (j-1)){
				masPlaces[k] =(i + 1) + ". ";
			}
			else{
				for ( ; k<j; k++){
					masPlaces[k] = (i + 1) + "-" + (i + 1 + count) + ". ";
				}
			}
			if (count == 0){
				i= i + 1;
			}
			else{
				i = i + 1 + count;
			}
			
		}
		//inserting places into competitors and making new PriorityQueue 
		PriorityQueue<Competitor> pq = new PriorityQueue<Competitor>(competitorsQueue);
		PriorityQueue<Competitor> placeQueue = new PriorityQueue<Competitor>();
		Competitor comp = null;
		int p = 0;
		while ((comp = pq.poll())!= null){
			comp.setPlace(masPlaces[p]);
			placeQueue.add(comp);
			p++;
		}
		return placeQueue;
	}
	
	public void writeToConsole (PriorityQueue<Competitor> pq){
		PriorityQueue<Competitor> compQueue = new PriorityQueue<Competitor>(pq);
		DecathlonOutputWriter placeWriter = new DecathlonOutputWriter();	// MIGHT BE IN MAIN()
		compQueue = placeWriter.competitionResults(compQueue);		//MIGHT BE IN MAIN()
		Competitor comp = null;
		while ((comp = compQueue.poll()) != null){
			System.out.println(comp.getPlace() + comp.getTotalPoints() + " points - " + comp.getName() + ", " + comp.getDateOfBirth() + ", " + comp.getCountry());
			double[] results = new double[10];
			results = comp.getResults();
			System.out.print("Results:");
			for (int i=0; i<10; i++){
				System.out.print("  " + results[i]);	
			}
			System.out.println("\n");
		}
		
	}
	
	public void writeToFile (String filename, PriorityQueue<Competitor> pq){
		PriorityQueue<Competitor> compQueue = new PriorityQueue<Competitor>(pq);
		DecathlonOutputWriter placeWriter = new DecathlonOutputWriter();	// MIGHT BE IN MAIN()
		compQueue = placeWriter.competitionResults(compQueue);		//MIGHT BE IN MAIN()
		try {
			FileOutputStream out = new FileOutputStream(filename);
			PrintStream printStream = new PrintStream(out, true, "UTF-8");
			for (Competitor comp : compQueue){
				printStream.println(comp.getString());
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("Unable to write to file!");
			e.printStackTrace();
		}
		catch (UnsupportedEncodingException e) {
			System.out.println("Encoding not supported!");
			e.printStackTrace();
		}

	}
	
	public void writeToXml (String filename, PriorityQueue<Competitor> pq){
		
	}
	
	public void writeToHtml (PriorityQueue<Competitor> pq){
		
	}

}
