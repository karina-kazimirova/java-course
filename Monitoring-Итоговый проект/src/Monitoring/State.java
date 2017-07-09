package Monitoring;

/**
 * Created by Sve on 21.06.2017.
 */
public interface State {
    void writeState(UI ui);
    void runStateUI(UI ui) throws MyException;


}
