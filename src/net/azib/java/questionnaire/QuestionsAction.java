package net.azib.java.questionnaire;

import net.azib.java.questionnaire.Servlet.Redirect;
import net.azib.java.questionnaire.Servlet.RequestParameters;
import net.azib.java.questionnaire.Servlet.Result;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.antlr.stringtemplate.StringTemplate;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class QuestionsAction implements Action {
	
	public Result process(RequestParameters params, StringTemplate template, Session session) throws JDOMException, IOException {
		if (session.isFinished())
			throw new RuntimeException("You cannot change your answers anymore!");
		
		if (session.questions == null) {
			// load questions if not still loaded
			session.questions = loadQuestions();
			session.answers = new ArrayList<Answer>();
		}
		
		int submittedIndex = -1;
		if (params.contains("submit")) {
			// an answer was submitted
			submittedIndex = Integer.parseInt(params.get("index"));
			Answer answer = new Answer(session.questions.get(submittedIndex));
			for (String answerText : params.getMultiple("answer")) {
				answer.answers.add(answerText);
			}
			session.answers.add(submittedIndex, answer);
		}
			
		int currentIndex = submittedIndex + 1;
		if (currentIndex < session.questions.size()) {
			// next question
			template.setAttribute("index", currentIndex);
			template.setAttribute("total", session.questions.size());
			template.setAttribute("question", session.questions.get(currentIndex));
			return null;
		}
		else {
			// all :-)
			return new Redirect("Completed");
		}
	}

	@SuppressWarnings("unchecked")
	private List<Question> loadQuestions() throws JDOMException, IOException {
		List<Question> questions = new ArrayList<Question>();
		SAXBuilder builder = new SAXBuilder();
		Document doc = builder.build(getClass().getResourceAsStream("questions.xml"));
		
		List<Element> children = doc.getRootElement().getChildren("question");
		for (Element questionElement : children) {

			// load question
			Question question = new Question(questions.size(), questionElement.getChildText("text"));
			questions.add(question);
			
			// load possible and correct answers
			for (Element answerElement : (List<Element>)questionElement.getChildren("answer")) {
				String answer = answerElement.getText();
				question.answers.add(answer);
				if ("true".equals(answerElement.getAttributeValue("correct")))
					question.correct.add(answer);
			}
		}
		return questions;
	}

}
