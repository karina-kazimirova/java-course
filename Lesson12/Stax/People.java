package Stax;

public class People {


    private int age;
    private String names;
    private String surname;
    private int id;
    private boolean isDegree;

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    public boolean isDegree() {
        return isDegree;
    }

    public String getNames() {
        return names;
    }

    public String getSurname() {
        return surname;
    }



    public void setAge(int age) {
        this.age = age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDegree(boolean degree) {
        isDegree = degree;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }



    @Override
    public String toString() {
        return "People{" +
                "age=" + age +
                ", name='" + names + '\'' +
                ", surname='" + surname + '\'' +
                ", id=" + id +
                ", isDegree=" + isDegree +
                '}';
    }

}
