package Monitoring;


public class UI {
    private State state;
    private  UI ui;

    public UI() {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void changeState(State newstate) {
        this.state = newstate;
    }


    public void start() {
        changeState(new RefreshState());
        state.writeState(this);
        try {
            state.runStateUI(this);
        } catch (MyException e) {
            e.printStackTrace();
        }

    }


    public void print(Monitoring monitoring) {
        changeState(new ReadyState());
        state.writeState(this);
        Controller.printData(monitoring);

    }


}

