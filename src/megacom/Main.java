package megacom;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException{

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document document = dBuilder.parse("http://www.geoplugin.net/xml.gp?base_currency=USD");
        document.getDocumentElement().normalize();
        System.out.println("Root element: "+document.getDocumentElement().getNodeName());
        Node node = document.getFirstChild();
        NodeList nodeList = node.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++){
            Node node1 = nodeList.item(i);
            if (node1.getNodeType() == Node.ELEMENT_NODE){
                Element eElement = (Element) node1;
                System.out.println(eElement.getNodeName()+":"+eElement.getTextContent());
            }
        }
    }
}
