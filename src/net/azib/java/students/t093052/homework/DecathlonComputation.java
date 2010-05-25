package net.azib.java.students.t093052.homework;

import net.azib.java.students.t093052.homework.action.Action;
import net.azib.java.students.t093052.homework.action.ActionType;
import net.azib.java.students.t093052.homework.action.input.InputAction;
import net.azib.java.students.t093052.homework.action.input.InputActionType;
import net.azib.java.students.t093052.homework.action.output.OutputAction;
import net.azib.java.students.t093052.homework.action.output.OutputActionType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 *	The main class of program which calculates the points of decathlon. 
 *	The program receives input data from console, csv or database. 
 *	The output data can be represented in console, csv, xml or html format.
 * */
public class DecathlonComputation {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		new DecathlonComputation().run(args);
	}

	private void run(String[] args) throws Exception {
		List<String> argsList = Arrays.asList(args);
		Iterator<String> argIterator = argsList.iterator();
		
		try {
			InputAction inputAction = initAction(argIterator, 
					InputActionType.values());
			OutputAction outputAction = initAction(argIterator, 
					OutputActionType.values());
			Set<Athlete> athletes = inputAction.handleData();
			createOutput(outputAction, athletes);
		} catch (ActionNotFoundExeption e) {
			System.out.println(getUsageErrorMessage("Invalid arguments."));
			System.exit(1);
		}
	}
	
	private String getUsageErrorMessage(String message) {
		return message + "\n" +
			"<program> -<input-method> [input-parameters] " +
			"-<output-method> [output-parameters]\n" +
			"Input: <-console>, <-csv>, <-db>\n" +
			"Output: <-console>, <-csv>, <-xml>, <-html>";
	}
	
	private void createOutput(OutputAction outputAction, 
			Set<Athlete> athletes) throws Exception {
		int place = 1;
		double score = Double.NaN;
		
		List<Athlete> tempList = new ArrayList<Athlete>();
		for (Athlete athlete : athletes) {
			if (!Double.isNaN(score) && athlete.getPoints() < score) {
				outputAction.addToOutput(calculatePlaceInterval(place, 
						tempList.size()), tempList);
				place += tempList.size();
				tempList.clear();
			}
			
			tempList.add(athlete);
			score = athlete.getPoints();
		}
		outputAction.addToOutput(calculatePlaceInterval(place, 
				tempList.size()), tempList);
		
		outputAction.finishOutput();
	}

	private String calculatePlaceInterval(int place, int size) {
		return size == 1 ? String.valueOf(place) : place + "-" + (place + size - 1);
	}

	private <T extends Action> T initAction(
			Iterator<String> argIterator, ActionType<T>[] values) throws Exception {
		argCheck(argIterator);
		ActionType<T> actionType = getActionTypeByName(argIterator.next(), values);
		
		Class<? extends T> clazz = actionType.getActionClass();
		
		if (actionType.isParamNeeded()) {
			argCheck(argIterator);
			return clazz.getConstructor(String.class).newInstance(
					argIterator.next());
		}
		return clazz.newInstance();
	}

	private void argCheck(Iterator<String> argIterator) {
		if (!argIterator.hasNext()) {
			throw new ActionNotFoundExeption();
		}
	}

	private <T extends ActionType<? extends Action>> T getActionTypeByName(
			String name, T[] values) {
		for (T actionType : values) {
			if (actionType.getName().equals(name)) {
				return actionType;
			}
		}
		throw new ActionNotFoundExeption();
	}
	
	private class ActionNotFoundExeption extends RuntimeException {
		private static final long serialVersionUID = 1L;
	}
}
