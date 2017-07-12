package Monitoring.controller;

/**
 * Created by Sve on 29.06.2017.
 */
public class DownloaderThread extends Thread{

    private ParserThread parserThread;
    public void setParserThread(ParserThread parserThread) {
        this.parserThread = parserThread;
    }
    private static final String LINKJSON = "http://kiparo.ru/t/rad.json";
    private static final String LINKXML = "http://kiparo.ru/t/rad.xml";
    Downloader downloader = new Downloader();


    @Override
    public void run(){

        //скачиваем JSON
        try {
            downloader.downloadNew(LINKJSON, "src/rad.json");

        }
        // Если Downloader кидает ошибку - выводим код ошибки и сообщение
        catch (MyException e) {
            if(e.getCode()==400){
                System.out.println("Нет соединения. Ошибка № " + e.getCode());
                System.out.println("Файл json не загружен");
            }else{
                System.out.println("Произошла ошибка попробуйте еще раз");
            }
        }

        //скачиваем XML
       try {
           downloader.downloadNew(LINKXML, "src/rad.xml");

        }
       // Если Downloader кидает ошибку - выводим код ошибки и сообщение
        catch (MyException e) {
           if(e.getCode()==400){
               System.out.println("Нет соединения. Ошибка № " + e.getCode());
               System.out.println("Файл xml не загружен");
           }else{
               System.out.println("Произошла ошибка попробуйте еще раз");
           }
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
