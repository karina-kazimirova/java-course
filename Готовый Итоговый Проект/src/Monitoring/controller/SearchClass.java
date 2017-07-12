package Monitoring.controller;

import Monitoring.UI.UI;
import Monitoring.models.City;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Sve on 12.07.2017.
 */
public class SearchClass {


    UI ui = new UI();

    // Поиск по названию города
    public void searchCity(String cityName, List<City> cities) {

        boolean isIn = false;

        for (City cities1 : cities) {
            if (cities1.getName().equals(cityName)) {

                Controller.vyvod(cities1);
                isIn = true;

                break;
            }
        }

        if(isIn==false){
            cityName = ui.vvod("Неправильно введено название. Введите название города, который вы хотите найти: ");
            searchCity(cityName, cities);
        }

    }


    // Сортировка по имени
    public void sortByName(List<City> cities) {

        Collections.sort(cities, new Comparator<City>() {
            @Override
            public int compare(City o1, City o2) {

                if (o1.getName().equals(o2.getName())) {
                    return 0;
                }
                return o1.getName().compareTo(o2.getName());
            }
        });
        System.out.println("Сортировка по названию города: ");

        for (int i = 0; i < cities.size(); i++) {
            StringBuilder sb = new StringBuilder();

            sb.append("Город: ").append(cities.get(i).getName())
                    .append(" Значение: ").append(cities.get(i).getValue())
                    .append(" Уровень излучения: ").append(cities.get(i).getLevel())
                    .append(" Максимальное значение в истории наблюдений: ").append(cities.get(i).getMaxValue())
                    .append(" Дата максимального значения ").append(cities.get(i).getDateMaxValue())
                    .append(" Мнимальное значение в истории наблюдений: ").append(cities.get(i).getMinValue())
                    .append(" Дата минимального значения ").append(cities.get(i).getDateMinValue());

            System.out.println(sb);
        }

    }
    // Сортировка по значению
    public void sortbyValue(List<City> cities) {

        Collections.sort(cities, new Comparator<City>() {
            @Override
            public int compare(City o1, City o2) {

                int value1 = o1.getValue();
                int value2 = o2.getValue();

                if (value1 > value2) {
                    return 1;
                } else if (value1 < value2) {
                    return -1;
                } else {
                    return 0;
                }

            }
        });
        System.out.println("Сортировка по значению: ");
        for (int i = 0; i < cities.size(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append("Город: ").append(cities.get(i).getName())
                    .append(" Значение: ").append(cities.get(i).getValue())
                    .append(" Уровень излучения: ").append(cities.get(i).getLevel())
                    .append(" Максимальное значение в истории наблюдений: ").append(cities.get(i).getMaxValue())
                    .append(" Дата максимального значения ").append(cities.get(i).getDateMaxValue())
                    .append(" Мнимальное значение в истории наблюдений: ").append(cities.get(i).getMinValue())
                    .append(" Дата минимального значения ").append(cities.get(i).getDateMinValue());

            System.out.println(sb);
        }
    }

}
