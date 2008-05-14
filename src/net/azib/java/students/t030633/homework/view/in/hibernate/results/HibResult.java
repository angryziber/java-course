package net.azib.java.students.t030633.homework.view.in.hibernate.results;

import net.azib.java.students.t030633.homework.view.in.hibernate.athletes.HibAthlete;
import net.azib.java.students.t030633.homework.view.in.hibernate.competitions.HibCompetition;

/**
 * HibResult
 *
 * @author t030633
 */
public class HibResult {
	
	private HibCompetition competition;
	private HibAthlete athlete;
	
	private int id;
	private int athlete_id;
	private int competition_id;
	private float race_100m;
	private float long_jump;
	private float shot_put;
	private float high_jump;
	private float race_400m;
	private float hurdles_110m;
	private float discus_throw;
	private float pole_vault;
	private float javelin_throw;
	private float race_1500m;
	
	public HibResult() {
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	@SuppressWarnings("unused") // Only Hibernate will assign identifiers when an object is saved.
	private void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the athlete_id
	 */
	public int getAthlete_id() {
		return athlete_id;
	}
	/**
	 * @param athlete_id the athlete_id to set
	 */
	public void setAthlete_id(int athlete_id) {
		this.athlete_id = athlete_id;
	}
	/**
	 * @return the competition_id
	 */
	public int getCompetition_id() {
		return competition_id;
	}
	/**
	 * @param competition_id the competition_id to set
	 */
	public void setCompetition_id(int competition_id) {
		this.competition_id = competition_id;
	}
	/**
	 * @return the race_100m
	 */
	public float getRace_100m() {
		return race_100m;
	}
	/**
	 * @param race_100m the race_100m to set
	 */
	public void setRace_100m(float race_100m) {
		this.race_100m = race_100m;
	}
	/**
	 * @return the long_jump
	 */
	public float getLong_jump() {
		return long_jump;
	}
	/**
	 * @param long_jump the long_jump to set
	 */
	public void setLong_jump(float long_jump) {
		this.long_jump = long_jump;
	}
	/**
	 * @return the shot_put
	 */
	public float getShot_put() {
		return shot_put;
	}
	/**
	 * @param shot_put the shot_put to set
	 */
	public void setShot_put(float shot_put) {
		this.shot_put = shot_put;
	}
	/**
	 * @return the high_jump
	 */
	public float getHigh_jump() {
		return high_jump;
	}
	/**
	 * @param high_jump the high_jump to set
	 */
	public void setHigh_jump(float high_jump) {
		this.high_jump = high_jump;
	}
	/**
	 * @return the race_400m
	 */
	public float getRace_400m() {
		return race_400m;
	}
	/**
	 * @param race_400m the race_400m to set
	 */
	public void setRace_400m(float race_400m) {
		this.race_400m = race_400m;
	}
	/**
	 * @return the hurdles_110m
	 */
	public float getHurdles_110m() {
		return hurdles_110m;
	}
	/**
	 * @param hurdles_110m the hurdles_110m to set
	 */
	public void setHurdles_110m(float hurdles_110m) {
		this.hurdles_110m = hurdles_110m;
	}
	/**
	 * @return the discus_throw
	 */
	public float getDiscus_throw() {
		return discus_throw;
	}
	/**
	 * @param discus_throw the discus_throw to set
	 */
	public void setDiscus_throw(float discus_throw) {
		this.discus_throw = discus_throw;
	}
	/**
	 * @return the pole_vault
	 */
	public float getPole_vault() {
		return pole_vault;
	}
	/**
	 * @param pole_vault the pole_vault to set
	 */
	public void setPole_vault(float pole_vault) {
		this.pole_vault = pole_vault;
	}
	/**
	 * @return the javelin_throw
	 */
	public float getJavelin_throw() {
		return javelin_throw;
	}
	/**
	 * @param javelin_throw the javelin_throw to set
	 */
	public void setJavelin_throw(float javelin_throw) {
		this.javelin_throw = javelin_throw;
	}
	/**
	 * @return the race_1500m
	 */
	public float getRace_1500m() {
		return race_1500m;
	}
	/**
	 * @param race_1500m the race_1500m to set
	 */
	public void setRace_1500m(float race_1500m) {
		this.race_1500m = race_1500m;
	}

	/**
	 * @return the competition
	 */
	public HibCompetition getCompetition() {
		return competition;
	}

	/**
	 * @param competition the competition to set
	 */
	public void setCompetition(HibCompetition competition) {
		this.competition = competition;
	}

	/**
	 * @return the athlete
	 */
	public HibAthlete getAthlete() {
		return athlete;
	}

	/**
	 * @param athlete the athlete to set
	 */
	public void setAthlete(HibAthlete athlete) {
		this.athlete = athlete;
	}
	
	

}
