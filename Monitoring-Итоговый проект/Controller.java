package Monitoring;

import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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


    // Загружаем файл
    public static void downloadNew(String link, String pathFile, UI ui) throws MyException {


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

                System.out.println("Данные обновлены");

                ui.changeState(new LoadState());



            } else {
                System.out.println("Response code");
                ui.changeState(new FailureState());
            }


        } catch (Exception e) {
            System.out.println("Ошибка" + e.toString());
            ui.changeState(new FailureState());
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
   public static void printSities(String type) throws XMLStreamException {

       Parser parser;
       if(type.equals("json")){
            parser = new JsonParser();
            Monitoring monitoring = parser.parseFile("C://Users/Sve/IdeaProjects/Lesson13/src/rad.json");
            //System.out.println(monitoring.toString());
           printData(monitoring);
       }
       if(type.equals("xml")){
           parser = new XMLParser();
           Monitoring monitoring = parser.parseFile("C://Users/Sve/IdeaProjects/Lesson13/src/rad.xml");
           System.out.println(monitoring.getSities().toString());
       }
   }

    public static void printData(Monitoring monitoring){

        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy.MM.dd");

        System.out.println("Данные на " + formatForDateNow.format(dateNow));

        ArrayList<City> city = new ArrayList<City>(monitoring.getSities());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<city.size(); i++){
            sb.append("Город: ").append(city.get(i).getName())
                    .append("Значение: ").append(city.get(i).getValue())
                    .append(" Уровень излучения: ").append(city.get(i).getLevel())
                    .append(" Максимальное занчение в истории наблюдений: ").append(city.get(i).getMaxValue())
                    .append(" Дата максимального занчения ").append(city.get(i).getDateMaxValue())
                    .append(" Мнимальное занчение в истории наблюдений: ").append(city.get(i).getMinValue())
                    .append(" Дата минимального занчения ").append(city.get(i).getDateMinValue()).append("/n");
            System.out.println("Город: " + city.get(i).getName() + " Уровень излучения: " + city.get(i).getLevel()
            + " Максимальное занчение в истории наблюдений: " + city.get(i).getMaxValue() + " Дата максимального занчения "
            + city.get(i).getDateMaxValue() + " Дата минимального занчения " + city.get(i).getDateMinValue());

        }

    }



}
