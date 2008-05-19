package net.azib.java.students.t970880.homework;

import java.util.*;
import java.text.*;
import java.io.*;
import java.sql.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**Mimics the C#'s using-construction. */
abstract class Using<T extends Closeable> {
	public T devfile;
	abstract public void work() throws Exception ;
	
	public Using(T devfile) throws Exception {
		
		this.devfile = devfile;
		try {
			work(); // delegate the work to descendant
		} finally {
			
			// suppress exceptions in close
			try {
				devfile.close();
			} catch (IOException ex) {
				System.err.println(ex + " when closing " + devfile);
			}
		}
	}
}

class Utils {
	
    public static byte[] readFully(InputStream in, int len) throws IOException {
	    byte[] buf = new byte[len];
 		for (int got_total = 0, pos = 0; got_total != len ;) {
			int got = in.read(buf, pos + got_total, len - got_total);
            if (got == -1)
                throw new EOFException("got only " + got_total + " of " + len + " bytes expected");
            got_total += got;
        }
        return buf;
    }
    
    /**Opens UTF-8 files.*/
    public static BufferedWriter createUtf8FileWriter(String filename) throws Exception {
	    return new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename), "UTF-8"));
    }
}

// a better idea would be to exploit the marker annotation on key fields.
abstract class Method implements Keyed {
	
	public Object getKey() {return name;}

	@Key public final String name; // must be unique within the set of methods
	public final boolean hasArgument; 
	
	Method(String name) {this(name, true);}
	Method(String name, boolean hasArgument) {
		this.name = name;
		this.hasArgument = hasArgument;
	}
		
	abstract public void invoke(String argument) throws Exception ;
}

/** Parses and formats a field in athlet's csv record, which means translation between string and float representations. 
 Some fields are not simple floats (min:sec). Others require cm<>m scaling. Both may need offsetting. The formatter can 
 be actual ones or translators. The actual ones perform the actual str<>float conversion, while translators scale/offset
 the float value, delegaing the conversion to underlying formatter. Such architecture allows for chaining the formatters.
 The formatters are used by decathlon's point table calculator.
 */
interface ResultFormatter {
	float parse(String P) throws ParseException;
	String format(float P);
}

/** By default, records are float numbers. This formatter is also used by scale/offset translators.*/
class DefaultResultFormatter implements ResultFormatter {
	public float parse(String p) throws ParseException {return Float.parseFloat(p);}
	public String format(float p) {return "" + p;}
	public static ResultFormatter instance = new DefaultResultFormatter(); // singletone
}

/**Some records are in min:sec format. This formatter is also used for scale/offset translators.*/
class MinSecResultForamtter implements ResultFormatter {
	public float parse(String p) throws ParseException {
		String[] split = p.split(":"); // min:sec
		float split0 = Float.parseFloat(split[0]);
		return (split.length == 1 ) 
			? split0 // some minuties are ommited
			: split0 * 60 + Float.parseFloat(split[1]);
	}
	public String format(float p) {
		int min = (int) (p / 60);
		return min + ":" + (p % 60);
	}
}

/** The formatter performs cm<>m scaling using the default formatter for parsing and formatting.*/
class CmResultFormatter implements ResultFormatter {
	public float parse(String p) throws ParseException {return DefaultResultFormatter.instance.parse(p) * 100f;}
	public String format(float p) {return DefaultResultFormatter.instance.format(p / 100f); }
}

/** Translates the result linearly, which is necessary for some events. The actual parsing/formatting is delegated to underlying formatter, which may be another delegate.*/
class OffsetResultFormatter implements ResultFormatter { // linearly translates the result
	public float parse(String p) throws ParseException {return underlying.parse(p) + offset;}
	public String format(float p) {return underlying.format(p - offset); }
	final ResultFormatter underlying;
	final float offset;
	public OffsetResultFormatter(ResultFormatter formatter, float offset) {
		this.underlying = formatter;
		this.offset = offset;
	}
}

/*Specifies factors for specific event score computation. Athlete's points for the event are computed by supplying his 'p' result,
	which was derived from formatter. This object aids the formatting, by specifying the formatter for the event.*/
