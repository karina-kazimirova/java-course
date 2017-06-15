package Lesson10Part3;

import java.io.*;

/**
 * Created by Sve on 11.06.2017.
 */
public class ReaderString {

    public static void read() {

        Student student = new Student();



        try {

            BufferedReader in = new BufferedReader(new FileReader("C://Users/Sve/IdeaProjects/Lesson8/src/Lesson10Part3/c.txt"));
            try {

                String s;
                while ((s = in.readLine()) != null) {

                    String[] strArray = s.split("\\|");


                    String name = strArray[0];
                    int age = Integer.valueOf(strArray[1]);
                    boolean isZaoch = Boolean.valueOf(strArray[2]);

                    student.setAge(age);
                    student.setName(name);
                    student.setZaochnik(isZaoch);
                    System.out.println(student.getName() + " " + student.getAge() + " " + student.isZaochnik());
                }
            } finally {

                in.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }


    }

}



