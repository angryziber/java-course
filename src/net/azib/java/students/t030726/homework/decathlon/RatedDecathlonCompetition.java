package decathlon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

/**
 * A class, that contains a list of DecathlonChampionship objects and has the ability to sort them and assign places.
 * @author Deniss Nikiforov
 *
 */
public class RatedDecathlonCompetition {
	private ArrayList rawResults = new ArrayList(); //These are the incomming DecathlonChampionships
	private int maxIndex = 0; //Maximum array index
	private int currentIndex = 0;
	private DecathlonChampionship[] sortedList = null; //This is the sorted list (sorting done by comparing the score)
	private DecathlonChampionship previousChampionship = null; //Saving previous championship to compare the score when assigning places
	private int currentPosition = 1;
	private boolean isSorted = false; //Sorting flag
	
	/**
	 * This is a dynamic result adding to this class for further computations
	 * @param result
	 */
	public void addRawResult(DecathlonChampionship result) {
		if(result != null) {
			this.rawResults.add(result);
		}	
	}
	
	/**
	 * The quantity of DecathlonChampionship objects stored
	 * @return
	 */
	public int length() {
		return this.rawResults.size();
	}
	
	/**
	 * Sorting the array. The sort is done backwards, to get the highest score at the top
	 * @param unsortedResults
	 * @return
	 */
	private DecathlonChampionship[] sort(ArrayList unsortedResults) {
		DecathlonChampionship[] results = new DecathlonChampionship[unsortedResults.size()]; 
		int counter = 0;
		for (Iterator it = unsortedResults.iterator(); it.hasNext(); ) {
			results[counter] = (DecathlonChampionship)it.next();
			counter++;
		}
		Arrays.sort(results, Collections.reverseOrder());
		return results;
	}
	
	/**
	 * Sorts the array and initializes needed variable for the hasNext and getNext functions to work. (Called automatically)
	 */
	private void prepareData() {
		if(!this.isSorted) {
			this.sortedList = this.sort(this.rawResults);
			this.maxIndex = this.sortedList.length;
			this.currentIndex = 0;
			this.isSorted = true;
		}
		return;
	}
	
	/**
	 * Checks whether we have extra elements available for reading
	 * @return
	 */
	public boolean hasNext() {
		this.prepareData();
		if(this.currentIndex < this.maxIndex) {
			return true;
		}
		return false;
	}
	
	/**
	 * Calculates the score of the previous item retrieved by getNext (for comparison reasons). If the score is the same
	 * we will put an equal sign instead of a place number.
	 * @return
	 */
	private int getPreviousScore() {
		int result = 0;
		if(this.previousChampionship != null) {
			try {
				result = this.previousChampionship.getPoints();
			} catch (Exception e) {
				//Do nothing, we just return 0
			}
		}
		return result;
	}
	
	/**
	 * Retrieves the DecathlonChampionship object. That object already has the place property initialized.
	 * @return
	 * @throws Exception
	 */
	public DecathlonChampionship getNext() throws Exception {
		this.prepareData();
		int previousScore = this.getPreviousScore();
		DecathlonChampionship out = this.sortedList[this.currentIndex];
		int currentScore = out.getPoints();
		if(previousScore == currentScore) {
			//This person is also on the same place
			out.setPosition("=");
		} else {
			out.setPosition(String.valueOf(this.currentPosition));
			this.currentPosition++;
		}
		
		this.currentIndex++;
		this.previousChampionship = out;
		return out;
	}
	
}
