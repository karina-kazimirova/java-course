package Monitoring.models;

public class City {

    private int id;
    private String name;
    private int value;
    private String level;
    private int minValue;
    private int maxValue;
    private String dateMinValue;
    private String dateMaxValue;


    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setMinValue(int minValue) {
        this.minValue = minValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    public void setDateMinValue(String dateMinValue) {
        this.dateMinValue = dateMinValue;
    }

    public void setDateMaxValue(String dateMaxValue) {
        this.dateMaxValue = dateMaxValue;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public String getLevel() {
        return level;
    }

    public int getMinValue() {
        return minValue;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public String getDateMinValue() {
        return dateMinValue;
    }

    public String getDateMaxValue() {
        return dateMaxValue;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        City city = (City) o;

        if (id != city.id) return false;
        if (value != city.value) return false;
        if (minValue != city.minValue) return false;
        if (maxValue != city.maxValue) return false;
        if (name != null ? !name.equals(city.name) : city.name != null) return false;
        if (level != null ? !level.equals(city.level) : city.level != null) return false;
        if (dateMinValue != null ? !dateMinValue.equals(city.dateMinValue) : city.dateMinValue != null) return false;
        return dateMaxValue != null ? dateMaxValue.equals(city.dateMaxValue) : city.dateMaxValue == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + value;
        result = 31 * result + (level != null ? level.hashCode() : 0);
        result = 31 * result + minValue;
        result = 31 * result + maxValue;
        result = 31 * result + (dateMinValue != null ? dateMinValue.hashCode() : 0);
        result = 31 * result + (dateMaxValue != null ? dateMaxValue.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", value=" + value +
                ", level='" + level + '\'' +
                ", minValue=" + minValue +
                ", maxValue=" + maxValue +
                ", dateMinValue=" + dateMinValue +
                ", dateMaxValue=" + dateMaxValue +
                '}';
    }



}
