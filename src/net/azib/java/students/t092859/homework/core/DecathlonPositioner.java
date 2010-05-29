package net.azib.java.students.t092859.homework.core;

import net.azib.java.students.t092859.homework.input.DecathlonResultFetcher;
import net.azib.java.students.t092859.homework.output.DecathlonResultWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * DecathlonPositioner
 * Fetches decathlon competition results,
 * calculates scores(points) of the results,
 * sorts results by score, calculates places,
 * outputs sorted results.
 *
 * @author konstantin
 */
public class DecathlonPositioner {
	
	DecathlonResultFetcher fetcher;
	DecathlonResultWriter writer;
	
	/**Creates instance of DecathlonPositioner with
	 * specified fetcher and writer. Does not
	 * compute or sort results.
	 * 
	 * @param fetcher - DecathlonResultFetcher instance that
	 * provides decathlon results
	 * @param writer - DecathlonResultWriter instance that
	 * outputs sorted results with calculated points 
	 */
	public DecathlonPositioner(DecathlonResultFetcher fetcher, DecathlonResultWriter writer) {
		this.fetcher = fetcher;
		this.writer = writer;
	}
	
	/**
	 * Performs results processing: calculates scores
	 * sorts results by score, assigns places
	 */
	public void processResults()
	{
		List<DecathlonResult> results;
		try {
			results = new LinkedList<DecathlonResult>(fetcher.fetchResults());
		}
		catch (Exception e) { //if any exception flew out, then probably there was a fatal error when fetching results
			System.err.println("Fatal error occured while fetching results. Cannot continue");
			e.printStackTrace();
			return;
		}
		
		Collections.sort(results, new Comparator<DecathlonResult>(){
			@Override
			/*
			 * Note: this comparator imposes orderings that are inconsistent with equals
			 */
			public int compare(DecathlonResult arg0, DecathlonResult arg1) {
				return -(new Integer(arg0.getPoints()).compareTo(new Integer(arg1.getPoints())));
		}});
		
		List<String> places = new LinkedList<String>();
		
		int currentPlace = 1;
		places.add(0,"1"); //first place is always there
		for(int i = 1; i < results.size(); i++){
			if(results.get(i).getPoints() != results.get(i-1).getPoints()) {
				if(currentPlace == 2 && i > 2) {
					for(int j = 1; j < i; j++)
						places.add(j, "2-" + i);
				}
				currentPlace++;
			}
			places.add(i, ((Integer)currentPlace).toString());
		}
		
		if(results.size() == 0)
			System.out.println("No results to write");
		else
			writer.writeResults(results, places);
	}
	
}
