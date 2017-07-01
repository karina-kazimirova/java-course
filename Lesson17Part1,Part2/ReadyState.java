package Monitoring;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ReadyState implements State{
    Monitoring monitoring;

    @Override
    public void writeState(UI ui) {
        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy.MM.dd");
        System.out.println("Данные на " + formatForDateNow.format(dateNow));
    }

    @Override
    public void runStateUI(UI ui) {

    }
}
