package Monitoring;

/**
 * Created by Sve on 21.06.2017.
 */
public class Main {


    public static void main(String[] args) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hi");
            }
        });

        thread.start();// Поток 1

        MyThread thread1 = new MyThread();
        thread1.start();// Поток2 из класса MyThread

        UI ui = new UI();
        ui.changeState(new RefreshState());
        ui.start();





    }



}
