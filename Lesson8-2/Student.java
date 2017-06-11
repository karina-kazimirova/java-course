package Lesson8Student;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * Created by Sve on 08.06.2017.
 */
public class Student {
    private String name;
    private String surName;
    private long age;
    private Date birthDate;


    public void setAge(long age) {
        this.age = age;
    }

    public long getAge() {
        return age;
    }



    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getBirthDate() {
        return birthDate;
    }


    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

     public void setSurName(String surName) {
        this.surName = surName;
    }


    public void setName(String name) {
        this.name = name;
    }


    // Добавляем имена
    public void addName(Student[] students, int x){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя студента №" + (x + 1) + " ");
        students[x].name = scanner.nextLine();

    }


    // Добавляем фамилии
    public void addSurName(Student[] students, int x){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите фамилию студента №" + (x + 1) + " ");
        students[x].surName = scanner.nextLine();

    }


    // Добавляем дату рождения
    public void addBirthDate(Student[] students, int x) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите дату рождения студента №" + (x + 1) + " ");
        String newdate = scanner.nextLine();


        SimpleDateFormat sf = new SimpleDateFormat("yyyy.MM.dd");
        try {
            students[x].birthDate = sf.parse(newdate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    // вычисляем возраст
    public void addAge(Student[] students, int x){

        Date date = new Date();

        students[x].age = date.getTime() - students[x].birthDate.getTime();


     }

    // Расчет среднего возраста
    public static void middleAge(Student[] students, long allAge){


        long middleAge = allAge / students.length;

        long sec = middleAge /1000;
        long min = sec/60;
        long hour = min/60;
        long day = hour/24;
        long month = day/30;
        long year = month/12;
        int monthEnd = ((int) month%12);
        int dayEnd = (int) day%30;
        int hourEnd = (int) hour%24;
        int minEnd = (int) min%60;

        StringBuilder builder = new StringBuilder();
        builder.append("Средний возраст студентов: ").append(year).append(" лет, ").append(monthEnd).append(" месяцев, ").append(dayEnd).append(" дней, ").append(minEnd).append(" минут.");

        System.out.println(builder);


    }

    // Вывод на экран
    public static void printAll(Student[] students) {

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < students.length; i++) {


            SimpleDateFormat sf = new SimpleDateFormat("yyyy.MM.dd");
            String newDate = sf.format(students[i].getBirthDate());

            try {
                sf.parse(newDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }



            builder.append("Студент № ").append(i+1).append(" Имя: ").append(students[i].getName()).append(" Фамилия: ").append(students[i].getSurName()).append(" Дата рождения: ").append(newDate);
        }


        System.out.println(builder);




    }




}
