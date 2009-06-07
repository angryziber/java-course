package net.azib.java.students.t050545.homework;

import net.azib.java.students.t050545.homework.loaders.AthleteLoader;
import net.azib.java.students.t050545.homework.sport.AthleteScore;
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
import java.util.Map.Entry;

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

	public PluginLoader(String[] args) throws LoadException{
		try{
		for(int i = args.length-1; i>=0; i--){
			arguments.push(args[i]);
		}
		loaders = getLoaders();
		writers = getWriters();
		}catch(URISyntaxException e){
			throw new LoadException("IT'S impossible, package URI exeption");
		}catch(ClassNotFoundException e){
			throw new LoadException("Check AthleteLoader and AthleteWriter files");
		}catch(InstantiationException e){
			throw new LoadException("In plugin is missing appropriate constructor");
		}catch(Exception e){
			throw new LoadException("Contack with developer");
		}

	}

	public AthleteLoader getLoader() throws LoadException{
		String key = arguments.pop();
		if(loaders.containsKey(key)){
		AthleteLoader loader = loaders.get(key);
		loader.init(arguments);
		return loader;
		} else {
			System.out.println("Wrong arguments or filename ");
			System.out.println(printHelp());
			return null;
		}
	}
	
	public AthleteWriter getWriter() throws LoadException{
		String key = arguments.pop();
		if(writers.containsKey(key)){
		AthleteWriter writer = writers.get(key);
		writer.init(arguments);
		return writer;
		} else {
			System.out.println("Wrong arguments or filename ");
			System.out.println(printHelp());
			return null;
		}
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

	private String printHelp(){
		StringBuilder builder = new StringBuilder();
		builder.append("Command line: <program> -<input-method> [input-parameters] -<output-method> [output-parameters]\n");
		builder.append("\nThis program gets value from different sources, use follow arguments:\n");
		for(String str: loaders.keySet()){
			builder.append(str+"\t"+loaders.get(str).getDescription()+"\n");
		}
		
		builder.append("\nYou can save competition result in a different forms, use follow arguments:\n");
		for(String str: writers.keySet()){
			builder.append(str+"\t"+writers.get(str).getDescription()+"\n");
		}
		
		return builder.toString();
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
