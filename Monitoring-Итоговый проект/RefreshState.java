package Monitoring;

public class RefreshState implements State {


    @Override
    public void writeState(UI ui) {

        System.out.println("Данные были обновлены...");
        ui.setState(this);
    }
}
