package net.azib.java.students.t040719.homework.io;

import net.azib.java.students.t040719.homework.Athlete;
import net.azib.java.students.t040719.homework.DecathlonConstants;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * InteractiveInput - a class for obtaining decathlon results from the user via console
 *
 * @version 0.0
 * @author Romi Agar
 */
public class ConsoleInput implements DataInput {
	private static final Logger LOG = Logger.getLogger(ConsoleInput.class.getSimpleName());
	
	static final String INVALID_NAME = " is not a valid name";
	static final String INVALID_DATE = " is not a valid date";
	static final String INVALID_COUNTRY = " is not a valid ISO 2-letter country code";
	static final String NOT_AN_INT = " is not integer";
	static final String NOT_A_FLOAT = " is not float";
	
	private final PrintStream out;
	private final BufferedReader input;
	
	public ConsoleInput() {
		this(new BufferedReader(new InputStreamReader(System.in)), System.out);
	}
	
	ConsoleInput(BufferedReader input, PrintStream out){
		this.input = input;
		this.out = out;
	}
	
	public List<Athlete> getResults(String... parameter){
		//String defaultEncoding = new InputStreamReader(new ByteArrayInputStream(new byte[0])).getEncoding();
		//System.out.println(defaultEncoding);
		Integer n = null;
		String line = "";
		out.print("How athletes do you want to enter? ");
		do{
			try{
				n = Integer.parseInt(line = input.readLine());
			}catch (NumberFormatException e){
				out.println("'" + line + "'" + NOT_AN_INT);
				out.print("How athletes do you want to enter? ");
			}
			catch (IOException e) {
				LOG.log(Level.SEVERE, "Could not read athete count.", e);
				System.exit(1);
			}
		}while(n == null);
		
		String name = "";
		String countryCode = "";
		Date birthday = null;
		float[] results = null;
		List<Athlete> athletes = new ArrayList<Athlete>();
		for (int i=0; i<n; i++){
			out.println((i+1) + ". athlete:");
			name = getName();
			birthday = getDOB();
			countryCode = getCountry();
			results = getDecathlonResults();
			Athlete athlete = new Athlete(name, birthday, countryCode, results);
			athletes.add(athlete);
		}
		out.println("Input complete.");
		return athletes;
	}

	float[] getDecathlonResults() {
		float[] results = new float[DecathlonConstants.values().length];
		Float n;
		String line = "";
		out.println("NB! All event marks should be entered using the format 0.00!");
		for (int i=0; i<DecathlonConstants.values().length; i++){
			out.print(DecathlonConstants.getOrdinal(i).getName()+": ");
			n = null;
			do{
				try{
					n = Float.parseFloat(line = input.readLine());
				}catch (NumberFormatException e){
					out.println("'" + line + "'" + NOT_A_FLOAT);
					out.print(DecathlonConstants.getOrdinal(i).getName()+": ");
				}
				catch (IOException e) {
					LOG.log(Level.SEVERE, "Could not read decathlon result", e);
					return new float[DecathlonConstants.values().length];
				}				
			}while(n == null);
			results[i] = (float)((int)Math.round(n * 100)/100.0);
		}
		return results;
	}

	String getCountry() {
		out.print("Country (ISO 2-letter code): ");
		String line="";
		do{
			try {
				line = input.readLine().toUpperCase();
			}
			catch (IOException e) {
				LOG.log(Level.SEVERE, "Could not read athlete country code.", e);
				return "--";
			}
			if (!InputParser.isValidCountryCode(line)){
				out.println("'" + line + "'" + INVALID_COUNTRY);
				out.print("Country (ISO 2-letter code): ");
			}
		}while(!InputParser.isValidCountryCode(line));
		return line;
	}

	Date getDOB() {
		Date dob = null;
		Locale locale = Locale.getDefault();
		DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM, locale);
		df.setLenient(false);
		out.print("Date of birth (" + ((SimpleDateFormat)df).toPattern() + "): ");
		String line="";
		do{
			try {
				line = input.readLine();
				if (line != null)
					dob = df.parse(line);
			}
			catch (ParseException e){
				out.println("'" + line + "'" + INVALID_DATE);
				out.print("Date of birth (" + ((SimpleDateFormat)df).toPattern() + "): ");				
			}
			catch (IOException e) {
				LOG.log(Level.SEVERE, "Could not read athlete date of birth.",e);
				return new Date();
			}
		}while(dob == null);
		return dob;
	}

	String getName() {
		String name = "";
		out.print("Name: ");
		do{
			try {
				name= input.readLine();
			}
			catch (IOException e) {
				LOG.log(Level.SEVERE, "Could not read athlete name.",e);
				return "<no name>";
			}
			if (!InputParser.isValidName(name)){
				out.println("'" + name + "'" + INVALID_NAME);
				out.print("Name: ");
			}
		}while(!InputParser.isValidName(name));
		return name;
	}

	
		/*BufferedReader i = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\testg.txt"),"UTF-8"));

		String str1 = i.readLine();

   System.out.println("File Text : "+ str1);
   Scanner in = new Scanner(System.in);

   // Reads a single line from the console 
   // and stores into name variable
   String name = in.nextLine();
   System.out.println(name);
   
		InputStreamReader  inp = new InputStreamReader(System.in, "Cp1257" );
	      BufferedReader br = new BufferedReader(inp);

	      System.out.println("Enter text : ");
	 
	     String str = br.readLine();
	     PrintStream ps = new PrintStream(System.out, true, "UTF-16");
	     ps.println(str1);
	     System.out.println("You entered String : ");
	     String strr = "caractères français :  à é \u00e9 фыв";
	      System.out.println(str);
	      BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:\\testg1.txt"),"UTF8"));
	      out.write(strr);
	      out.write(new String(str.getBytes()));
	      out.write(name);
	      out.close();
	      String javaString = 
	          "caractères français :  à é \u00e9 фыв";  // Unicode for "é"
	        try {
	          // output to the console
	          Writer w = 
	            new BufferedWriter
	               (new OutputStreamWriter(System.out, "Cp1257"));
	          w.write(javaString);
	          w.write(str);
	          w.write(str1);
	          w.write(name);
	          w.flush();
	          w.close();  
	          }
	       catch (Exception e) {
	          e.printStackTrace();
	          }*/
	       
}
