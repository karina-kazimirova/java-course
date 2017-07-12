package Monitoring.UI.state;

import Monitoring.UI.UI;
import Monitoring.controller.MyException;
import Monitoring.models.Monitoring;

/**
 * Created by Sve on 26.06.2017.
 */
public class FailureState implements State {

    @Override
    public void writeState(UI ui) {
        System.out.println("Произошла ошибка, попробуйте еще раз...");

    }

    @Override
    public void runStateUI(UI ui) {
        ui.changeState(new RefreshState());
        ui.getAction(ui);

    }

    @Override
    public void runStateUI(UI ui, Monitoring monitoring) throws MyException {
        ui.changeState(new RefreshState());
        ui.getAction(ui);


    }
}
