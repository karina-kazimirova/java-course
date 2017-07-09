package Monitoring;


public class RefreshState implements State {

    // Создаем 2 потока
    ParserThread parserThread = new ParserThread();
    DownloaderThread downloaderThread = new DownloaderThread();


    @Override
    public void writeState(UI ui) {
        // Выводим сообщение об обновлении данных
        System.out.println("Подождите, идет обновление данных ...");

    }

    @Override
    public void runStateUI(UI ui) {

        // Запускаем потоки
        downloaderThread.setParserThread(parserThread);
        parserThread.setDownloaderThread(downloaderThread);

        downloaderThread.start();
        parserThread.start();



    }
}
