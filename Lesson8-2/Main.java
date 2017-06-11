package Lesson8Student;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Sve on 08.06.2017.
 */
public class Main {

    public static void main(String[] args) {



        Student[] students = new Student[2];
        long allAge = 0;



            for(int i = 0; i < students.length; i++) {
                students[i] = new Student();
                students[i].addName(students, i);
                students[i].addSurName(students, i);
                students[i].addBirthDate(students, i);
                students[i].addAge(students, i);

                allAge += students[i].getAge();


            }




            Student.printAll(students);
            Student.middleAge(students, allAge);



    }




}
