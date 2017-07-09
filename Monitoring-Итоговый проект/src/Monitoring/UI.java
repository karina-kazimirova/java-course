package Monitoring;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UI {
    // Реализуем паттерн State
    private State state;
    public State getState() {
        return state;
    }
    public void changeState(State newstate) {
        this.state = newstate;
    }


   // Запускаем приложение, меняем состояние UI на обновление данных
    public void start() {
        changeState(new RefreshState());
        getAction(this);
    }

    // Вывод и сортировка
   public void searchFunc(Monitoring monitoring) {
       List<City> cities = new ArrayList<>(monitoring.getCity());
       Controller.printData(monitoring);

       String cityName = vvod("Введите название города, который вы хотите найти: ");
       Controller.searchCity(cityName, monitoring, cities);

       String print = vvod("Oтсортировать данные по названию города? (+/-)");
       if(print.equals("+")){
           Controller.sortByName(monitoring, cities);
       }

       String printValue = vvod("Oтсортировать данные по значению? (+/-)");
           if(print.equals("+")){
               Controller.sortbyValue(monitoring, cities);
           }


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

    // Пользовательский ввод
    public String vvod(String question){
        Scanner scanner = new Scanner(System.in);
        System.out.println(question);
        String answer = scanner.nextLine();
        return answer;
    }

}

