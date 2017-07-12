package Monitoring.UI.state;

import Monitoring.controller.MyException;
import Monitoring.UI.UI;
import Monitoring.models.Monitoring;

public interface State {

    // Создаем три метода, котрые переопределим в дочерних классах
    void writeState(UI ui);
    void runStateUI(UI ui) throws MyException;
    void runStateUI(UI ui, Monitoring monitoring) throws MyException;


}
