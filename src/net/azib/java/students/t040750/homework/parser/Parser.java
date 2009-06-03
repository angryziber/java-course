package net.azib.java.students.t040750.homework.parser;


import net.azib.java.students.t040750.homework.calculator.DecathlonPointsCalculator;
import net.azib.java.students.t040750.homework.generic.Athlete;
import net.azib.java.students.t040750.homework.generic.DecathlonData;
import net.azib.java.students.t040750.homework.generic.Result;
import net.azib.java.students.t040750.homework.main.DecathlonDemo;
import net.azib.java.students.t040750.homework.parser.db.DataReader;
import net.azib.java.students.t040750.homework.parser.xml.AthleteType;
import net.azib.java.students.t040750.homework.parser.xml.DecathlonDataType;
import net.azib.java.students.t040750.homework.parser.xml.DecathlonType;
import net.azib.java.students.t040750.homework.parser.xml.ObjectFactory;
import net.azib.java.students.t040750.homework.parser.xml.ResultType;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;


import org.apache.commons.io.IOUtils;

/**
 * Parser for input and output data
 * 
 * @author Karpz
 *
 */
public class Parser {
	
	/**
	 * {@link HTMLConverterThread} class takes care of the source stream
	 * conversion to HTML output.
	 * 
	 * @author Karpz
	 *
	 */
	private static class HTMLConverterThread implements Runnable {
	    StreamSource source;
	    InputStream schema;
		StreamResult res;
		
		/**
		 * Create new thread for converting {@link StreamSource} 
		 * input to {@link StreamResult} output.
		 * 
		 * @param source - input stream
		 * @param schema - schema for HTML output
		 * @param res - output stream
		 */
		public HTMLConverterThread(StreamSource source, InputStream schema, StreamResult res) {
			this.source = source;
			this.schema = schema;
			this.res = res;
			
		}
		
		/**
		 * Convert source stream to HTML output stream.
		 */
        public void run() {
        	try {
	        	TransformerFactory transFact = TransformerFactory.newInstance();
	    		Transformer trans = transFact.newTransformer(
	    				new StreamSource(schema));
	    		
				trans.transform(source,res);
			} catch (TransformerException e) {
				System.err.println("Error converting stream to HTML");
				e.printStackTrace();
			}
        }
    };
	
