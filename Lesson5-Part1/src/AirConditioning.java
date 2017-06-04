/**
 * Created by Sve on 01.06.2017.
 */
public class AirConditioning extends Conditioning {

    public void setNoiseLevel(int noiseLevel) {
        this.noiseLevel = noiseLevel;
    }

    public void setCoolingCapacity(int coolingCapacity) {
        this.coolingCapacity = coolingCapacity;
    }



    public int getNoiseLevel() {
        return noiseLevel;
    }

    public int getCoolingCapacity() {
        return coolingCapacity;
    }

    private int noiseLevel;
    private int coolingCapacity;


}
