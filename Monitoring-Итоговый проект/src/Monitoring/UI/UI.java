package Monitoring.UI;

import Monitoring.controller.MyException;
import Monitoring.models.Monitoring;
import Monitoring.UI.state.State;
import java.util.Scanner;

public class UI {
    // Реализуем паттерн state
    private State state;
    public State getState() {
        return state;
    }
    public void changeState(State newstate) {
        this.state = newstate;
    }


    public UI() {  }

    public UI(State state) {
        this.state = state;
    }



    // Запуск действий в зависимости от состояния UI
    public void getAction(UI ui){
        state.writeState(this);
        try {
            state.runStateUI(this);
        } catch (MyException e) {
            e.printStackTrace();
        }
    }

    // Перегрузка метода
    public void getAction(UI ui, Monitoring monitoring){
        state.writeState(this);
        try {
            state.runStateUI(this, monitoring);
        } catch (MyException e) {
           e.setCode(300);
        }
    }

    // Пользовательский ввод
    public String vvod(String question){
        Scanner scanner = new Scanner(System.in);
        System.out.println(question);
        String answer = scanner.nextLine();
        return answer;
    }

}

