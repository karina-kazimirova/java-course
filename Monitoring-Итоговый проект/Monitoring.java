package Monitoring;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sve on 21.06.2017.
 */

public class Monitoring {

    private String name;

    @Override
    public String toString() {
        return "Monitoring{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", sities=" + sities +
                '}';
    }

    private String location;
    private ArrayList<City> sities;


    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<City> getSities() {
        return sities;
    }

    public void setSities(ArrayList<City> sities) {
        this.sities = sities;
    }


}


