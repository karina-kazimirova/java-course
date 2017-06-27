package Monitoring;

import com.google.gson.*;

//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by Sve on 19.06.2017.
 */
public class JsonParser extends Parser{

    @Override
    public Monitoring parseFile(String path){

        Monitoring monitoring = null;


        try{
            BufferedReader reader = new BufferedReader(new FileReader(path));
            Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd")
                    .create();

            monitoring = gson.fromJson(reader, Monitoring.class);

        }catch(Exception e){
           // UI ui = new UI();
            //ui.changeState(new FailureState());
            System.out.println("Ошибка чтения файла" + e.toString());
        }

        return monitoring;
    }


}
