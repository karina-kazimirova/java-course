package Animal;

/**
 * Created by Sve on 06.06.2017.
 */
public class Dog extends Animal{

    private String makeVoice;

    public Dog(String makeVoice){
        this.makeVoice = makeVoice;
    }

    @Override
    public String voice() {
        return makeVoice;

    }
}
