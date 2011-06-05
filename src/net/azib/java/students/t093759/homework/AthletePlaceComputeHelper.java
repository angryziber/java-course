package net.azib.java.students.t093759.homework;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class provides functionality for computing athletes place in a list.
 *
 * @author dionis
 *         6/4/11 9:14 PM
 */
public class AthletePlaceComputeHelper {

	private static AthletePlaceComputeHelper instance;

	private AthletePlaceComputeHelper() {
	}

	public static AthletePlaceComputeHelper getInstance() {
		if (instance == null) instance = new AthletePlaceComputeHelper();
		return instance;
	}

	/**
	 * Compute places for a list of athletes and return a Map with Athlete-place pair.
	 *
	 * @param athletes A list of athletes. It'll be sorted internally.
	 * @return Map with places for athletes.
	 */
	public Map<Athlete, String> computePlacesFor(List<Athlete> athletes) {
		Collections.sort(athletes);
		Map<Athlete, String> placesForAthletes = new HashMap<Athlete, String>(athletes.size());
		Map<Integer, Integer> pointsAndCountOfPoints = new HashMap<Integer, Integer>();

		computeCountOfAthleteUserPointAppearance(athletes, pointsAndCountOfPoints);

		for (int currentPosition = 1; currentPosition <= athletes.size(); currentPosition++) {
			Athlete currentAthlete = athletes.get(currentPosition - 1);

			int computedPointsForCurrentAthlete = currentAthlete.computePoints();
			int countOfSharedPositions = pointsAndCountOfPoints.get(computedPointsForCurrentAthlete);

			if (countOfSharedPositions == 1) {
				placesForAthletes.put(currentAthlete, String.valueOf(currentPosition));
			} else {
				handleMultipleSharedPositions(athletes, placesForAthletes, currentPosition, currentAthlete, computedPointsForCurrentAthlete, countOfSharedPositions);
			}
		}
		return placesForAthletes;
	}

	private void handleMultipleSharedPositions(List<Athlete> athletes, Map<Athlete, String> placesForAthletes,
	                                           int currentPositionOfAthlete, Athlete currentAthlete, int computedPointsForCurrentAthlete, int countOfSharedPositions) {
		if (currentAthleteIsFirstOne(currentPositionOfAthlete))
			putIntervalOfPlaces(placesForAthletes, currentPositionOfAthlete, currentAthlete, countOfSharedPositions);
		else {
			Athlete previousAthlete = athletes.get(currentPositionOfAthlete - 2);
			if (previousAthlete.computePoints() == computedPointsForCurrentAthlete) {
				placesForAthletes.put(currentAthlete, placesForAthletes.get(previousAthlete));
			} else {
				putIntervalOfPlaces(placesForAthletes, currentPositionOfAthlete, currentAthlete, countOfSharedPositions);
			}
		}
	}

	private boolean currentAthleteIsFirstOne(int currentPositionOfAthleteInSequence) {
		return currentPositionOfAthleteInSequence == 1;
	}

	private void putIntervalOfPlaces(Map<Athlete, String> placesForAthletes, int currentPositionOfAthleteInSequence, Athlete currentAthlete, int countOfSharedPositions) {
		placesForAthletes.put(currentAthlete, String.valueOf(currentPositionOfAthleteInSequence + "-" + (currentPositionOfAthleteInSequence + countOfSharedPositions - 1)));
	}

	private void computeCountOfAthleteUserPointAppearance(List<Athlete> athletes, Map<Integer, Integer> pointsAndCountOfPoints) {
		for (Athlete athlete : athletes) {
			incrementCountOfPointsFor(athlete, pointsAndCountOfPoints);
		}
	}

	private void incrementCountOfPointsFor(Athlete athlete, Map<Integer, Integer> pointsAndCountOfPoints) {
		int athletePoints = athlete.computePoints();
		if (!pointsAndCountOfPoints.containsKey(athletePoints)) {
			pointsAndCountOfPoints.put(athletePoints, 0);
		}
		pointsAndCountOfPoints.put(athletePoints, pointsAndCountOfPoints.get(athletePoints) + 1);
	}
}
