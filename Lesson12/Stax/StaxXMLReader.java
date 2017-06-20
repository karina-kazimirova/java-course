package Stax;


        import java.io.FileInputStream;
        import java.io.FileNotFoundException;
        import java.util.ArrayList;
        import java.util.List;

        import javax.xml.namespace.QName;
        import javax.xml.stream.XMLEventReader;
        import javax.xml.stream.XMLInputFactory;
        import javax.xml.stream.XMLStreamException;
        import javax.xml.stream.events.Attribute;
        import javax.xml.stream.events.EndElement;
        import javax.xml.stream.events.StartElement;
        import javax.xml.stream.events.XMLEvent;

public class StaxXMLReader {

    public static void main(String[] args) {
        String fileName = "C://Users/Sve/IdeaProjects/Lesson12/src/Stax/test1.xml";
        List<People> people = parseXML(fileName);
        for(People peop : people){
            System.out.println(peop.toString());
        }
    }

    private static List<People> parseXML(String fileName) {
        List<People> people = new ArrayList<>();
        People peop = null;
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try {
            XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(new FileInputStream(fileName));
            while(xmlEventReader.hasNext()){
                XMLEvent xmlEvent = xmlEventReader.nextEvent();
                if (xmlEvent.isStartElement()){
                    StartElement startElement = xmlEvent.asStartElement();
                    if(startElement.getName().getLocalPart().equals("element")){
                        peop = new People();
                        //Get the 'id' attribute from Employee element
                        Attribute idAttr = startElement.getAttributeByName(new QName("id"));
                        if(idAttr != null){
                            peop.setId(Integer.parseInt(idAttr.getValue()));
                        }
                    }
                    //set the other varibles from xml elements
                    else if(startElement.getName().getLocalPart().equals("age")){
                        xmlEvent = xmlEventReader.nextEvent();
                        peop.setAge(Integer.parseInt(xmlEvent.asCharacters().getData()));
                    }else if(startElement.getName().getLocalPart().equals("names")){
                        xmlEvent = xmlEventReader.nextEvent();
                        peop.setNames(xmlEvent.asCharacters().getData());
                    }else if(startElement.getName().getLocalPart().equals("surname")){
                        xmlEvent = xmlEventReader.nextEvent();
                        peop.setSurname(xmlEvent.asCharacters().getData());
                    }else if(startElement.getName().getLocalPart().equals("id")){
                        xmlEvent = xmlEventReader.nextEvent();
                        peop.setId(Integer.parseInt(xmlEvent.asCharacters().getData()));
                    }
                }
                //if Employee end element is reached, add employee object to list
                if(xmlEvent.isEndElement()){
                    EndElement endElement = xmlEvent.asEndElement();
                    if(endElement.getName().getLocalPart().equals("element")){
                        people.add(peop);
                    }
                }
            }

        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
        return people;
    }

}