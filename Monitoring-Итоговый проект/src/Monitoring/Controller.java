package Monitoring;


import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
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


    // Загружаем файл
    public static void downloadNew(String link, String pathFile) throws MyException {
        InputStream inputStream = null;
        FileOutputStream outputStream = null;

        try {
            URL url = new URL(link);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            int responseCode = httpURLConnection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {

                inputStream = httpURLConnection.getInputStream();


                File file = new File(pathFile);
                outputStream = new FileOutputStream(file);


                byte[] buffer = new byte[1024];
                int bytesRead = -1;

                while ((bytesRead = inputStream.read(buffer)) != -1) {

                    outputStream.write(buffer, 0, bytesRead);
                }

                System.out.println("Данные обновлены " + pathFile);


            } else {
                System.out.println("Response code");

            }


        } catch (Exception e) {
            System.out.println("Ошибка" + e.toString());

        } finally {

            try {

                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    // Вызываем метод заполнения объектов из файла
    public static void parseSities(String type) throws XMLStreamException {
        UI ui = new UI();
        Parser parser;
        Monitoring monitoring = null;
        if (type.equals("json")) {
            parser = new JsonParser();
            monitoring = parser.parseFile("C://Users/Sve/IdeaProjects/Lesson13/src/rad.json");
        }
        if (type.equals("xml")) {
            parser = new XMLParser();
            monitoring = parser.parseFile("C://Users/Sve/IdeaProjects/Lesson13/src/rad.xml");
        }
        ui.searchFunc(monitoring);
    }


    public static void printData(Monitoring monitoring) {

        System.out.println("Данные на " + monitoring.getDate());

        vyvod(monitoring.getCity());

    }



    public static void searchCity(String cityName, Monitoring monitoring, List<City> cities) {
        UI ui = new UI();

        for (City cities1 : cities) {
            if (cities1.getName().equals(cityName)) {

                vyvod(cities1);

                break;
            } else {
                ui.vvod("Неправильно введено название. Введите название города, который вы хотите найти: ");
                break;
            }

        }
    }

    public static void sortByName(Monitoring monitoring, List<City> cities) {

        Collections.sort(cities, new Comparator<City>() {
            @Override
            public int compare(City o1, City o2) {

                if (o1.getName().equals(o2.getName())) {
                    return 0;
                }
                return o1.getName().compareTo(o2.getName());

            }
        });
        System.out.println("Сортировка по названию города: ");

        vyvod(monitoring.getCity());

    }


    public static void sortbyValue(Monitoring monitoring, List<City> cities) {

        Collections.sort(cities, new Comparator<City>() {
            @Override
            public int compare(City o1, City o2) {

                int value1 = o1.getValue();
                int value2 = o2.getValue();

                if (value1 > value2) {
                    return 1;
                } else if (value1 < value2) {
                    return -1;
                } else {
                    return 0;
                }

            }
        });
        System.out.println("Сортировка по значению: ");
        vyvod(monitoring.getCity());

    }

    public static void vyvod(ArrayList<City> city) {

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

    public static void vyvod(City city) {
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







