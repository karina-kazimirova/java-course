package Monitoring;

/**
 * Created by Sve on 26.06.2017.
 */
public class FailureState implements State {

    @Override
    public void writeState(UI ui) {

        System.out.println("Произошла ошибка, попробуйте еще раз...");
        //ui.setState(this);

    }

    @Override
    public void run(UI ui) {

    }
}
