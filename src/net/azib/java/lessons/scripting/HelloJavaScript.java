package net.azib.java.lessons.scripting;

import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * HelloJavaScript
 *
 * @author anton
 */
public class HelloJavaScript {
	
	public static void main(String[] args) throws ScriptException, UnsupportedEncodingException, NoSuchMethodException {
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("ecmascript");
		InputStreamReader scriptSource = new InputStreamReader(HelloJavaScript.class.getResourceAsStream("hello.js"), "UTF-8");
		
		engine.eval(scriptSource);
		
		List<String> list = new ArrayList<String>();
		list.add("Koer");
		engine.put("megaList", list);
		
		System.out.println("JavaScript:");
		Invocable invocableEngine = (Invocable) engine;
		invocableEngine.invokeFunction("printList");
		
		System.out.println("\n\nJava:");
		for (String s : list) {
			System.out.println(s);
		}

		System.out.println();
		System.out.println(invocableEngine.invokeFunction("calculateStuff", 5, 7));
	}

}
