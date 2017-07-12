package Monitoring.UI.state;

import Monitoring.controller.Controller;
import Monitoring.controller.MyException;
import Monitoring.controller.SearchClass;
import Monitoring.models.City;
import Monitoring.models.Monitoring;
import Monitoring.UI.UI;
import java.util.ArrayList;
import java.util.List;

public class ReadyState implements State {
    SearchClass search = new SearchClass();


    @Override
    public void writeState(UI ui) {
        System.out.println("Начнем поиск!");


    }

    @Override
    public void runStateUI(UI ui) {


    }

    // Если все в порядке, в этом состоянии можно производить посик и сортировку
    @Override
    public void runStateUI(UI ui, Monitoring monitoring) throws MyException {
        List<City> cities = new ArrayList<>(monitoring.getCity());
        Controller.printData(monitoring);

        String cityName = ui.vvod("Введите название города, который вы хотите найти: ");
        search.searchCity(cityName, cities);


        String print = ui.vvod("Oтсортировать данные по названию города? (+/-)");
        if(print.equals("+")){
            search.sortByName(cities);
        }else if(print.equals("-")){
            System.out.println("Вы ответили отрицательно");
        }else {
            System.out.println("Неправильно выбран опереатор.");

        }

        String printValue = ui.vvod("Oтсортировать данные по значению? (+/-)");
        if(printValue.equals("+")){
            search.sortbyValue(cities);
        }

    }
}
