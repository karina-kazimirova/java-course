package Monitoring;

import javax.xml.stream.XMLStreamException;

/**
 * Created by Sve on 29.06.2017.
 */
public class ParserThread extends Thread {
    public void setDownloaderThread(DownloaderThread downloaderThread) {
        this.downloaderThread = downloaderThread;
    }

    private DownloaderThread downloaderThread;


    @Override
    public void run() {
        UI ui = new UI();
        RefreshState refreshState = new RefreshState();

     // засыпаем и ждем пока поток downoaderThread не вызовет у нас notify()
        synchronized(this) {

            try {
                wait();
            } catch (InterruptedException ex) {}
        }

        //парсим JSON


            try {
                ui.print(Controller.parseSities("json"));
                refreshState.setRunning(true);

            } catch (XMLStreamException e) {
                refreshState.setRunning(false);

            }

        try {
            Thread.sleep(200);

        } catch (InterruptedException ex) {}

        synchronized(downloaderThread) {
            //пробуждаем поток скачки
            downloaderThread.notifyAll();
        }

        synchronized(this) {
            // затем сами засыпаем
            try {
                wait();
            } catch (InterruptedException ex) {}
        }


        //парсим XML


            try {
                ui.print(Controller.parseSities("xml"));
                refreshState.setRunning(true);
            } catch (XMLStreamException e) {
                refreshState.setRunning(false);
            }

        try {
            Thread.sleep(200);
        } catch (InterruptedException ex) {}
        System.out.println("ParserThread isRunning = " + refreshState.isRunning());

    }
}
