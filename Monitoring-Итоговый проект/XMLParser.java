package Monitoring;


import jdk.internal.org.xml.sax.Attributes;
import jdk.internal.org.xml.sax.SAXException;
import jdk.internal.org.xml.sax.helpers.DefaultHandler;
import org.simpleframework.xml.core.Persister;
import org.w3c.dom.Document;
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

        ArrayList<City> city = new ArrayList<>();
        City city1 = null;
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try {
            XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(new FileInputStream(path));
            while (xmlEventReader.hasNext()) {
                XMLEvent xmlEvent = xmlEventReader.nextEvent();
                if (xmlEvent.isStartElement()) {
                    StartElement startElement = xmlEvent.asStartElement();
                    if (startElement.getName().getLocalPart().equals("sities")) {
                        city1 = new City();
                        //Get the 'id' attribute from Employee element
                      Attribute idAttr = startElement.getAttributeByName(new QName("id"));
                      if (idAttr != null) {
                           city1.setId(Integer.parseInt(idAttr.getValue()));
                        }
                    }
                    //set the other varibles from xml elements
                    else if (startElement.getName().getLocalPart().equals("id")) {
                        xmlEvent = xmlEventReader.nextEvent();
                        city1.setId(Integer.parseInt(xmlEvent.asCharacters().getData()));
                    } else if (startElement.getName().getLocalPart().equals("names")) {
                        xmlEvent = xmlEventReader.nextEvent();
                        city1.setNames(xmlEvent.asCharacters().getData());
                    } else if (startElement.getName().getLocalPart().equals("value")) {
                        xmlEvent = xmlEventReader.nextEvent();
                        city1.setValue(Integer.parseInt(xmlEvent.asCharacters().getData()));
                    } else if (startElement.getName().getLocalPart().equals("level")) {
                        xmlEvent = xmlEventReader.nextEvent();
                        city1.setLevel(xmlEvent.asCharacters().getData());
                    } else if (startElement.getName().getLocalPart().equals("minValue")) {
                        xmlEvent = xmlEventReader.nextEvent();
                        city1.setMinValue(Integer.parseInt(xmlEvent.asCharacters().getData()));
                    } else if (startElement.getName().getLocalPart().equals("maxValue")) {
                        xmlEvent = xmlEventReader.nextEvent();
                        city1.setMaxValue(Integer.parseInt(xmlEvent.asCharacters().getData()));
                    } else if (startElement.getName().getLocalPart().equals("DateMinValue")) {
                        xmlEvent = xmlEventReader.nextEvent();
                        city1.setDateMinValue(xmlEvent.asCharacters().getData());
                    } else if (startElement.getName().getLocalPart().equals("DateMaxValue")) {
                        xmlEvent = xmlEventReader.nextEvent();
                        city1.setDateMaxValue(xmlEvent.asCharacters().getData());
                    }
                }
                //if Employee end element is reached, add employee object to list
                if (xmlEvent.isEndElement()) {
                    EndElement endElement = xmlEvent.asEndElement();
                    if (endElement.getName().getLocalPart().equals("sities")) {
                        city.add(city1);


                    }
                }

            }

        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }




        ArrayList<City> city2 = new ArrayList<City>(city);
        System.out.println(city2.toString());
        monitoring.setSities(city2);

        monitoring.setName("frg");
        monitoring.setLocation("rgtg");
        return monitoring;
    }
}