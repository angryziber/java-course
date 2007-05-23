package net.azib.java.students.t030647.homework;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


/**
 * ApplicationFrame
 * GUI to make program easy-to-use
 * @author Igor
 */
public class ApplicationFrame extends JFrame implements ActionListener {
	
	/** serialVersionUID */
	private static final long serialVersionUID = -4952292907965473427L;
	
	static String data;
	String database;
	JButton convBtn;
	int inputChoice = 0;
	int outputChoice = 0;
	File currentDirectoryToOpen;
	CompetitionData inputData = null;
	
	/**
	 * 
	 * @param title program's title
	 */
	public ApplicationFrame(String title) {
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel mainPanel = new JPanel(new GridBagLayout());
		GridBagConstraints mainC = new GridBagConstraints();
		mainC.fill = GridBagConstraints.HORIZONTAL;
		mainC.insets = new Insets(5,5,5,5);
		
		JPanel inputPanel = new JPanel(new GridBagLayout());
		inputPanel.setBorder(BorderFactory.createTitledBorder("Input data"));
		GridBagConstraints inputC = new GridBagConstraints();
		inputC.fill = GridBagConstraints.HORIZONTAL;
		inputC.insets = new Insets(5,5,5,5);
		
		JRadioButton interactiveBtn = new JRadioButton("Add interactively");
		interactiveBtn.addActionListener(this);
		inputC.gridx = 0;
		inputC.gridy = 0;
		inputPanel.add(interactiveBtn, inputC);
		
		JRadioButton csvFileBtn = new JRadioButton("From CSV file");
		csvFileBtn.addActionListener(this);
		inputC.gridx = 0;
		inputC.gridy = 1;
		inputPanel.add(csvFileBtn, inputC);
		
		JRadioButton sqlBtn = new JRadioButton("From MySQL database");
		sqlBtn.addActionListener(this);
		inputC.gridx = 0;
		inputC.gridy = 2;
		inputPanel.add(sqlBtn, inputC);
		
		ButtonGroup bgIn = new ButtonGroup();
		bgIn.add(interactiveBtn);
		bgIn.add(csvFileBtn);
		bgIn.add(sqlBtn);
		
		JPanel outputPanel = new JPanel(new GridBagLayout());
		outputPanel.setBorder(BorderFactory.createTitledBorder("Output data"));
		GridBagConstraints outputC = new GridBagConstraints();
		outputC.fill = GridBagConstraints.HORIZONTAL;
		outputC.insets = new Insets(5,5,5,5);
		
		JRadioButton consoleBtn = new JRadioButton("Console");
		consoleBtn.addActionListener(this);
		outputC.gridx = 0;
		outputC.gridy = 0;
		outputPanel.add(consoleBtn, outputC);
		
		JRadioButton csvFileOutBtn = new JRadioButton("CSV file");
		csvFileOutBtn.addActionListener(this);
		outputC.gridx = 0;
		outputC.gridy = 1;
		outputPanel.add(csvFileOutBtn, outputC);
		
		JRadioButton xmlFileBtn = new JRadioButton("XML file");
		xmlFileBtn.addActionListener(this);
		outputC.gridx = 0;
		outputC.gridy = 2;
		outputPanel.add(xmlFileBtn, outputC);
		
		JRadioButton htmlFileBtn = new JRadioButton("HTML file");
		htmlFileBtn.addActionListener(this);
		outputC.gridx = 0;
		outputC.gridy = 3;
		outputPanel.add(htmlFileBtn, outputC);
		
		ButtonGroup bgOut = new ButtonGroup();
		bgOut.add(consoleBtn);
		bgOut.add(csvFileOutBtn);
		bgOut.add(xmlFileBtn);
		bgOut.add(htmlFileBtn);
		
		mainC.gridx = 0;
		mainC.gridy = 0;
		mainPanel.add(inputPanel, mainC);

		mainC.gridx = 0;
		mainC.gridy = 1;
		mainPanel.add(outputPanel, mainC);
		
		convBtn = new JButton("Convert");
		convBtn.addActionListener(this);
		
		mainC.gridx = 0;
		mainC.gridy = 2;
		mainPanel.add(convBtn, mainC);
		
		getContentPane().add(mainPanel);
		setSize(250,375);
		setResizable(false);
		setVisible(true);
		
	}

