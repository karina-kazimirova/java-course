package Lesson8Part5;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by Sve on 11.06.2017.
 */
public class Writer {

    public static void write(String fileName){

            File file = new File(fileName);

            Scanner scanner = new Scanner(System.in);
            System.out.println("\n" + "Введите строку которую хотите записать в файл: ");
            String text = scanner.nextLine();

            try {

                // Если файл не существует создаем новый
                if(!file.exists()){
                    file.createNewFile();
                }

                PrintWriter out = new PrintWriter(file.getAbsoluteFile());
                try {

                    out.print(text);// Записываем текст в файл

                } finally {
                    out.close();// закрываем файл
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