class ResultFactors {
	public final float a, b, c;
	public final boolean running;
	public ResultFormatter formatter;
	public ResultFactors (boolean running, float a, float b, float c, ResultFormatter formatter) {
		this.running = running; // running events are timing (the faster the better), nor running are jumps/throws measured in meters (the further the better)
		this.a = a;
		this.b = b;
		this.c = c;
		this.formatter = formatter;
	}
	public ResultFactors (boolean running, float a, float b, float c) {this(running, a, b, c, DefaultResultFormatter.instance);}
	public int computePoints(float p) {
		return (int) (a * Math.pow(running ? b - p : p - b, c));
	}
}

/** This object keeps athlon's results for every of 10 event along with his name, country and birthdate; plus static methods of the 
object are used as a server for managing competitions. Dec-Athlon = ten results of athlon (athlete). */
public class Decathlon {
	
	final static String Q = "\""; // quote
	
	static final String[] fieldNames = {"Name", "Birthdy", "Country", "100 m sprint [sec]"
		, "Long jump [m]", "Shot put [m]", "High jump [m]", "400 m sprint [min:sec]"
		, "110 m hurdles [sec]", "Discus throw [m]", "Pole vault [m]", "Javelin throw [m]"
		, "1500 m race [min:sec]"};

	static final ResultFormatter minSecFormatter = new MinSecResultForamtter();
	static final ResultFormatter hurdlesFormatter = new OffsetResultFormatter(DefaultResultFormatter.instance, 0.24f);
	static final ResultFormatter cmFormatter = new CmResultFormatter();
	
	static ResultFactors[] resultFactors = new ResultFactors[] {
		new ResultFactors(true,   25.437f,	18.0f,	1.81f, hurdlesFormatter),	// 100 m
		new ResultFactors(false, 0.14354f,	 220f, 	1.40f, cmFormatter),	// Long Jump
		new ResultFactors(false,   51.39f,	 1.5f, 	1.05f),	// Shot Put
		new ResultFactors(false,  0.8465f,	  75f, 	1.42f, cmFormatter),	// High Jump
		new ResultFactors(true,  1.53775f,	  82f, 	1.81f, new OffsetResultFormatter(minSecFormatter, 0.14f)),	// 400 m
		new ResultFactors(true,  5.74352f,	28.5f, 	1.92f, hurdlesFormatter),	// 110 m Hurdles
		new ResultFactors(false,   12.91f,	 4.0f, 	1.1f),		// Discus Throw
		new ResultFactors(false,  0.2797f,	 100f, 	1.35f, cmFormatter),	// Pole Vault
		new ResultFactors(false,   10.14f,	 7.0f, 	1.08f),	// Javelin Throw
		new ResultFactors(true,  0.03768f,	 480f, 	1.85f, minSecFormatter)	// 1500 m
	};
	
	// actual athlon + his decimal records
	public String name;
	public java.util.Date birthdy;
	public String country;
	
	/**These are the P parameters used in score calculation http://www.geocities.com/mdetting/sports/decathlon-points-formula.html 
	The rest is stored in table of ResultFators.*/
	public final float[] ps = new float[10]; 
	public int place; // assigned after sort
	
	// Sum all the 10 event scores
	public int getScore() { // a computable field
		int total = 0;
		for (int i = 0 ; i != 10 ; i++) {
			//log("score(event = " + i + ", p = " + ps[i] + ") = " + resultFactors[i].computePoints(ps[i]));
			total += resultFactors[i].computePoints(ps[i]);
		}
		return total;
	}
	
	static DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
	
	/** Creates a decathlon record. The name is expected in double quotes. */
	static void fromCsv(String csv) throws java.text.ParseException {
		Decathlon d = new Decathlon();
		Scanner tokenizer = new Scanner(csv);
		tokenizer.useDelimiter(",");
		
		d.name = tokenizer.next("\\\".+\\\"").replaceAll(Q, ""); // remove the quotes
		d.birthdy = dateFormat.parse(tokenizer.next());
		d.country = tokenizer.next(); // check it is 2-letter?
		for (int i = 0 ; i != 10 ; i++) // parse all the results translating into P
			d.ps[i] = resultFactors[i].formatter.parse(tokenizer.next());
		list.add(d);
	}

	String toCsv() {
		StringBuffer csv = new StringBuffer(1000);
		csv.append(place + "(" + getScore() + ")");
		csv.append(" - " + Q + name + Q + "," + dateFormat.format(birthdy) + "," + country);
		for (int i = 0 ; i != ps.length ; i++)
			csv.append(",").append(resultFactors[i].formatter.format(ps[i]));
		return csv.toString();
	}


