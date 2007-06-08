/*
 * Created on 08.06.2007
 * @author Konstantin Tarletski
 */
package net.azib.java.students.t981774.homework;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.Collections;

/**
 * @author Konstantin Tarletski
 * @version 1.0
 * @date 08.06.2007
 */
public class Main {

	
	public static final String USAGE_MESSAGE = "Main "+
	" -i csvInputFile -id -c -o cvsOutputFile -c competitionId"+
	" -x xmlOutputFile -h htmlOutputFile";
	
	private Vector outputStreams = new Vector();
	private IReader theReader; 
	private List results ;
	
	/**
	 * @author Konstantin Tarletski
	 * @version 1.0
	 * @date 08.06.2007
	 * @param argv
	 */
    public Main(String[] argv) {


    		try {
				int len = argv.length;
				for (int i = 0; i < len; i++) {
					String sw =argv[i];
	
					if (sw.equalsIgnoreCase("-i")) {
						
						theReader = new FileReader();
						((FileReader)theReader).setInputFile(new File( argv[i++]));

					} else if (sw.equalsIgnoreCase("-id")){
						
						theReader = new DBReader();
						
					}else if (sw.equalsIgnoreCase("-c")){
						
						theReader = new ConsoleReader();
						
					}else if (sw.equalsIgnoreCase("-x")) {
						
						IWriter the_writer = new XMLWriter();
						the_writer.setFileName(argv[i++]);
						outputStreams.add(the_writer);
						
					} else if (sw.equalsIgnoreCase("-h")) {

						IWriter the_writer = new HTMWriter();
						the_writer.setFileName(argv[i++]);
						outputStreams.add(the_writer);
						
					} else if (sw.equalsIgnoreCase("-o")) {
						
						IWriter the_writer = new CSVWriter();
						the_writer.setFileName(argv[i++]);
						outputStreams.add(the_writer);
						
					}else {

						throw new IllegalArgumentException("Unrecognized option \"" + argv[i] + "\"");
						
					}
				}//for (int i = 0; i < len; i++)

			} catch (IllegalArgumentException e) {
				
				System.out.println("Usage: " + USAGE_MESSAGE );
				throw e;
			
			}//catch	
    		
			results = theReader.executeReader();
			Collections.sort(this.results);
			
			Iterator outputIterator = this.outputStreams.iterator();
			
			while(outputIterator.hasNext()){
				
				IWriter theWriter = (IWriter) outputIterator.next();
				theWriter.wtite();
				
			}//while
    	
    }//public Main(String inputFileName, String outputFileName)
	
	
	/**
	 * @author Konstantin Tarletski
	 * @version 1.0
	 * @date 08.06.2007
	 * @param args
	 */
	public static void main(String[] args) {

        new Main(args);
		
	}//public static void main(String[] args)
}
