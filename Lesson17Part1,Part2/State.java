package Monitoring;

/**
 * Created by Sve on 21.06.2017.
 */
public interface State {
    public void writeState(UI ui);
    public void runStateUI(UI ui) throws MyException;


}
