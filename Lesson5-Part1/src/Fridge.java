/**
 * Created by Sve on 01.06.2017.
 */
public class Fridge extends LargeKitchenAppliances {

    public String getEnergyClass() {
        return energyClass;
    }

    public int getNummerOfSections() {
        return nummerOfSections;
    }

    public void setEnergyClass(String energyClass) {
        this.energyClass = energyClass;
    }

    public void setNummerOfSections(int nummerOfSections) {
        this.nummerOfSections = nummerOfSections;
    }

    private String energyClass;
    private int nummerOfSections;

}
