package Monitoring.controller;

import Monitoring.UI.UI;
import Monitoring.UI.state.FailureState;
import Monitoring.UI.state.ReadyState;
import Monitoring.models.City;
import Monitoring.models.Monitoring;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.xml.parsers.*;
import javax.xml.stream.XMLStreamException;


public class XMLParser extends Parser {
    Monitoring monitoring = new Monitoring();


    // Переопределяем абстрактынй метод родительского класса
    @Override
    public Monitoring parseFile(String path, UI ui) throws XMLStreamException {


        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        ArrayList<City> city = null;

        // Считываем значения тэгов и записываем в нужные переменные Monitoring
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(path);
            doc.getDocumentElement().normalize();

            // Поля элемента Root
            Element root = doc.getDocumentElement();
            NodeList nameNodeList = root.getElementsByTagName("name");
            Node namenode = nameNodeList.item(0);
            String name = namenode.getFirstChild().getNodeValue();
            monitoring.setName(name);

            NodeList nameNodeList1 = root.getElementsByTagName("location");
            Node locate = nameNodeList1.item(0);
            String location = locate.getFirstChild().getNodeValue();
            monitoring.setLocation(location);

            Date dateNow = new Date();
            SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy.MM.dd");
            String date = formatForDateNow.format(dateNow).toString();
            monitoring.setDate(date);

            // Массив объектов City
            NodeList nodeList = doc.getElementsByTagName("city");

            city = new ArrayList<City>();
            for (int i = 0; i < nodeList.getLength(); i++) {
                city.add(getCity(nodeList.item(i)));
            }
            ui.changeState(new ReadyState());

        } catch (ParserConfigurationException | IOException e1) {
            e1.printStackTrace();
            ui.changeState(new FailureState());

        } catch (org.xml.sax.SAXException e) {
            e.printStackTrace();
            ui.changeState(new FailureState());

        }

        monitoring.setCity(city);
        return monitoring;
    }

    // Заполняем поля элементов массива
    private static City getCity(Node node) {

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



    // СЧИТЫВАЕМ значения тэга
    private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        return node.getNodeValue();
    }



}