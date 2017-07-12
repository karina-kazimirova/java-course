package Monitoring.models;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Monitoring implements Serializable {

    private static String date;
    private String name;
    private static String location;
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

    // Формируем текущую дату
    public String getDate() {
        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy.MM.dd");
        String date = formatForDateNow.format(dateNow);
        return date;
    }

   public void setDate(String date) {
        this.date = date;
    }



    @Override
    public String toString() {
        return "Monitoring{" +
                "date='" + date + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", city=" + city +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Monitoring that = (Monitoring) o;

        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (location != null ? !location.equals(that.location) : that.location != null) return false;
        return city != null ? city.equals(that.city) : that.city == null;
    }

    @Override
    public int hashCode() {
        int result = date != null ? date.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        return result;
    }


}


