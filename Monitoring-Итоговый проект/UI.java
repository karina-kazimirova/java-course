package Monitoring;

import javax.xml.stream.XMLStreamException;

/**
 * Created by Sve on 26.06.2017.
 */
public class UI {
    private State state;

    Controller controller =  Controller.getInstance();

    public UI(){
        this.state = null;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }


    public void changeState(State newstate) {
        this.state = newstate;
    }

    public void start(){
        state.writeState(this);
        try {
            Controller.printSities("json");
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }

    }


}
