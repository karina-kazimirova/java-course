package Arrays;

import Lesson11.People;
import Lesson11.Pol;

import java.util.*;

/**
 * Created by Sve on 14.06.2017.
 */
public class Main {

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();// В скобках тип данных
        list.add("Первый");
        list.add("Второй");
        list.add("Третий");

        System.out.println("Размер " + list.size());
        System.out.println(list.toString());

        list.add("Четвертый");

        System.out.println("Размер " + list.size());
        System.out.println(list.toString());

        System.out.println("Элемент под индексом 2 " + list.get(2));

        ArrayList<String> list2 = new ArrayList<>();

        list.addAll(list2);// Добавляем другой массив

        for(String text : list){
            System.out.println(text);// Из листа по одному элементу записывается в text
        }

       /* for(Student student : list){
            System.out.println(student.getName);// Из листа по одному элементу записывается в text
        }*/

       // Collections.sort();

        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(1);
        list3.add(3);
        list3.add(8);
        list3.add(5);
        list3.add(3);
        list3.add(5);
        list3.add(1);

        //HashSet
        HashSet<Integer> set = new HashSet<>(list3);//удалит дубликаты в list

        list3.clear();
        list3.addAll((set));

        System.out.println(list3.toString());

        list3.remove(5);

        ArrayList<Integer> a = new ArrayList<Integer>();// Удаляем элементы по значению
        a.add(5);
        list3.removeAll(a);

        for(Integer number:list3){

        }
        System.out.println(list3.toString());


        ArrayList<Student> listSt = new ArrayList<>();
        listSt.add(new Student("JJJ", 20));
        listSt.add(new Student("OOO", 26));

        Collections.sort(listSt);

        ArrayList<Country> listCt = new ArrayList<>();
        listCt.add(new Country("en"));
        listCt.add(new Country("ru"));

        Collections.sort(listCt, new Comparator<Country>() {// Второй способ сравнения
            @Override
            public int compare(Country o1, Country o2) {// Сравниваем два объекта

                if(o1.getName().equals(o2.getName())){
                    return  0;
                }
                return 1;

                //return o1.getName().compareTo(o2.getName());// по имени
            }
        });


        //LinkedList

        LinkedList<Integer> list4 = new LinkedList<>();

        List list5 = new LinkedList<Integer>();// Полиморфизм




       // Map данные в виде пары

        HashMap<Integer, String> hash = new HashMap<>();

        hash.put(5, "Пять");
        hash.put(7, "Семь");
        hash.put(3, "Три");

        System.out.println(hash.toString());
        System.out.println(hash.get(5));// Вернет значение под ключом 5

        HashMap<String, String> hash1 = new HashMap<>();

        hash1.put("en", "Hello");
        hash1.put("ru", "Привет");
        hash1.put("by", "Прыветанне");

        hash1.put("by", "Здарова"); // Замена значения

        System.out.println(hash1.toString());
        System.out.println(hash1.get("by"));// Вернет значение под ключом by

        for(String key: hash1.keySet()){// Возвращает массив ключей, for не умеет ходть по HashMap
            System.out.println("key = " + key + " value = " + hash.get(key)); // Вернет в неотсортированном виде

        }

        HashMap<Country, Student> hash3 = new HashMap<>(); // Необходимо переопределить hashcode и equals (обязательно для ключа)

        ArrayList<Student> listM = new ArrayList<>();
        listM.add(new Student("HHH", 26));
        listM.add(new Student("OOO", 26));


        ArrayList<Student> listW = new ArrayList<>();
        listW.add(new Student("HHH", 26));
        listW.add(new Student("OOO", 26));

        HashMap<Country, ArrayList<Student>> hash8 = new HashMap<>();


        hash3.put(new Country("en"), new Student("FFF", 26));
        hash3.put(new Country("ru"), new Student("JJJ", 20));
        hash3.put(new Country("by"), new Student("RRR", 27));


        String name = hash3.get(new Country("ru")).getName();

        for(Country key: hash3.keySet()){
            System.out.println("key = " + key + " value = " + hash3.get(key));

        }


        // TreeMap
        TreeMap<Integer, String> hash2 = new TreeMap<>();// Сортированный HashMap, но работает медленнее






    }
}
