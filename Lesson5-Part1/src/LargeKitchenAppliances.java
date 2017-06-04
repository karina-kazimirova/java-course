/**
 * Created by Sve on 01.06.2017.
 */
public class LargeKitchenAppliances {


    public boolean isBuiltIn() {
        return isBuiltIn;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public int getVolume() {
        return volume;
    }



    public void setLength(int length) {
        this.length = length;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void setBuiltIn(boolean builtIn) {
        isBuiltIn = builtIn;
    }

    private int width;
    private int volume;
    private boolean isBuiltIn;
    private int length;

}
