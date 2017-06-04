/**
 * Created by Sve on 01.06.2017.
 */
public class Heater extends Conditioning {

    public String getType() {
        return type;
    }

    public int getHeatingArea() {
        return heatingArea;
    }



    public void setType(String type) {
        this.type = type;
    }

    public void setHeatingArea(int heatingArea) {
        this.heatingArea = heatingArea;
    }

    private int heatingArea;
    private String type;
}
