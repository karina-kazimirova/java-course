package Monitoring.UI;

import Monitoring.UI.state.RefreshState;

public class Main {

    public static void main(String[] args) {


        // Делегируем права интерфейсу, Создаем UI задаем ему состояние, запускаем
        UI ui = new UI(new RefreshState());
        ui.getAction(ui);

    }

}
