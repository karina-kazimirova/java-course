/**
 * Created by Sve on 01.06.2017.
 */
public class VacuumCleaner extends HomeAppliances{



    public String getTypeOfConstruction() {
        return typeOfConstruction;
    }

    public String getTypeOfCleaning() {
        return typeOfCleaning;
    }

    public void setTypeOfCleaning(String typeOfCleaning) {
        this.typeOfCleaning = typeOfCleaning;
    }

    public void setTypeOfConstruction(String typeOfConstruction) {
        this.typeOfConstruction = typeOfConstruction;
    }

    private String typeOfCleaning;
    private String typeOfConstruction;
}
