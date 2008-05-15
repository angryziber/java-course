package net.azib.java.lessons.scripting;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * ScriptingDemo
 *
 * @author anton
 */
public class ScriptingDemo {
	public static void main(String[] args) throws ScriptException, NoSuchMethodException {
		ScriptEngineManager manager = new ScriptEngineManager(); 
		ScriptEngine engine = manager.getEngineByName("javascript");
		engine.eval(new InputStreamReader(ScriptingDemo.class.getResourceAsStream("hello.js")));
		
		List<String> argsList = Arrays.asList(args);
		
		((Invocable)engine).invokeFunction("main", argsList);
		
		engine.eval("var jsonObject = { name: 'Peeter', age: 35, sex: 'M' }");
		
		((Invocable)engine).invokeFunction("displayJSON");
		
		System.out.println(engine.eval("jsonObject.name"));
	}
}
