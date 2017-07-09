package Monitoring;

/**
 * Created by Sve on 29.06.2017.
 */
public class DownloaderThread extends Thread{

    private ParserThread parserThread;
    public void setParserThread(ParserThread parserThread) {
        this.parserThread = parserThread;
    }


    @Override
    public void run(){

        //скачиваем JSON
        try {
            Controller.downloadNew("http://kiparo.ru/t/rad.json", "C://Users/Sve/IdeaProjects/Monitoring/src/new.json");

        } catch (MyException e) {

        }

        //скачиваем XML
       try {
            Controller.downloadNew("http://kiparo.ru/t/rad.xml", "C://Users/Sve/IdeaProjects/Monitoring/src/new.xml");

        } catch (MyException e) {

        }
        try {
            Thread.sleep(200);
        } catch (InterruptedException ex) {}

        synchronized(parserThread) {
            //пробуждаем поток парсера ParserThread
            parserThread.notifyAll();
        }

    }

}
