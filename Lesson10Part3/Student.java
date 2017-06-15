package Lesson10Part3;

/**
 * Created by Sve on 12.06.2017.
 */
public class Student {
    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public void setZaochnik(boolean zaochnik) {
        isZaochnik = zaochnik;
    }

    private boolean isZaochnik;
    private int age;


    public void setAge(int age) {
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String isZaochnik() {
        String w;

        if(isZaochnik == true){
            w = "заочник";
        }else {
            w = "не заочник";
        }
        return w;
    }



}
