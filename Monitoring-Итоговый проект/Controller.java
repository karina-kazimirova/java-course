package Monitoring;

import javax.xml.stream.XMLStreamException;

public class Controller {



    // Используем паттерн Singleton
    private Controller(){

    }

    private static class ControllerHolder{
        private final static Controller instance = new Controller();
    }

    public static Controller getInstance(){
        return ControllerHolder.instance;
    }




    // Вызываем метод заполнения объектов из массива
   public static void printSities(String type) throws XMLStreamException {

       Parser parser;
       if(type.equals("json")){
            parser = new JsonParser();
            Monitoring monitoring = parser.parseFile("C://Users/Sve/IdeaProjects/Lesson13/src/rad.json");
            System.out.println(monitoring.toString());
       }
       if(type.equals("xml")){
           parser = new XMLParser();
           Monitoring monitoring = parser.parseFile("C://Users/Sve/IdeaProjects/Lesson13/src/rad.xml");
           System.out.println(monitoring.toString());
       }
   }

}
