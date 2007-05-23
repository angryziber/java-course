package net.azib.java.students.t030657.homework;

import java.io.File;

/**
 * @author Karina
 * public class Configuration
 * By this class reading and writing to different format file is done
 */
public class Configuration {
	
	private static final String USAGE = "Decathlon "+
		" -f csvInputFile -o cvsOutputFile -c competitionId"+
		" -x xmlOutputFile -h htmlOutputFile";
	private static final int STD=0,CSV=1,XML=2,HTM=3;
	
	String inputFile;
	int outputFormat = STD;
	String outputFile;
	int competition=-1;

	static String getUsage() {return USAGE;}

	Configuration( String[] argv) {
		int len = argv.length;
		for (int i = 0; i < len; i++) {
			String sw =argv[i];
			if (++i >= len || argv[i].startsWith("-"))
				throw new IllegalArgumentException(sw + " must have an argument");
			if (sw.equals("-f")) {
				inputFile = argv[i];
			} else if (sw.equals("-x")) {
				outputFormat=XML;
				outputFile = argv[i];
			} else if (sw.equals("-h")) {
				outputFormat=HTM;
				outputFile = argv[i];
			} else if (sw.equals("-o")) {
				outputFormat=CSV;
				outputFile = argv[i];
			} else if (sw.equals("-c")) {
				competition = Integer.parseInt(argv[i]);
			}else {
				throw new IllegalArgumentException("Unrecognized option \"" + argv[i] + "\"");
			}
		}
	}

	Reader getReader() {
		if (competition>=0)
			return new DbReader(competition);
		if (inputFile!=null)
			return new CsvReader(new File(inputFile));
		return  new StdinReader();
	}
	
	Writer getWriter() {
		Writer w;
		switch (outputFormat){
		case XML: 
			w = new XmlWriter(new File(outputFile));
			break;
		case HTM: 
			w = new HtmlWriter(new File(outputFile));
			break;
		case CSV: 
			w = new CsvWriter(new File(outputFile));
			break;
		default:
			w = new StdoutWriter();
		}
		return w;
	}
}
