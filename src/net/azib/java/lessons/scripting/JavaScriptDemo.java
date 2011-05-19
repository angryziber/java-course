package net.azib.java.lessons.scripting;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Date;

/**
 * @author anton
 */
public class JavaScriptDemo {
	public static void main(String[] args) throws ScriptException {
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine js = manager.getEngineByExtension("js");
		js.put("anotherDate", new Date());
		js.eval("importPackage(java.util);" +
				"var date = new Date();" +
				"println(date.toString());" +
				"println(anotherDate)");
	}
}
