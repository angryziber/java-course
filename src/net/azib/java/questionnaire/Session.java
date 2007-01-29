package net.azib.java.questionnaire;

import java.util.List;

/**
 * Session class used to persist the state
 * 
 * @author anton
 */
public class Session {
	public User user;
	public List<Question> questions;
	public List<Answer> answers;
	
	private boolean isFinished;
	
	/**
	 * @return true if the session has been already finished
	 */
	public boolean isFinished() {
		return isFinished;
	}

	/**
	 * Informs everybody that the session is finished and cannot be edited anymore.
	 */
	public void setFinished() {
		isFinished = true;
	}
}
