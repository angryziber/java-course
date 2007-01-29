package net.azib.java.questionnaire;


import net.azib.java.questionnaire.Servlet.RequestParameters;

import org.antlr.stringtemplate.StringTemplate;

/**
 * Interface for actions, service Servlet requests.
 * 
 * @author anton
 */
public interface Action {

	/**
	 * Executes the needed code for the action
	 * @param params request parameters
	 * @param template StringTemplate to fill
	 * @param session session object to persist state
	 * @return the result type of the processing (that implements Result)
	 */
	Servlet.Result process(RequestParameters params, StringTemplate template, Session session) throws Exception;

}
