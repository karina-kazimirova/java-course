/**
 * Created by Sve on 01.06.2017.
 */
public class Blower extends Conditioning {

    public int getNumberOfSpeeds() {
        return numberOfSpeeds;
    }

    public String getTypeOfAccommodation() {
        return typeOfAccommodation;
    }

    public void setNumberOfSpeeds(int numberOfSpeeds) {
        this.numberOfSpeeds = numberOfSpeeds;
    }

    public void setTypeOfAccommodation(String typeOfAccommodation) {
        this.typeOfAccommodation = typeOfAccommodation;
    }

    private int numberOfSpeeds;
    private String typeOfAccommodation;
}
