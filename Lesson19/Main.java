package Company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Sve on 05.07.2017.
 */
public class Main {

    public static void main(String[] args) {

       Company company = new Company("GAz");
       company.addDirector("fefe");

       ArrayList<StaffPeople> staff1 = new ArrayList();

       staff1.add(new StaffPeople("Петров"));
       staff1.add(new StaffPeople("Васечкин"));
       staff1.add(new StaffPeople("Сидоров"));


       ArrayList<StaffPeople> staff2 = new ArrayList();
       staff2.add(new StaffPeople("Петрова"));
       staff2.add(new StaffPeople("Васечкина"));
       staff2.add(new StaffPeople("Сидорова"));


       company.add("Department1", staff1);
       company.add("Department2", staff2);

       company.remove("Department1");
       company.remove();

       company.getPeople("Department2");



    }
}
