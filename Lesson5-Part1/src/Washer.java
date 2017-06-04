/**
 * Created by Sve on 01.06.2017.
 */
public class Washer extends HomeAppliances {

    public int getMaximumLoad() {
        return maximumLoad;
    }

    public int getSpinSpeed() {
        return spinSpeed;
    }

    public void setMaximumLoad(int maximumLoad) {
        this.maximumLoad = maximumLoad;
    }

    public void setSpinSpeed(int spinSpeed) {
        this.spinSpeed = spinSpeed;
    }

    private int maximumLoad;
    private int spinSpeed;


}
