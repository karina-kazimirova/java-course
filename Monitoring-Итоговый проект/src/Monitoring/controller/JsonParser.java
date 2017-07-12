package Monitoring.controller;

import Monitoring.UI.UI;
import Monitoring.UI.state.FailureState;
import Monitoring.UI.state.ReadyState;
import Monitoring.models.Monitoring;
import com.google.gson.*;
import java.io.BufferedReader;
import java.io.FileReader;

public class JsonParser extends Parser {


    @Override
    public Monitoring parseFile(String path, UI ui){
        Monitoring monitoring = new Monitoring();
        try{
            BufferedReader reader = new BufferedReader(new FileReader(path));
            Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd")
                    .create();

            monitoring = gson.fromJson(reader, Monitoring.class);
            ui.changeState(new ReadyState());


        }catch(Exception e){
            System.out.println("Ошибка чтения файла" + e.toString());
            ui.changeState(new FailureState());

        }



       return monitoring;
    }


}
