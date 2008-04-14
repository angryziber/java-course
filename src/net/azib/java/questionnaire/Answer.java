package net.azib.java.questionnaire;

import java.util.ArrayList;
import java.util.List;

/**
 * Answer to a question model
 * 
 * @author anton
 */
public class Answer {
	
	public Question question;
	public List<String> answers = new ArrayList<String>();
	
	public Answer(Question question) {
		this.question = question;
	}
	
	public boolean isCorrect() {
		if (question.isChoice()) {
			// compare choice answers (values should be exactly the same)
			return answers.equals(question.correct);
		} 
		else {
			// compare non-choice (manually entered) answers
			String answer = answers.get(0).trim().replaceAll("\\s\\s+", " ");
			if (answer.endsWith("s"))
				answer = answer.substring(0, answer.length() - 1);
			return answer.equalsIgnoreCase(question.correct.get(0));
		}
	}

}
