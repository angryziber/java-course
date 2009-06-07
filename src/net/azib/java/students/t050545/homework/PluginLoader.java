package net.azib.java.students.t050545.homework;

import net.azib.java.students.t050545.homework.loaders.AthleteLoader;
import net.azib.java.students.t050545.homework.sport.Sportman;
import net.azib.java.students.t050545.homework.writers.AthleteWriter;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

import sun.java2d.pipe.hw.ExtendedBufferCapabilities;

/**
 * IOLoader
 * 
 * @author libricon
 */
public class PluginLoader {

	private Map<String, AthleteLoader> loaders = null;
	private Map<String, AthleteWriter> writers = null;
	private Stack<String> arguments = new Stack<String>();

	public PluginLoader(String[] args) throws URISyntaxException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		for(int i = args.length-1; i>=0; i--){
			arguments.push(args[i]);
		}
		loaders = getLoaders();
		writers = getWriters();

	}

	public AthleteLoader getLoader() throws LoadException{
		AthleteLoader loader = loaders.get(arguments.pop());
		loader.init(arguments);
		return loader;
	}
	
	public AthleteWriter getWriter() throws LoadException{
		AthleteWriter writer = writers.get(arguments.pop());
		writer.init(arguments);
		return writer;
	}
	
	private Map<String, AthleteLoader> getLoadClasses() {
		return loaders;
	}

	private Map<String, AthleteWriter> getWriteClasses() {
		return writers;
	}

	private Map<String, AthleteLoader> getLoaders() throws URISyntaxException, ClassNotFoundException, InstantiationException, IllegalAccessException  {

		URL pack = AthleteLoader.class.getResource(".");
		File dir = new File(pack.toURI());
		String[] files = dir.list();
		Map<String, AthleteLoader> argVSclass = new TreeMap<String, AthleteLoader>();
		for (String file : files) {
			if (file.endsWith(".class")) {
				Class unknowClass = Class.forName(AthleteLoader.class.getPackage().getName() + '.'
						+ file.substring(0, file.length() - 6));
				if (isInterface(unknowClass, AthleteLoader.class.getSimpleName())) {
					//System.out.println(unknowClass.getSimpleName());
					AthleteLoader temp = (AthleteLoader) unknowClass.newInstance();
					//System.out.println(temp.getArgum()+"  " + temp.getDescription());
					argVSclass.put(temp.getArgum(), temp);
				}
			}
		}

		return argVSclass;

	}

	private Map<String, AthleteWriter> getWriters() throws URISyntaxException, ClassNotFoundException, InstantiationException, IllegalAccessException  {

		URL pack = AthleteWriter.class.getResource(".");
		File dir = new File(pack.toURI());
		String[] files = dir.list();
		Map<String, AthleteWriter> argVSclass = new TreeMap<String, AthleteWriter>();
		for (String file : files) {
			if (file.endsWith(".class")) {
				Class unknowClass = Class.forName(AthleteWriter.class.getPackage().getName() + '.'
						+ file.substring(0, file.length() - 6));
				if (isInterface(unknowClass, AthleteWriter.class.getSimpleName())) {
					//System.out.println(unknowClass.getSimpleName());
					AthleteWriter temp = (AthleteWriter) unknowClass.newInstance();
					//System.out.println(temp.getArgum()+"  " + temp.getDescription());
					argVSclass.put(temp.getArgum(), temp);
				}
			}
		}

		return argVSclass;

	}

	private boolean isInterface(Class cl, String interName) {
		Class[] theInterfaces = cl.getInterfaces();
		for (Class inter : theInterfaces) {
			if (inter.getSimpleName().equals(interName))
				return true;
		}
		return false;
	}

	public static void main(String[] args){
		try {
			PluginLoader loader = new PluginLoader(args);
			loader.getLoader();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		System.exit(0);

	}
}
