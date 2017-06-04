/**
 * Created by Sve on 01.06.2017.
 */
public class Stove extends LargeKitchenAppliances {

    public String getTypeCookingSurface() {
        return typeCookingSurface;
    }

    public int getNumberOfBurners() {
        return numberOfBurners;
    }

    public void setTypeCookingSurface(String typeCookingSurface) {
        this.typeCookingSurface = typeCookingSurface;
    }

    public void setNumberOfBurners(int numberOfBurners) {
        this.numberOfBurners = numberOfBurners;
    }

    private String typeCookingSurface;
    private int numberOfBurners;

}
