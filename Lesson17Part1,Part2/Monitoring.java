package Monitoring;

import java.util.ArrayList;

public class Monitoring {

    private String name;

    @Override
    public String toString() {
        return "Monitoring{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", city=" + city +
                '}';
    }

    private String location;
    private ArrayList<City> city;


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

    public ArrayList<City> getCity() {
        return city;
    }

    public void setCity(ArrayList<City> city) {
        this.city = city;
    }


}


