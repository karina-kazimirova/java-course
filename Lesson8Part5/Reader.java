package Lesson8Part5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Sve on 11.06.2017.
 */
public class Reader {

    public static void read() {
        try (FileReader reader = new FileReader("C://Users/Sve/IdeaProjects/Lesson8/src/Lesson8Part5/a.txt")) {
            // читаем посимвольно
            int c;
            while ((c = reader.read()) != -1) {

                System.out.print((char) c);
            }
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }


}




