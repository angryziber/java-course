package net.azib.java.questionnaire;


import net.azib.java.questionnaire.Servlet.RequestParameters;
import net.azib.java.questionnaire.Servlet.Result;

import org.antlr.stringtemplate.StringTemplate;

public class CompletedAction implements Action {
	
	public Result process(RequestParameters params, StringTemplate template, Session session) throws Exception {
		template.setAttribute("answers", session.answers);
		template.setAttribute("name", session.user.name.substring(0, session.user.name.indexOf(' ')));
		
		int timeSec = session.getElapsedTimeSec();
		template.setAttribute("time", (timeSec / 60) + " min, " + (timeSec % 60) + " sec");
		
		int correctAnswers = 0;
		for (Answer answer : session.answers)
			if (answer.isCorrect())
				correctAnswers++;
		int wrongAnswers = session.answers.size() - correctAnswers;
		
		template.setAttribute("correctAnswers", correctAnswers);
		template.setAttribute("wrongAnswers", wrongAnswers);
		template.setAttribute("percentage", correctAnswers*100/(wrongAnswers + correctAnswers));
		
		try {
			SessionPersister persister = new SessionPersister(session);
			String username = persister.storeUser();
			template.setAttribute("username", username);
		}
		catch (IllegalStateException e) {
			// already saved, ignore
		}
		
		// don't save again
		session.setFinished();
		
		return null;
	}

}