    /**
     * Generate XML output from competition data and write it to the requested
     * target file.
     * 
     * @param output - XML output file name
     * @param decathlonData - Data to convert to XML
     * @throws JAXBException - if errors generating the XML data			
     */
	public void outputXMLData(String output, List<DecathlonData> decathlonData) {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(	AthleteType.class, 
																ResultType.class, 
																DecathlonType.class,
																DecathlonDataType.class,
																ObjectFactory.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        
			OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(output),"UTF-8");
			marshaller.marshal(generateXMLData(decathlonData), writer );
		} catch (IOException e) {
			throw new RuntimeException("Error writing to the output XML file!", e);
		} catch (JAXBException e) {
			throw new RuntimeException("Error generating the XML output data!", e);
		}
	}

	/**
	 * Generate HTML output from competition data and write it to the requested
	 * target file.
	 *  
	 * @param output - HTML output file name
	 * @param decathlonData - competition data to convert to HTML
	 * @throws JAXBException - if errors generating the XML data from which to generate the HTML
	 */
	public void outputHTMLData(String output, List<DecathlonData> decathlonData) {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(	AthleteType.class, 
																ResultType.class, 
																DecathlonType.class,
																DecathlonDataType.class,
																ObjectFactory.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		
			PipedOutputStream pout = new PipedOutputStream();  
			PipedInputStream pin = new PipedInputStream(pout);
			
			Thread t = new Thread(new HTMLConverterThread(
					new StreamSource(pin),
					DecathlonDemo.class.getResourceAsStream(DecathlonDemo.XSL_SCHEMA),
					new StreamResult(new OutputStreamWriter(new FileOutputStream(output), "UTF-8"))));
			t.start();

			marshaller.marshal(generateXMLData(decathlonData), 
					new OutputStreamWriter(pout, "UTF-8"));
			
			IOUtils.closeQuietly(pout);
			IOUtils.closeQuietly(pin);
		} catch (IOException e) {
			throw new RuntimeException("Error writing to the output HTML file!", e);
		} catch (JAXBException e) {
			throw new RuntimeException("Error generating the HTML output data!", e);
		}
	}
	
	/**
	 * Load competition data from CSV file
	 * 
	 * @param src - input stream from the CSV file where to read the competition data
	 * @return - array containing the competition data
	 */
	public List<DecathlonData> loadCSVData(InputStream src) {
		Scanner input = new Scanner(src).useDelimiter("\\s*[,\\n]\\s*");
		return inputData(input);
	}

	/**
	 * Generate CSV output from competition data and write it to the requested
	 * target file.
	 * 
	 * @param output - CSV output file name
	 * @param decathlonData - competition data to convert to CSV
	 */
	public void outputCSVData(String output, List<DecathlonData> decathlonData) {
		try {
			OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(output),"UTF-8");
			outputData(writer, decathlonData);
		} catch (IOException e) {
			throw new RuntimeException("Error writing to the output CSV file!", e);
		}
	}
	
	/**
	 * Load competition data from the console
	 * 
	 * @return array containing the competition data
	 */
	public List<DecathlonData>loadCMDData() {
		Scanner input = new Scanner(System.in).useDelimiter("\\s*[,\\n]\\s*");
		return inputData(input);
	}

	/**
	 * Generate competition data output to console
	 * 
	 * @param decathlonData - competition data
	 */
	public void outputCMDData(List<DecathlonData> decathlonData) {
		try {
			OutputStreamWriter output = new OutputStreamWriter(System.out, "UTF-8"); 
			outputData(output, decathlonData);
		} catch (IOException e) {
			throw new RuntimeException("Error writing to the console!", e);
		}
	}
	
	/**
	 * Load competition data from the database
	 * 
	 * @param competition - competition name or id
	 * @return array containing the competition data
	 */
	public List<DecathlonData> loadDBData(String competition) {
		DataReader dataReader = new DataReader();
		return dataReader.getDecathlonData(competition);
	}
	
	/**
	 * Generates the XML output from the competition data
	 * 
	 * @param decathlonData - competition data
	 * @return the XML representation of the competition data
	 */
	private static JAXBElement<DecathlonType> generateXMLData(List<DecathlonData> decathlonData) {
    
	    DecathlonType decathlon = new DecathlonType();
	    List<DecathlonDataType> decType = decathlon.getDecathlonData();
	    
	    ObjectFactory objFact = new ObjectFactory();
	    
		for (DecathlonData decData : decathlonData) {
			
			DecathlonDataType data = new DecathlonDataType();
			ResultType result = new ResultType();
			AthleteType athlete = new AthleteType();
			
			athlete.setName(decData.getAthlete().getName());
			try {
				athlete.setBirthday(DatatypeFactory.newInstance().newXMLGregorianCalendar(
								decData.getAthlete().getBirthday().toString()));
			} catch (Exception e) {
				//Set athlete's birthday as null when value cannot
				//be transformed to XML date 
				athlete.setBirthday(null);
			}			
			athlete.setNationality(decData.getAthlete().getNationality());
			
			result.setRun100M(decData.getResult().getRun100m());
			result.setLongJump(decData.getResult().getLongJump());
			result.setShotPut(decData.getResult().getShotPut());
			result.setHighJump(decData.getResult().getHighJump());
			result.setRun400M(decData.getResult().getRun400m());
			result.setHurdles110M(decData.getResult().getHurdles110m());
			result.setDiscus(decData.getResult().getDiscus());
			result.setPoleVault(decData.getResult().getPoleVault());
			result.setJavelin(decData.getResult().getJavelin());
			result.setRun1500M(decData.getResult().getRun1500m());
			
			data.setResult(result);
			data.setAthlete(athlete);
			data.setTotalPoints(decData.getTotalPoints());
			data.setPosition(decData.getPosition());
			
			decType.add(data);
		}
		
		return objFact.createDecathlon(decathlon);
	}
	
	/**
	 * Generates an array containing the competition data read from the 
	 * provided input {@link Scanner} object. 
	 * 
	 * @param input - source where to read the data from
	 * @return array containing the competition data
	 */
	private static List<DecathlonData> inputData(Scanner input) {
		//TODO: Revise invalid data handling
		Athlete athlete;
		Result result;
		List<DecathlonData> decathlonData = new ArrayList<DecathlonData>();
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		while (input.hasNext()) {
			athlete = new Athlete();
			result = new Result();
			
			athlete.setName(input.next());
			
			try {
				athlete.setBirthday(new java.sql.Date(df.parse(input.next()).getTime()));
			} catch (Exception e) {
				//TODO: Revise
				e.printStackTrace();
			}
			
			athlete.setNationality(input.next());
			
			result.setRun100m(Float.parseFloat(input.next()));
			result.setLongJump(Float.parseFloat(input.next()));
			result.setShotPut(Float.parseFloat(input.next()));
			result.setHighJump(Float.parseFloat(input.next()));
			result.setRun400m(Float.parseFloat(input.next()));
			result.setHurdles110m(Float.parseFloat(input.next()));
			result.setDiscus(Float.parseFloat(input.next()));
			result.setPoleVault(Float.parseFloat(input.next()));
			result.setJavelin(Float.parseFloat(input.next()));
			result.setRun1500m(Float.parseFloat(input.next()));
			
			decathlonData.add(new DecathlonData(athlete, result, 
					DecathlonPointsCalculator.calculateTotalPoints(result)));
			
			if (input.hasNextLine()) input.nextLine();
		}
		
		input.close();
		
		return decathlonData;
	}
	
	/**
	 * Outputs the competition data to the selected stream.
	 * 
	 * @param output - output stream where to write the resulting data
	 * @param decathlonData - array containing the data which to output
	 * @throws IOException - if errors writing to the selected output
	 */
	private static void outputData(OutputStreamWriter output, List<DecathlonData> decathlonData) throws IOException {
		for (DecathlonData decData : decathlonData) {
			output.append(decData.getPosition() + ",");
			output.append(decData.getTotalPoints() + "p,");
			
			output.append(decData.getAthlete().getName() + ",");
			
			if (decData.getAthlete().getBirthday() == null) 
				output.append("0000-00-00,");
			else output.append(decData.getAthlete().getBirthday() + ",");
					
			output.append(decData.getAthlete().getNationality() + ",");
			
			output.append(decData.getResult().getRun100m() + ",");
			output.append(decData.getResult().getLongJump() + ",");
			output.append(decData.getResult().getShotPut() + ",");
			output.append(decData.getResult().getHighJump() + ",");
			output.append(decData.getResult().getRun400m() + ",");
			output.append(decData.getResult().getHurdles110m() + ",");
			output.append(decData.getResult().getDiscus() + ",");
			output.append(decData.getResult().getPoleVault() + ",");
			output.append(decData.getResult().getJavelin() + ",");
			output.append(decData.getResult().getRun1500m() + "\n");
		}
		
		output.flush();
		output.close();
	}
}
