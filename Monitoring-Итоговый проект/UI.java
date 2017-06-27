package Monitoring;

import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Sve on 26.06.2017.
 */
public class UI {
    private State state;

    Controller controller = Controller.getInstance();

    public UI() {
        this.state = state;
    }


    public State getState() {
        return state;
    }


    public void changeState(State newstate) {
        this.state = newstate;
    }


    public void start() {
        state.writeState(this);
        state.run(this);

    }

    public void startParse(UI ui) {

        try {
            Controller.printSities("json");
            ui.changeState(new ReadyState());

        } catch (XMLStreamException e) {
            e.printStackTrace();
            ui.changeState(new FailureState());

        }
        state.writeState(this);

    }


    public void downloadFile(String link, UI ui) {

        InputStream inputStream = null; // считывание
        FileOutputStream outputStream = null;// передача

        try {
            URL url = new URL(link);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();//Подключаемся

            //Получаем код ответа от сайта или серверва
            int responseCode = httpURLConnection.getResponseCode();


            // Проверяем успешное ли подключение, проверка на ошибки
            if (responseCode == HttpURLConnection.HTTP_OK) {

                inputStream = httpURLConnection.getInputStream(); // Получаем Инпутстрим

                File file = new File("C://Users/Sve/IdeaProjects/Lesson13/src/new.json");
                outputStream = new FileOutputStream(file);


                // Создаем буфер - массив байтов (делают 1-3 мБ)
                byte[] buffer = new byte[1024];// вычитывает объем и записывает в bufer
                int bytesRead = -1;// то есть скачиваем пока инфа не закончится (кол-во записанных байтт за одно чтение)

                while ((bytesRead = inputStream.read(buffer)) != -1) {// В буфер записываем инфу а в bytesRead  заносится количество записанной инфы

                    outputStream.write(buffer, 0, bytesRead); // записываем (откуда, от 0, до bytesRead)
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
            state.writeState(this);
            state.run(this);

        }
    }
}

