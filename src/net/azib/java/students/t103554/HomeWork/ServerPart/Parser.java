package net.azib.java.students.t103554.HomeWork.ServerPart;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * User: Koliyanov Vyacheslav
 * Matr: 103554
 * Group: IASB27
 * Date: 4/7/11
 */
public class Parser {
	 public  static void main(String args[])
    {
    try{
        File OurXml = new File("/JavaHomeWork/src/net/azib/java/students/t103554/HomeWork/ServerPart/file.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();

    Document doc = db.parse(OurXml);
        doc.getDocumentElement().normalize();
        System.out.println("Импорт "+ doc.getDocumentElement().getNodeName());
        NodeList nodeLst = doc.getElementsByTagName("player");
       // System.out.println("Информация о игроках");
     //   System.out.println("|№\t|Игрок\t\t\t\t|Дата рождения\t|Страна\t|100 m sprint (sec)\t|Long jump\t");
	    for (int s = 0 ; s < nodeLst.getLength(); s++)
        {
            Node fstNode = nodeLst.item(s);

            if (fstNode.getNodeType() == Node.ELEMENT_NODE)
            {
                Element Player = (Element) fstNode;
                NodeList PlayerNamelst = Player.getElementsByTagName("playerName");
                Element PlayerName = (Element) PlayerNamelst.item(0);
                NodeList PlayerDateOfBirth = Player.getElementsByTagName("dateofbirth");
                Element BirthDate = (Element) PlayerDateOfBirth.item(0);
	            NodeList StateList = Player.getElementsByTagName("State");
                Element PlayerState = (Element) StateList.item(0);
	            NodeList HundretMSprint = Player.getElementsByTagName("HundretMSprint");
                Element PHundretMSprint = (Element) HundretMSprint.item(0);
	            NodeList LongJumplst = Player.getElementsByTagName("LongJump");
                Element LongJump = (Element) LongJumplst.item(0);
	            NodeList PName = PlayerName.getChildNodes();
	            NodeList PBirthday = BirthDate.getChildNodes();
	            NodeList Ste = PlayerState.getChildNodes();
	            NodeList PlHSPRINT = PHundretMSprint.getChildNodes();
	            NodeList PLongJump = LongJump.getChildNodes();
	                 System.out.println("|"+(s+1)+"\t|"+ ((Node) PName.item(0)).getNodeValue()+"\t"+ ((Node) PBirthday.item(0)).getNodeValue()+"\t"+ ((Node) Ste.item(0)).getNodeValue()+"\t"+ ((Node) PlHSPRINT.item(0)).getNodeValue()+"\t"+ ((Node) PLongJump.item(0)).getNodeValue()+"\t|");
	        }

            }
    } catch (Exception e) {
        e.printStackTrace();
    }
    }
}
