package net.azib.java.students.t050209;

import java.io.InputStreamReader;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 * HelloJavaScript
 *
 * @author t050209
 */
public class HelloJavaScript {

	public static void main(String[] args) throws Exception {
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("ecmascript");
		InputStreamReader scriptSource = new InputStreamReader(HelloJavaScript.class.getResourceAsStream("hello.js"), "UTF-8");
		engine.eval(scriptSource);
		Invocable invocableEngine = (Invocable) engine;
		invocableEngine.invokeFunction("printHello");
	}

}
