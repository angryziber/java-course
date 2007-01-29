package net.azib.java.questionnaire;

import net.azib.java.questionnaire.Servlet.Redirect;
import net.azib.java.questionnaire.Servlet.RequestParameters;
import net.azib.java.questionnaire.Servlet.Result;

import org.antlr.stringtemplate.StringTemplate;

public class RegistrationAction implements Action {
	
	public Result process(RequestParameters params, StringTemplate template, Session session) {
		if (params.contains("submit")) {
			try {
				User user = readUser(params);
				validate(user);
				session.user = user;
				
				// redirect on success
				return new Redirect("Questions");
			}
			catch (IllegalArgumentException e) {
				template.setAttribute("error", e.getMessage());
			}
		}
		return null;
	}
	
	private void validate(User user) {
		if (!user.name.matches("\\w+ \\w+.*")) 
			throw new IllegalArgumentException("Both first and last name must be provided");
		if (!user.studentCode.matches("\\d{6}")) 
			throw new IllegalArgumentException("Student code must be composed of 6 digits");
		if (!user.curriculumCode.matches("[A-Z]{3,5}")) 
			throw new IllegalArgumentException("Curriculum code must be composed of 3 to 5 letters");
		if (!user.email.matches(".+@.+\\..+")) 
			throw new IllegalArgumentException("Email doesn't seem to be valid");
		if (!user.phone.matches("[-+ \\d]{7,20}")) 
			throw new IllegalArgumentException("Phone number doesn't seem to be valid");
		if (!user.password.matches(".{6,}"))
			throw new IllegalArgumentException("Password must be at least 6 characters long");
		if (!user.password.equals(user.password2))
			throw new IllegalArgumentException("Passwords don't match!");
	}

	private User readUser(RequestParameters params) {
		User user = new User();
		user.name = params.get("name");
		user.studentCode = params.get("studentCode");
		user.curriculumCode = params.get("curriculumCode");
		user.email = params.get("email");
		user.phone = params.get("phone");
		user.company = params.get("company");
		user.password = params.get("password");
		user.password2 = params.get("password2");
		return user;
	}

	
}
