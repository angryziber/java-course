package net.azib.java.students.t103554.HomeWork.ServerPart;

/**
 * User: Koliyanov Vyacheslav
 * Matr: 103554
 * Group: IASB27
 * Date: 4/7/11
 */
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class Parser {
    private  static void main(String args[])
    {
    try{
        File OurXml = new File("/Users/slava4000/JavaCourseServer/src/file.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();

    Document doc = db.parse(OurXml);
        doc.getDocumentElement().normalize();
        System.out.println("Root element "+ doc.getDocumentElement().getNodeName());
        NodeList nodeLst = doc.getElementsByTagName("employee");
        System.out.println("Information of all employee");
        for (int s = 0 ; s < nodeLst.getLength(); s++)
        {
            org.w3c.dom.Node fstNode = nodeLst.item(s);
            if (fstNode.getNodeType() == Node.ELEMENT_NODE)
            {
                Element fstElmnt = (Element) fstNode;
                NodeList fstNmElmntLst = fstElmnt.getElementsByTagName("firstname");
                Element fstNmElmnt = (Element) fstNmElmntLst.item(0);
                NodeList fstNm = fstNmElmnt.getChildNodes();
                  System.out.println("First name : "+ ((Node) fstNm.item(0)).getNodeValue());
                NodeList lstNmElmntLst = fstElmnt.getElementsByTagName("lastname");
                Element lstNmElmnt = (Element) lstNmElmntLst.item(0);
                NodeList lstNm = lstNmElmnt.getChildNodes();
                System.out.println("Last name : " + ((Node) lstNm.item(0)).getNodeValue());

            }


        }
    } catch (Exception e) {
        e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
    }
    }
    }

