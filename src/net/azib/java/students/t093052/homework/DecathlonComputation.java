package net.azib.java.students.t093052.homework;

import net.azib.java.students.t093052.homework.action.Action;
import net.azib.java.students.t093052.homework.action.ActionType;
import net.azib.java.students.t093052.homework.action.input.InputAction;
import net.azib.java.students.t093052.homework.action.input.InputActionType;
import net.azib.java.students.t093052.homework.action.output.OutputAction;
import net.azib.java.students.t093052.homework.action.output.OutputActionType;
import net.azib.java.students.t093052.homework.action.output.OutputDataException;

import java.io.IOException;
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
	public static void main(String[] args) {
		new DecathlonComputation().run(args);
	}

	private void run(String[] args) {
		List<String> argsList = Arrays.asList(args);
		Iterator<String> argIterator = argsList.iterator();
		
		InputAction inputAction = initAction(argIterator, 
					InputActionType.values());
		OutputAction outputAction = initAction(argIterator, 
					OutputActionType.values());
		Set<Athlete> athletes = inputAction.handleData();
		
		createOutput(outputAction, athletes);
	}
	
	private String getUsageErrorMessage(String message) {
		return message + "\n" +
			"<program> -<input-method> [input-parameters] " +
			"-<output-method> [output-parameters]\n" +
			"Input: <-console>, <-csv>, <-db>\n" +
			"Output: <-console>, <-csv>, <-xml>, <-html>";
	}
	
	private void createOutput(OutputAction outputAction, 
			Set<Athlete> athletes) {
		try {
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
		} catch (IOException e) {
			throw new OutputDataException(
				"Could not proceed writing data into output.", e);
		}
	}

	String calculatePlaceInterval(int place, int size) {
		return size == 1 ? String.valueOf(place) : place + "-" + (place + size - 1);
	}

	<T extends Action> T initAction(
			Iterator<String> argIterator, ActionType<T>[] values) {
		try {
			ActionType<T> actionType = getActionTypeByName(
					getNextArgument(argIterator, false), values);
			
			Class<? extends T> clazz = actionType.getActionClass();
			
			if (actionType.isParamNeeded()) {
				return clazz.getConstructor(String.class).newInstance(
						getNextArgument(argIterator, true));
			}
			return clazz.newInstance();
		} catch (Exception e) {
			if (e instanceof ActionNotFoundExeption) {
				throw (ActionNotFoundExeption) e;
			} else if (e instanceof InvalidArgumentExeption) {
				throw (InvalidArgumentExeption) e;
			} else {
				throw new NewInstanceException(
						"Could not create action class instance", e);
			}
		}
	}

	private String getNextArgument(Iterator<String> argIterator, 
			boolean additionalParam) {
		String arg = null;
		if (argIterator.hasNext() && !((arg = argIterator.next()).matches("-.*") 
				&& additionalParam)) {
			return arg;
		}
		throw new InvalidArgumentExeption(
				getUsageErrorMessage("Invalid arguments"));
		
	}

	<T extends ActionType<? extends Action>> T getActionTypeByName(
			String name, T[] values) {
		for (T actionType : values) {
			if (actionType.getName().equals(name)) {
				return actionType;
			}
		}
		throw new ActionNotFoundExeption(name);
	}
	
	private class InvalidArgumentExeption extends RuntimeException {
		private static final long serialVersionUID = 1L;
		
		public InvalidArgumentExeption(String message) {
			super(message);
		}
	}
	
	private class ActionNotFoundExeption extends RuntimeException {
		private static final long serialVersionUID = 1L;
		
		public ActionNotFoundExeption(String action) {
			super("Could not find action: " + action);
		}
	}
	
	private class NewInstanceException extends RuntimeException {
		private static final long serialVersionUID = 1L;
		
		public NewInstanceException(String message, Throwable cause) {
			super(message);
			initCause(cause);
		}
	}
}