	/**
	 * ActionListener listens to user's choice
	 * and react according to this choice
	 */
	public void actionPerformed(ActionEvent e) {
		
		String source = e.getActionCommand();
		
		if (source.equals("Convert")) {
			switch (inputChoice) {
				case 1 : //interactively
					inputData = new CompetitionData();
					String[] dat = data.split("\n");
					try {
						inputData.setData(dat);
					}
					catch (ParseException e2) {
						e2.printStackTrace();
					}
					break;
				case 2 : //csv file
					inputData = new CompetitionData();
					SingleFileSelector fileSelector = new SingleFileSelector(currentDirectoryToOpen, this, "csv", "Open Model File (CSV)", SingleFileSelector.OPEN, null);
					if (fileSelector.isFileSelected()) {
						currentDirectoryToOpen = fileSelector.getCurrentDirectoryToOpen();
						//read file
						try {
							inputData.setData(readInput(fileSelector.getSelectedFile()));
						}
						catch (ParseException e1) {
							e1.printStackTrace();
						}
					}
					break;
				case 3: //MySQL
					inputData = new CompetitionData();
					try {
						inputData.setData(new SqlQuery(database).getData());
					}
					catch (ParseException e2) {
						e2.printStackTrace();
					}
					break;
				default:
					JOptionPane.showMessageDialog(this, "Please, choose input value");
			}
			if (inputData != null) {
				switch (outputChoice) {
					case 1 : //console
						String[] outputData = inputData.getData();
						try {
							PrintStream out = new PrintStream(System.out, true, "UTF-8");
							for (int i=0; i<outputData.length; i++) {
								out.println(outputData[i]);
							}
						}
						catch (UnsupportedEncodingException e1) {
							e1.printStackTrace();
						}
						JOptionPane.showMessageDialog(this, "Conversion done!");
						break;
					case 2 : //csv file
						String filename = JOptionPane.showInputDialog(this, "Save file as", "championship.csv");
						if (filename!=null) {
							boolean ok = writeOutput(inputData.getData(), filename);
							if (ok) {
								JOptionPane.showMessageDialog(this, "Conversion done!");
							}
						}
						break;
					case 3: //xml
						String filename = JOptionPane.showInputDialog(this, "Save file as", "championship.xml");
						if (filename!=null) {
							new XmlCreator(new File(filename), inputData.getData());
						}
						break;
					case 4: //html
						String filename = JOptionPane.showInputDialog(this, "Save file as", "championship.html");
						File xmlFile = new File("1.xml");
						//src\net\azib\java\students\t030647\homework
						File xslFile = new File("src"+File.separator+"net"+File.separator+"azib"+File.separator
								+"java"+File.separator+"students"+File.separator+"t030647"+
								File.separator+"homework"+File.separator+"competition.xsl");
						File htmlFile = new File(filename);
						XmlCreator xml = new XmlCreator(xmlFile, inputData.getData());
						xml.CreateHTML(xmlFile, xslFile, htmlFile);
						break;
					default:
						JOptionPane.showMessageDialog(this, "Please, choose output value");
				}
			}
			else {
				JOptionPane.showMessageDialog(this, "Invalid input data!");
			}
		}
		else if (source.equals("Add interactively")) {
			new InteractiveFrame();
			inputChoice = 1;
		}
		else if (source.equals("From CSV file")) {
			inputChoice = 2;
		}
		else if (source.equals("From MySQL database")) {
			Object[] competitions = getCompetitions();
			String s = (String)JOptionPane.showInputDialog(this, "Please, choose competition:",
			   "Competitions",JOptionPane.PLAIN_MESSAGE,null, competitions,"");
			if (s != null) {
				inputChoice = 3;
				database = s;
			}
		}
		else if (source.equals("Console")) {
			outputChoice = 1;
		}
		else if (source.equals("CSV file")) {
			outputChoice = 2;
		}
		else if (source.equals("XML file")) {
			outputChoice = 3;
		}
		else if (source.equals("HTML file")) {
			outputChoice = 4;
		}
	}
	
	/**
	 * @return list of competitions from database
	 */
	private Object[] getCompetitions() {
		Object[] comp = null;
		ArrayList<String> al = null;
		try {
			Statement stmt;
			  ResultSet rs = null;
			  Class.forName("com.mysql.jdbc.Driver");
			
			  String url = "jdbc:mysql://srv.azib.net:3306/decathlon";
			
			  Connection con = DriverManager.getConnection(url,"java", "java");
			
			  //Get a Statement object
			  stmt = con.createStatement();
			  rs = stmt.executeQuery("SELECT * FROM competitions");
			  al = new ArrayList<String>();
			  while (rs.next()) {
				  al.add(rs.getString("description"));
			  }
			  con.close();
		}catch( Exception e ) {
	      e.printStackTrace();
	    }
		comp = al.toArray();
		return comp;
	}

	/**
	 * Read csv file
	 * @param file filename
	 * @return Array of string with participants information
	 */
	private String[] readInput(File file) {
		ArrayList<String> inp = new ArrayList<String>();
	    String[] inputData;
		try {
	        BufferedReader in = new BufferedReader(
	        		new InputStreamReader(new FileInputStream(file), "UTF-8"));
	        String str;
	        while ((str = in.readLine())!=null) {
	        	inp.add(str);
	        }
	        in.close();
	    } catch (UnsupportedEncodingException e) {
	    } catch (IOException e) {
	    }
	    Reader reader = null;
	    try {
			reader = new InputStreamReader(new BufferedInputStream(new FileInputStream(file)), "UTF-8");
			int c;
			while ((c = reader.read()) != -1) 
				System.out.print((char)c);
			System.out.println();
	    }
		catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    inputData = new String[inp.size()];
	    inp.toArray(inputData);
		return inputData;
	}
	
	/**
	 * Save data to csv file
	 * @param outputData participants information
	 * @param filename filename
	 * @return acknowledge
	 */
	private boolean writeOutput(String[] outputData, String filename) {
		
		if (!filename.contains(".csv")) {
			filename.concat(".csv");
		}
	    try {
		    Writer out = new BufferedWriter(new OutputStreamWriter(
		        		new FileOutputStream(filename), "UTF8"));
		    for (int i=0; i<outputData.length; i++) {
		    	out.write(outputData[i]+"\n");
		    }
			out.close();
	    } catch (IOException e) {
	    	e.printStackTrace();
	    	return false;
	    }
	    return true;
	}

}
