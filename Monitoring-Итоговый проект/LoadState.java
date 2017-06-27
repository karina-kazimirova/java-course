package Monitoring;

/**
 * Created by Sve on 26.06.2017.
 */
public class LoadState implements State {


    @Override
    public void writeState(UI ui) {
        System.out.println("Подождите, идет загрузка...");
        ui.setState(new LoadState());

    }
}
