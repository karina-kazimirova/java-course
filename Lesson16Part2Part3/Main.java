package Lesson16Part2Part3;

/**
 * Created by Sve on 29.06.2017.
 */
public class Main {

    public static void main(String[] args) {
        Thread thread = new MyThread();
        Thread thread2 = new MyThread();
        thread.setName("Thread1");
        thread2.setName("Thread2");

        thread.start();
        thread2.start();


    }


    //Несинхронизированный
    public static void print10(String name){
        for(int i=0; i<10; i++) {
            System.out.println(name + " "+ i);
        }
    }


    // Синхронизированный
   /* public static synchronized void print10(String name){
        for(int i=0; i<10; i++) {
            System.out.println(name + " "+ i);
        }
    }*/



}
