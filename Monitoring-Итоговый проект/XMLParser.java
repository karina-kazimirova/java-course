package Monitoring;


import jdk.internal.org.xml.sax.Attributes;
import jdk.internal.org.xml.sax.SAXException;
import jdk.internal.org.xml.sax.helpers.DefaultHandler;
import org.simpleframework.xml.core.Persister;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import sun.plugin2.message.Serializer;
import sun.rmi.runtime.Log;

import java.io.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.parsers.*;
import javax.xml.stream.*;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;


public class XMLParser extends Parser {

    @Override
    public Monitoring parseFile(String path) throws XMLStreamException {

        Monitoring monitoring = null;
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        ArrayList<City> city = null;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(path);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nodeList = doc.getElementsByTagName("sities");

            city = new ArrayList<City>();
            for (int i = 0; i < nodeList.getLength(); i++) {
                city.add(getCity(nodeList.item(i)));
            }


            for (City city1 : city) {
                System.out.println(city1.toString());
            }
        } catch (ParserConfigurationException | IOException e1) {
            e1.printStackTrace();
        } catch (org.xml.sax.SAXException e) {
            e.printStackTrace();
        }

        System.out.println(city.toString());
       // monitoring.getSities(city);
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