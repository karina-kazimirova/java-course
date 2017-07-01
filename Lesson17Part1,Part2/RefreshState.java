package Monitoring;


public class RefreshState implements State {

    ParserThread parserThread = new ParserThread();

    DownloaderThread downloaderThread = new DownloaderThread();

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    private volatile boolean isRunning;




    @Override
    public void writeState(UI ui) {
        System.out.println("Подождите, идет обновление данных ...");

    }

    @Override
    public void runStateUI(UI ui) {



        // Обмемнялись ссылками друг на друга
        downloaderThread.setParserThread(parserThread);
        parserThread.setDownloaderThread(downloaderThread);


        //Запускаем
       downloaderThread.start();
       parserThread.start();



    }
}
