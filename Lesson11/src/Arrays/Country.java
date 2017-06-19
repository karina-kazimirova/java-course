package Arrays;

/**
 * Created by Sve on 14.06.2017.
 */
public class Country {

    private String name;

    public Country(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

     public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Country country = (Country) o;

        return name != null ? name.equals(country.name) : country.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
