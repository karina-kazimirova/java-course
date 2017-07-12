package Monitoring.controller;

import Monitoring.UI.UI;
import Monitoring.UI.state.FailureState;
import javax.xml.stream.XMLStreamException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParserThread extends Thread {
    UI ui = new UI();
    public void setDownloaderThread(DownloaderThread downloaderThread) {
        this.downloaderThread = downloaderThread;
    }
    private DownloaderThread downloaderThread;


    @Override
    public void run() {


     // засыпаем и ждем пока поток downLoaderThread не вызовет у нас notify()
        synchronized(this) {

            try {
                wait();
            } catch (InterruptedException ex) {}
        }


        //парсим файл, предварительно запрашивая формат
           try {
            Controller.parseSities(searchFormat());

            } catch (MyException e) {
               if(e.getCode()==100){
                   System.out.println("Не правильно указан путь к файлу. Ошибка " + e.getCode());
                 ui.changeState(new FailureState());
               }else{
                   System.out.println("Произошла ошибка попробуйте еще раз");
                   ui.changeState(new FailureState());
               }
           } catch (XMLStreamException e) {
               e.printStackTrace();
               ui.changeState(new FailureState());
           }

        try {
            Thread.sleep(200);
        } catch (InterruptedException ex) { ui.changeState(new FailureState());}


    }


    // Спрашиваем у пользователя какой формат парсить
    private String searchFormat(){

        String typeFormat = null;

        while (true){
            String type = ui.vvod("Введите название файла, который хотите распечатать(xml/json/)");
            Pattern patFormat = Pattern.compile("(xml|json)");
            Matcher matcher2 = patFormat.matcher(type);

            if (matcher2.find()) {
                if (matcher2.group(1).equals("xml")) {
                    System.out.println("Формат файла xml");
                    typeFormat = "xml";
                    break;
                } else if (matcher2.group(1).equals("json")) {
                    System.out.println("Формат файла json");
                    typeFormat = "json";
                    break;
                }

            } else {
                System.out.println("Неправильно ввели название файла. Попробуйте еще раз.");
                continue;

            }
        }


        return typeFormat;
    }


}
