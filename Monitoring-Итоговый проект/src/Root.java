import java.util.ArrayList;

/**
 * Created by Sve on 19.06.2017.
 */
public class Root {


    @Override
    public String toString() {
        return "Monitoring{" +
                "name='" + name + '\'' +
                ", people=" + people +
                '}';
    }

        private String name;
        private ArrayList<People> people;


        public String getName() {

            return name;
        }

        public ArrayList<People> getPeople() {

            return people;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setPeople(ArrayList<People> people) {
            this.people = people;
        }
}
