package Lesson16Part2Part3;

/**
 * Created by Sve on 29.06.2017.
 */
public class MyThread extends Thread{

    @Override
    public  void run(){
        for(int i=0; i<100; i++) {
            Main.print10(getName());

        }
    }
}
