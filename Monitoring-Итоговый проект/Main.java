package Monitoring;

/**
 * Created by Sve on 21.06.2017.
 */
public class Main {


    public static void main(String[] args) {

        UI ui = new UI();
        ui.setState(new LoadState());

        ui.start();

    }



}
