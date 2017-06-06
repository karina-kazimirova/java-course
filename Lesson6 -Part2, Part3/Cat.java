package Animal;

/**
 * Created by Sve on 06.06.2017.
 */
public class Cat extends Animal {
    private String makeVoice;

    public Cat(String makeVoice){
        this.makeVoice = makeVoice;
    }

    @Override
    public String voice() {
        return makeVoice;

    }
}
