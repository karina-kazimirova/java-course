package Monitoring;


import javax.xml.stream.XMLStreamException;

public abstract class Parser {

    public abstract Monitoring parseFile(String path) throws XMLStreamException;


}


