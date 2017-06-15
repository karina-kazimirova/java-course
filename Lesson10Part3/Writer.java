package Lesson10Part3;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Sve on 11.06.2017.
 */
public class Writer {

    public static void write(){

            Scanner scanner = new Scanner(System.in);
            System.out.println("\n" + "Введите строку которую хотите записать в файл: ");
            String newText = scanner.nextLine();


        try(FileWriter writer = new FileWriter("C://Users/Sve/IdeaProjects/Lesson8/src/Lesson10Part3/c.txt", true))
        {

            writer.write(newText);
            writer.write(System.lineSeparator());


        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}



