package Lesson11;

/**
 * Created by Sve on 17.06.2017.
 */
public class People implements Comparable<People>{
    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", pol='" + pol + '\'' +
                ", otchestvo='" + otchestvo + '\'' +
                '}';
    }

    private String name;

    public void setPol(String pol) {
        this.pol = pol;
    }

    private String surname;

    public String getPol() {
        return pol;
    }

    private String pol;
    

    public People(String pol, String name, String otchestvo, String surname) {
        this.name = name;
        this.surname = surname;
        this.otchestvo = otchestvo;
    }

    private String otchestvo;

    public String getSurname() {
        return surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setOtchestvo(String otchestvo) {
        this.otchestvo = otchestvo;
    }

    public String getName() {
        return name;
    }

    public String getOtchestvo() {
        return otchestvo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        People people = (People) o;

        if (name != null ? !name.equals(people.name) : people.name != null) return false;
        if (surname != null ? !surname.equals(people.surname) : people.surname != null) return false;
        if (pol != null ? !pol.equals(people.pol) : people.pol != null) return false;
        return otchestvo != null ? otchestvo.equals(people.otchestvo) : people.otchestvo == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (pol != null ? pol.hashCode() : 0);
        result = 31 * result + (otchestvo != null ? otchestvo.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(People people2) {

        if(name==people2.getName()){
            return 0;
        }else
        return -1;
    }

}
