package Lesson11;
import java.util.*;

/**
 * Created by Sve on 15.06.2017.
 */
public class Main {

    public static void main(String[] args) {

        // Массив с женскими и мужкими именами
        ArrayList<People> man = new ArrayList<>();
        man.add(new People("man","Иван", "Иваныч", "Иванов"));
        man.add(new People("man","Петр", "Петрович", "Петров"));
        man.add(new People("man","Сидор", "Сидорович", "Сидоров"));


       ArrayList<People> woman = new ArrayList<>();
        woman.add(new People("woman", "Ольга", "Ивановна", "Иванова"));
        woman.add(new People("woman", "Ирина", "Олеговна", "Петрова"));
        woman.add(new People("woman", "Нина", "Петровна", "Светлова"));

       /* ArrayList<People> all = new ArrayList<>(man);
        all.addAll(woman);*/



        HashMap<String, People> allPeople = new HashMap<>();



        for (Iterator<People> iter = man.iterator(); iter.hasNext(); ) {

            allPeople.put("man", iter.next());

    }

        for (Iterator<People> iter = woman.iterator(); iter.hasNext(); ) {

            allPeople.put("woman", iter.next());

        }


        People people1 = (allPeople.get(search()));
        System.out.println(people1.getName() + " " + people1.getOtchestvo() + " " + people1.getSurname());


       

    }



    public static String search(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите пол объекта: ");
        String oPol = scanner.nextLine();
        return oPol;
    }





    }

