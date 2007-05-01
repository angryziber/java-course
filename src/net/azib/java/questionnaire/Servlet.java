package net.azib.java.questionnaire;

import net.azib.java.servlet.ServletLauncher;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.antlr.stringtemplate.StringTemplate;
import org.antlr.stringtemplate.StringTemplateGroup;

public class Servlet extends HttpServlet {

	private static final String ULTIMATE_ENCODING = "UTF-8";

	private static final long serialVersionUID = 1L;
	
	private StringTemplateGroup stringTemplateGroup;
	
	/**
	 * Servlet init method, called only once.
	 */
	public void init() throws ServletException {
		stringTemplateGroup = new StringTemplateGroup("questionnaire");
		stringTemplateGroup.setRefreshInterval(0);
	}

	/**
	 * This method is called to handle each HTTP request
	 */
	@SuppressWarnings("unchecked")
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			request.setCharacterEncoding(ULTIMATE_ENCODING);
			String actionName = request.getParameter("action");
			boolean isFirstRequest = actionName == null; 
			if (isFirstRequest) 
				actionName = "Registration";

			Session session = initSession(request, isFirstRequest);
			
			Action action = createAction(actionName);

			StringTemplate template = getStringTemplate(actionName);
			template.setAttribute("title", actionName);
			
			Map<String, String[]> params = request.getParameterMap();
			template.setAttribute("params", params);

			// handle the actual request
			Result result = action.process(new RequestParameters(params), template, session);
			
			if (result instanceof Redirect) {
				// redirect
				response.sendRedirect("?action=" + ((Redirect)result).nextAction);
				return;
			}
			else
			if (result instanceof Finish) {
				// invalidate http session
				request.getSession().invalidate();
			}

			// output something
			StringTemplate mainTemplate = getStringTemplate("Main");
			mainTemplate.setAttribute("title", actionName);
			mainTemplate.setAttribute("body", template.toString());
			
			response.setContentType("text/html");
			response.setCharacterEncoding(ULTIMATE_ENCODING);
			Writer writer = response.getWriter();
			writer.write(mainTemplate.toString());
			writer.close();
		}
		catch (Exception e) {
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, "Unexpected exception", e);
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.toString());
		}
	}

	/**
	 * Initializes the session object and stores in the HttpSession
	 * @param request
	 * @param isFirstRequest 
	 * @return session
	 */
	private Session initSession(HttpServletRequest request, boolean isFirstRequest) {
		HttpSession httpSession = request.getSession(isFirstRequest);
		
		if (isFirstRequest) {
			Session session = new Session();
			httpSession.setAttribute("session", session);
			return session;
		}
		else {
			if (httpSession == null) 
				throw new IllegalStateException("Your session has expired or never existed");
			
			return (Session) httpSession.getAttribute("session");
		}
	}

	private StringTemplate getStringTemplate(String templateName) {
		return stringTemplateGroup.getInstanceOf(getClass().getPackage().getName().replace('.', '/') + "/" + templateName);
	}

	@SuppressWarnings("unchecked")
	private Action createAction(String actionName) throws Exception {
		Class<Action> actionClass = (Class<Action>) Class.forName(getClass().getPackage().getName() + "." + actionName + "Action");
		return actionClass.newInstance();
	}

	/**
	 * Custom request class for convenient passing of parameters
	 */
	public static class RequestParameters {
		private Map<String, String[]> params;
		
		public RequestParameters(Map<String, String[]> params) {
			this.params = params;
		}

		public String get(String name) {
			return params.get(name)[0];
		}
		
		public String[] getMultiple(String name) {
			if (params.containsKey(name))
				return params.get(name);
			else
				return new String[0];
		}
		
		public boolean contains(String name) {
			return params.containsKey(name);
		}
	}
		
	/**
	 * Interface for various results of Actions
	 */
	public static interface Result {
	}

	/**
	 * Redirect result
	 */
	public static class Redirect implements Result {
		private String nextAction;

		public Redirect(String nextAction) {
			this.nextAction = nextAction;
		}
	}
	
	/**
	 * Finish result that invalidated the session
	 */
	public static class Finish implements Result {
	}

	/**
	 * Launches this Servlet in Jetty servlet engine
	 */
	public static void main(String[] args) throws Exception {
		ServletLauncher.main(Servlet.class.getName());
	}
}