	/** This list is produced by input method, then it is processed and outputed.*/
	final static List<Decathlon> list = new ArrayList<Decathlon>();
	
	static void log(String msg) {
		System.out.println(msg);
	}
	
	static void printUsage() {
		log("Usage: " + Decathlon.class.getName() + " input_method [params] output method [params]");
		System.exit(1);
	}
	
	/**Creates XML and transforms it into a file.*/
	static void createXml(Transformer transformer, String file) throws Exception {
		
		Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
		Element tourapment = (Element)document.appendChild(document.createElement("tourapment"));
		for (Decathlon d : list) {
			Element del = (Element)tourapment.appendChild(document.createElement("athlete"));
			del.setAttribute("name", d.name);
			del.setAttribute("birthdate", dateFormat.format(d.birthdy));
			del.setAttribute("country", d.country);
			del.setAttribute("place", d.place+"");
			del.setAttribute("score", d.getScore()+"");
			for (int i = 0 ; i != 10 ; i++) {
				Element rel = (Element)del.appendChild(document.createElement("result"));
				rel.appendChild(document.createTextNode(resultFactors[i].formatter.format(d.ps[i])));
			}
		}

		transformer.setOutputProperty(javax.xml.transform.OutputKeys.DOCTYPE_SYSTEM, "decathlon.dtd");
		transformer.transform(new DOMSource(document), new StreamResult(Utils.createUtf8FileWriter(file)));

	}
	
