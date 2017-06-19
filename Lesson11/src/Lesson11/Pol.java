package Lesson11;

/**
 * Created by Sve on 19.06.2017.
 */
public class Pol {

    public Pol(String pol) {
        this.pol = pol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pol pol1 = (Pol) o;

        return pol != null ? pol.equals(pol1.pol) : pol1.pol == null;
    }

    @Override
    public int hashCode() {
        return pol != null ? pol.hashCode() : 0;
    }

    public void setPol(String pol) {
        this.pol = pol;
    }

    private String pol;

    public String getPol() {
        return pol;
    }
}
