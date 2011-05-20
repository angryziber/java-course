package net.azib.java.students.t107678.homework;


import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class XMLWriter implements Writer {

	DocumentBuilderFactory fact;
	DocumentBuilder parser;
	Document doc;
	Node competition;
	String fileName;


	public XMLWriter(String fileName) throws IOException, ParserConfigurationException {
		this.fileName = fileName;
		fact = DocumentBuilderFactory.newInstance();
		parser = fact.newDocumentBuilder();
		doc = parser.newDocument();

	}

	Node getField(String fieldName, String fieldValue) {
		Node field = doc.createElement(fieldName);
		field.appendChild(doc.createTextNode(fieldValue));
		return field;
	}

	@Override
	public void writeNext(Place place, Record record) {

		Format format = new SimpleDateFormat("dd.MM.yyyy");

		Node athlete = doc.createElement("athlete");
		competition.appendChild(athlete);

		Participant participant = record.getParticipant();
		athlete.appendChild(getField("place", place.getFinalPlace()));
		athlete.appendChild(getField("score", String.valueOf(record.getTotalPoints())));
		athlete.appendChild(getField("name", participant.getName()));
		athlete.appendChild(getField("dob", format.format(participant.getBirthDate())));
		athlete.appendChild(getField("country_code", participant.getCountry().getValue()));

		ArrayList<Event> events = (ArrayList<Event>) record.getEvents();

		for (int i = 0; i < events.size(); i++) {
			Event event = events.get(i);
			Node eventNode = doc.createElement(event.getEventName());
			eventNode.appendChild(getField("performance", String.valueOf(event.getPerformance())));
			athlete.appendChild(eventNode);
		}
	}

	void saveToDisc(Document doc) throws TransformerException {

		Source source = new DOMSource(doc);

		File file = new File(this.fileName);
		Result result = new StreamResult(file);

		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		transformer.transform(source, result);

	}


	@Override
	public void writeOutput(ResultsComputation resultsComputation) throws ParserConfigurationException, TransformerException {

		competition = doc.createElement("competition");
		doc.appendChild(competition);

		ArrayList<Record> records = resultsComputation.getRecords();

		// 2-4 issue  (sharing places logic)
		Record tempRecord;

		for (int i = 0; i < records.size(); i++) {
			int sharesWith = 0;
			tempRecord = records.get(i);
			int j = i;
			while ((i < records.size() - 1) && (tempRecord.getTotalPoints() == records.get(i + 1).getTotalPoints())) {
				sharesWith++;
				i = i + 1;
				tempRecord = records.get(i);
			}
			for (int k = j; k <= i; k++) {
				writeNext(new Place(j + 1, sharesWith), records.get(k));   //j+1 because of indexing from 0 bug
			}

		}

		saveToDisc(doc);


	}
}
