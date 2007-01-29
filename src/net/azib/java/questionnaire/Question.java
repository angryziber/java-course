/**
 * 
 */
package net.azib.java.questionnaire;

import java.util.ArrayList;
import java.util.List;

/**
 * Question model
 * 
 * @author anton
 */
class Question {
	public int id;
	public String text;
	public List<String> answers = new ArrayList<String>();
	public List<String> correct = new ArrayList<String>();
	
	public Question(int id, String text) {
		this.id = id;
		this.text = text;
	}

	public boolean isChoice() {
		return answers.size() > 1;
	}
	
	public boolean isSingleAnswer() {
		return correct.size() == 1;
	}
}