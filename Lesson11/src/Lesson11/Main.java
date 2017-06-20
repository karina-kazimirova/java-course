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



        HashMap<String, ArrayList<People>> allPeople = new HashMap<>();

        allPeople.put("man", man);
        allPeople.put("woman", woman);

        // Поиск случайного элемента
        ArrayList<People> searchEl = allPeople.get(search());
        Random random = new Random();
        int x = random.nextInt(searchEl.size());
        System.out.println(searchEl.get(x));



    }



    public static String search(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите пол объекта: ");
        String oPol = scanner.nextLine();
        return oPol;
    }





    }

