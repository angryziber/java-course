package net.azib.java.students.t960644.homework;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * XMLOutputTest
 * 
 * @author Lembit
 */
public class XMLOutputTest {
	@Test
	public void testWriteElement() throws Exception {
		XMLOutput xmlOut = new XMLOutput();
		xmlOut.CreateDoc();
		Element elem = xmlOut.writeElement("tagname", "data");
		assertTrue(testElement(elem, "tagname", "data"));
	}

	@Test
	public void testWriteLine() throws Exception {
		XMLOutput xmlOut = new XMLOutput();
		xmlOut.CreateDoc();
		Result res = OutputTest.singleResult();
		Element resElem = xmlOut.writeLine(res);
		assertTrue(testElementTag(resElem, "result"));
		NodeList elemList;
		elemList = resElem.getElementsByTagName("position");
		assertTrue(testElementData(elemList.item(0),"1"));
		elemList = resElem.getElementsByTagName("score");
		assertTrue(testElementData(elemList.item(0),"8815"));
		elemList = resElem.getElementsByTagName("athlete");
		assertTrue(testElementData(elemList.item(0),"Peeter Hülss"));
		elemList = resElem.getElementsByTagName("born");
		assertTrue(testElementData(elemList.item(0),"01.05.1986"));
		elemList = resElem.getElementsByTagName("country");
		assertTrue(testElementData(elemList.item(0),"EE"));
		elemList = resElem.getElementsByTagName("race-100m");
		assertTrue(testElementData(elemList.item(0),"10.600"));
		elemList = resElem.getElementsByTagName("long-jump");
		assertTrue(testElementData(elemList.item(0),"7.63"));
		elemList = resElem.getElementsByTagName("shot-put");
		assertTrue(testElementData(elemList.item(0),"14.90"));
		elemList = resElem.getElementsByTagName("high-jump");
		assertTrue(testElementData(elemList.item(0),"2.03"));
		elemList = resElem.getElementsByTagName("race-400m");
		assertTrue(testElementData(elemList.item(0),"46.230"));
		elemList = resElem.getElementsByTagName("hurdles-110m");
		assertTrue(testElementData(elemList.item(0),"14.400"));
		elemList = resElem.getElementsByTagName("discus-throw");
		assertTrue(testElementData(elemList.item(0),"43.40"));
		elemList = resElem.getElementsByTagName("pole-vault");
		assertTrue(testElementData(elemList.item(0),"5.40"));
		elemList = resElem.getElementsByTagName("javelin-throw");
		assertTrue(testElementData(elemList.item(0),"67.01"));
		elemList = resElem.getElementsByTagName("race-1500m");
		assertTrue(testElementData(elemList.item(0),"4:29.580"));
				
	}

	protected boolean testElementTag(Element el, String tagName) {
		return el.getTagName().equals(tagName);
	}

	protected boolean testElementData(Node el, String data) {
		return el.getTextContent().equals(data);
	}

	protected boolean testElement(Element el, String tagName, String data) {
		return testElementTag(el, tagName) && testElementData(el, data);
	}
	
	/*@Test
	public void testWriteData() throws Exception {
		XMLOutput xmlOut = new XMLOutput();
		xmlOut.CreateDoc();
		Competition comp = OutputTest.singleCompetition();
		Result result = OutputTest.singleResult();
		comp.addResult(result);
		xmlOut.writeData(comp);
		xmlOut.printXML(System.out);
	}*/
}
