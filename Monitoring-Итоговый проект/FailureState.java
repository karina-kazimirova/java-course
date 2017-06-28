package Monitoring;

/**
 * Created by Sve on 26.06.2017.
 */
public class FailureState implements State {

    @Override
    public void writeState(UI ui) {

        System.out.println("Произошла ошибка, попробуйте еще раз...");

    }

    @Override
    public void run(UI ui) {
        ui.start();

    }
}
