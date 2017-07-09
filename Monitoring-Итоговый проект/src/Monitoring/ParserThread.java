package Monitoring;

import javax.xml.stream.XMLStreamException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Sve on 29.06.2017.
 */
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
            ui.changeState(new ReadyState());
            ui.getAction(ui);


            } catch (XMLStreamException e) {
           }

        try {
            Thread.sleep(200);
        } catch (InterruptedException ex) {}


    }


    // Спрашиваем у пользователя какой формат парсить
    public String searchFormat(){

        String typeFormat = null;
        boolean isSearch = true;


        while (isSearch){
            String type = ui.vvod("Введите название файла, который хотите распечатать(xml/json/)");
            Pattern patFormat = Pattern.compile("(xml|json)");
            Matcher matcher2 = patFormat.matcher(type);

            if (matcher2.find()) {
                if (matcher2.group(1).equals("xml")) {
                    System.out.println("Формат файла xml");
                    typeFormat = "xml";
                    isSearch = false;
                    break;
                } else if (matcher2.group(1).equals("json")) {
                    System.out.println("Формат файла json");
                    typeFormat = "json";
                    isSearch = false;
                    break;
                } else {
                    System.out.println("Некорректный формат файла. Попробуйте еще раз.");
                    ui.vvod("Введите формат файла, который хотите распечатать(xml/json)");
                }


            } else {
                System.out.println("Неправильно ввели название файла. Попробуйте еще раз.");
                ui.vvod("Введите формат файла, который хотите распечатать(xml/json)");
            }
        }


        return typeFormat;
    }
}
