package Monitoring;

import com.google.gson.*;
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

            System.out.println("Ошибка чтения файла" + e.toString());
        }

        return monitoring;
    }


}
