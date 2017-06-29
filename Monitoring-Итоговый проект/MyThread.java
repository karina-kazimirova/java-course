package Monitoring;

/**
 * Created by Sve on 28.06.2017.
 */
public class MyThread extends Thread {

    public void run(){
        System.out.println("Hello");

        try {
            sleep(100);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Hello Again!");
    }


}
