/**
 * Created by Sve on 01.06.2017.
 */
public class Iron extends HomeAppliances {



    public boolean isLimescaleProtection() {
        return limescaleProtection;
    }

    public boolean isSteamFunction() {
        return steamFunction;
    }

    public String getUpperMaterial() {
        return upperMaterial;
    }

    public void setSteamFunction(boolean steamFunction) {
        this.steamFunction = steamFunction;
    }

    public void setUpperMaterial(String upperMaterial) {
        this.upperMaterial = upperMaterial;
    }

    public void setLimescaleProtection(boolean limescaleProtection) {
        this.limescaleProtection = limescaleProtection;
    }

    private boolean steamFunction;
    private String upperMaterial;
    private boolean limescaleProtection;
}
