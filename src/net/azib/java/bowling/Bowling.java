package net.azib.java.bowling;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Bowling
 *
 * @author anton
 */
public class Bowling {
	private List<Integer> shots = new ArrayList<Integer>();
	private int score;

	public int getScore() {
		score = 0;
		for (int i = 0; i < shots.size(); i++) {
			addPoints(i);
			if (shots.get(i) == 10) {
				addPoints(i+1);
				addPoints(i+2);
			}
		}
		return score;
	}

	private void addPoints(int shotIndex) {
		if (shotIndex < shots.size())
			score += shots.get(shotIndex);
	}

	public void makeShot(Integer ... pinsHit) {
		shots.addAll(Arrays.asList(pinsHit));
	}

}
