package Monitoring.controller;


import Monitoring.UI.UI;
import Monitoring.models.Monitoring;

import javax.xml.stream.XMLStreamException;

public abstract class Parser {

    protected abstract Monitoring parseFile(String path, UI ui) throws XMLStreamException;


}


