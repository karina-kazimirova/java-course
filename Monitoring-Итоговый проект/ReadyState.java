package Monitoring;

/**
 * Created by Sve on 26.06.2017.
 */
public class ReadyState implements State{
    @Override
    public void writeState(UI ui) {
        System.out.println("Готов к использованию...");

    }

    @Override
    public void run(UI ui) {
      // ui.startParse(ui);
    }
}
