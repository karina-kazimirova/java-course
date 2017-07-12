package Monitoring.UI.state;
import Monitoring.controller.DownloaderThread;
import Monitoring.controller.MyException;
import Monitoring.controller.ParserThread;
import Monitoring.UI.UI;
import Monitoring.models.Monitoring;

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

        downloaderThread.setParserThread(parserThread);
        parserThread.setDownloaderThread(downloaderThread);

        // Запускаем потоки
        downloaderThread.start();
        parserThread.start();

    }

    @Override
    public void runStateUI(UI ui, Monitoring monitoring) throws MyException {

    }
}
