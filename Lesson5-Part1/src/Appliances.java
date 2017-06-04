/**
 * Created by Sve on 01.06.2017.
 */
public class Appliances extends Electronics{
    public int getPrice() {
        return price;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getColor() {
        return color;
    }

    public int getPower() {
        return power;
    }

    public int getWeight() {
        return weight;
    }

    private int price;

    public void setPrice(int price) {
        this.price = price;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    private String manufacturer;
    private String color;
    private int power;
    private int weight;
}
