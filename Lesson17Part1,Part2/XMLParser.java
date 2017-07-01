package Monitoring;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.io.*;
import java.util.ArrayList;
import javax.xml.parsers.*;
import javax.xml.stream.XMLStreamException;


public class XMLParser extends Parser {
    Monitoring monitoring = new Monitoring();

    @Override
    public Monitoring parseFile(String path) throws XMLStreamException {


        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        ArrayList<City> city = null;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(path);
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("city");

            city = new ArrayList<City>();
            for (int i = 0; i < nodeList.getLength(); i++) {
                city.add(getCity(nodeList.item(i)));
            }



        } catch (ParserConfigurationException | IOException e1) {
            e1.printStackTrace();
        } catch (org.xml.sax.SAXException e) {
            e.printStackTrace();
        }
        monitoring.setCity(city);
        return monitoring;
    }


    private static City getCity(Node node) {
        //XMLReaderDOM domReader = new XMLReaderDOM();
        City city1 = new City();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            city1.setName(getTagValue("name", element));
            city1.setId(Integer.parseInt(getTagValue("id", element)));
            city1.setValue(Integer.parseInt(getTagValue("value", element)));
            city1.setLevel(getTagValue("level", element));
            city1.setMinValue(Integer.parseInt(getTagValue("minValue", element)));
            city1.setDateMinValue(getTagValue("dateMinValue", element));
            city1.setMaxValue(Integer.parseInt(getTagValue("maxValue", element)));
            city1.setDateMaxValue(getTagValue("dateMaxValue", element));

        }

        return city1;
    }




    private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        return node.getNodeValue();
    }



}