	/** The Decathlon service application that implements the homework. */
	public static void main(final String[] args) throws Exception {
		
		// There must be at least two prameters: input and output methods.
		if (args.length < 2) {
			printUsage();
		}

		// Now, there is two parameters. One is input method, anther -- 
		// optional input argument.
				
		// We have the Input and Output methods
		class MethodGroup {
			final String name;
			final Method[] methods;
			
			MethodGroup(String name, Method[] methods) {
				this.name = name; 
				this.methods = methods;
			}
			
			/** Obtain the method by command-line specified name. */
			Method getAt(int instructionPointer) throws Exception {
				String methodName = args[instructionPointer].substring(1);
				Method result = new Table<Method>(Arrays.asList(methods)).get(methodName);
				if (result == null)
					throw new Exception(name + " method '" +  methodName + "' is not spported");
				return result;
			}
		}
		
		MethodGroup inputMethods = new MethodGroup("Input", new Method[] {
				
				new Method("console", false) {
						Iterator<String> fields;
						boolean eoi = false; // end of input (empty line entered);
						String readLine() {
							System.out.print(fields.next() + ": ");
							String result = System.console().readLine();
							eoi = (result.length() == 0);
							return result;
						}
						public void invoke(String argument) throws Exception {
							log("Enter empty line when finished");
							while (true) {
								
								fields = Arrays.asList(fieldNames).iterator();
								// convert user input into csv string
								StringBuffer csv = new StringBuffer(Q + readLine() + Q);
								while (!eoi && fields.hasNext()) {
									csv.append("," + readLine());
								}
								if (eoi)
									break;
									
								// submit csv string
								try {
									fromCsv(csv.toString()); // instantiate the 
								} catch (ParseException pe) {
									log("Bad arguments. The record was not accepted.");
								}
							}
						}
				},
					new Method("csv") {
						public void invoke(String argument) throws Exception {
							
							new Using<BufferedInputStream>(new BufferedInputStream(new FileInputStream(argument))) {public void work() throws Exception {
								
								// Windows may prefix the UTF0-8 files with a 3-byte BOM. Skip it.
								devfile.mark(3);
								if (!Arrays.equals(Utils.readFully(devfile, 3), new byte[]{(byte)0xEF, (byte)0xBB, (byte)0xBF})) {
									log("bom is not present, rewinding to start");
									devfile.reset();
								} else log("bom is there, skipping");
								
								// Now, we can read the lines
								new Using<BufferedReader>(new BufferedReader(new InputStreamReader(devfile, "UTF-8"))) {public void work() throws Exception {
										String csv;
										while ((csv = devfile.readLine()) != null && csv.trim().length() != 0) // for every line
											fromCsv(csv);
								}};
								
							}};
							
							
						}
					},
					new Method("db") {
						public void invoke(String argument) throws Exception {
							
							// Load the MySQL driver
							Class.forName("com.mysql.jdbc.Driver").newInstance();
							
							// Obtain the connection string and connect
							final Properties props = new Properties();
							{
								new Using<InputStream>(new FileInputStream("db.properties")) {public void work() throws Exception {
									props.load(devfile);
								}};
							}
							log("Connecting to " + props.getProperty("url"));
							Connection conn = DriverManager.getConnection(props.getProperty("url"));
							try {
								
								// read competition results
								PreparedStatement statement = conn.prepareStatement(
									"SELECT athletes.name, athletes.dob, athletes.country_code, results.race_100m, results.long_jump, results.shot_put, results.high_jump, results.race_400m, results.hurdles_110m, results.discus_throw, results.pole_vault, results.javelin_throw, results.race_1500m"
										+ " FROM athletes "
											+ "RIGHT JOIN results ON athletes.id=results.athlete_id "
											+ "WHERE results.competition_id = ?");
								statement.setInt(1, Integer.parseInt(argument));
								ResultSet rs = statement.executeQuery();
								while (rs.next()) {
									
// 									Decathlon d = new Decathlon();
// 									d.name = rs.getString(1); 
// 									d.birthdy = rs.getDate(2); 
// 									d.country = rs.getString(3); 
// 									for (int i = 0, j = 4 ; i != 10 ; i++, j++)
// 										d.ps[i] = rs.getFloat(j);
// 									list.add(d);

									// We can receive the fields into a csv and parse as usually
									StringBuffer csv = new StringBuffer(Q + rs.getObject(1) + Q);
									for (int i = 1, j = 2 ; i != 12 ; i++, j++ )
										csv.append("," + rs.getObject(j));
									
									fromCsv(csv.toString()); // instatntiate a decathlon
								}
								
								// Obtain user data
								
							} finally {
								conn.close(); // Unfortunately, connection is not closable
							}
						}
					}
		});

		
		MethodGroup outputMethods = new MethodGroup("Output", new Method[] {
					
					new Method("console", false) {
						
						public void invoke(String argument) throws Exception {
							log("Showing the table in CSV format.");
 							for (Decathlon d : list) {
 								log(d.toCsv());
 							}
// 							BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out/*, "Cp866"*/)); // Cp855//, Cp866 "UTF-8")); //Cp1251
// 							try {
// 								for (Decathlon d : list) {
// 									w.write(d.toCsv());
// 									w.newLine();
// 								}
// 							} finally {
// 								Utils.close(w);
// 							} 
						}
					},
					new Method("csv") {
						
						public void invoke(String argument) throws Exception {
							new Using<BufferedWriter>(Utils.createUtf8FileWriter(argument)) {public void work() throws Exception {
								for (Decathlon d : list) {
									devfile.write(d.toCsv());
									devfile.newLine();
								}
							}};
						}
					},
					new Method("xml") {  // Extensive markup work. We have nothing better to do and XML improves our spiritual life.
						
						public void invoke(String argument) throws Exception {
							createXml(TransformerFactory.newInstance().newTransformer(), argument);
						}
					},
					new Method("html") {
						public void invoke(String argument) throws Exception {
							createXml(TransformerFactory.newInstance().newTransformer(new StreamSource("decathlon.xsl")), argument);
        				}
					}
					
					
		});

		Method intputMethod = inputMethods.getAt(0); // get input method
		
		// read the input into the list
		intputMethod.invoke(args[1]);
		
		// check if something has been entered
		if (list.size() == 0) {
			log("No athlons, exiting");
			return;
		}
			
		log(list.size() + " decathlons in the list, sorting");

		// sort
		Collections.sort(list, new Comparator<Decathlon>() {
			public int compare(Decathlon d1, Decathlon d2) {return d2.getScore() - d1.getScore();}
		});
		
		// order places
		Iterator<Decathlon> i = list.iterator();
		Decathlon previous = i.next();
		for (previous.place = 1; i.hasNext() ; ) {
			Decathlon d = i.next();
			d.place = previous.place + (d.getScore() == previous.getScore() ? 0 : 1);
			previous = d;
		}
		
		int instructionPointer = intputMethod.hasArgument ? 2 : 1; // methods advance it by 0 or 1 dependently on their argument count
	
		// output the list
		Method outputMethod = outputMethods.getAt(instructionPointer);
		outputMethod.invoke(outputMethod.hasArgument ? args[instructionPointer+1] : null);
	
// 		String chineseString = "\u4e00\u4e01\u4e02\u4e03\u4304";
// 		(new PrintStream(System.out, true, "UTF-8")).println(chineseString);
		
		log("Done");	
	}
}