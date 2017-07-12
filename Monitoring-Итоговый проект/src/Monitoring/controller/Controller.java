package Monitoring.controller;

import Monitoring.models.City;
import Monitoring.models.Monitoring;
import Monitoring.UI.UI;
import javax.xml.stream.XMLStreamException;
import java.util.*;


public class Controller {

      // Используем паттерн Singleton
    private Controller() {
    }


    private static class ControllerHolder {
        private final static Controller instance = new Controller();
    }

    public static Controller getInstance() {
        return ControllerHolder.instance;
    }


    // Вызываем метод заполнения объектов из файла
    protected static void parseSities(String type) throws MyException, XMLStreamException {
        UI ui = new UI();
        Parser parser;
        Monitoring monitoring = null;

        // Если передаваемая строка - json - метод выполняет дочерний класс JsonParser
        if (type.equals("json")) {
            parser = new JsonParser();
            monitoring = parser.parseFile("src/Monitoring/rad.json", ui);

        }
        // Если передаваемая строка - json - метод выполняет дочерний класс JsonParser
        if (type.equals("xml")) {
            parser = new XMLParser();
            monitoring = parser.parseFile("src/Monitoring/rad.xml", ui);
        }

        ui.getAction(ui, monitoring);
    }


    // Вывод неотсортированного массива
    public static void printData(Monitoring monitoring) {
        System.out.println("Данные на " + monitoring.getDate());
        vyvod(monitoring.getCity());
    }


    // Вывод данных из листа
    private static void vyvod(ArrayList<City> city) {

        for (int i = 0; i < city.size(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append("Город: ").append(city.get(i).getName())
                    .append(" Значение: ").append(city.get(i).getValue())
                    .append(" Уровень излучения: ").append(city.get(i).getLevel())
                    .append(" Максимальное значение в истории наблюдений: ").append(city.get(i).getMaxValue())
                    .append(" Дата максимального значения ").append(city.get(i).getDateMaxValue())
                    .append(" Мнимальное значение в истории наблюдений: ").append(city.get(i).getMinValue())
                    .append(" Дата минимального значения ").append(city.get(i).getDateMinValue());

            System.out.println(sb);
        }
    }


    // вывод одного города
    protected static void vyvod(City city) {
            StringBuilder sb = new StringBuilder();
            sb.append("Город: ").append(city.getName())
                    .append(" Значение: ").append(city.getValue())
                    .append(" Уровень излучения: ").append(city.getLevel())
                    .append(" Максимальное значение в истории наблюдений: ").append(city.getMaxValue())
                    .append(" Дата максимального значения ").append(city.getDateMaxValue())
                    .append(" Мнимальное значение в истории наблюдений: ").append(city.getMinValue())
                    .append(" Дата минимального значения ").append(city.getDateMinValue());

            System.out.println(sb);

    }

}







