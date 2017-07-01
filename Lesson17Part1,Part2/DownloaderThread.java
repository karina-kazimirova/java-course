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
        RefreshState refreshState = new RefreshState();

        //скачиваем JSON
        try {
            Controller.downloadNew("http://kiparo.ru/t/rad.json", "C://Users/Sve/IdeaProjects/Lesson13/src/new.json");
            refreshState.setRunning(false);
        } catch (MyException e) {
          
        }


        try {
            Thread.sleep(200);
        } catch (InterruptedException ex) {}

        synchronized(parserThread) {
            //пробуждаем поток парсера ParserThread
            parserThread.notifyAll();
        }

        // затем сами засыпаем
        synchronized(this) {

            try {
                wait();
            } catch (InterruptedException ex) {}
        }

        //скачиваем XML
       try {
            Controller.downloadNew("http://kiparo.ru/t/rad.xml", "C://Users/Sve/IdeaProjects/Lesson13/src/new.xml");
             refreshState.setRunning(false);
        } catch (MyException e) {

        }
        try {
            Thread.sleep(200);
        } catch (InterruptedException ex) {}

        synchronized(parserThread) {
            //пробуждаем поток парсера ParserThread

            parserThread.notifyAll();
        }

        System.out.println("DownloadThread isRunning = " + refreshState.isRunning());


    }

}
