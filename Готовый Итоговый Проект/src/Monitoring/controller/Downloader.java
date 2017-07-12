package Monitoring.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Sve on 11.07.2017.
 */
public class Downloader {

    // Загружаем файл
    public void downloadNew(String link, String pathFile) throws MyException {

        InputStream inputStream = null;
        FileOutputStream outputStream = null;

        try {
            URL url = new URL(link);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            int responseCode = httpURLConnection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {

                inputStream = httpURLConnection.getInputStream();


                File file = new File(pathFile);
                outputStream = new FileOutputStream(file);


                byte[] buffer = new byte[1024];
                int bytesRead = -1;

                while ((bytesRead = inputStream.read(buffer)) != -1) {

                    outputStream.write(buffer, 0, bytesRead);
                }

                System.out.println("Данные обновлены " + pathFile);


            }

        } catch (Exception e) {
            throw new MyException(400);
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

        }
    }
}
