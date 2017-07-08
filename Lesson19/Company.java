package Company;

import java.util.*;

/**
 * Created by Sve on 05.07.2017.
 */
public class Company<String, T> {

    private String nameCompany;
    private ArrayList<T> list = new ArrayList();
    private T director;
    private T people;
    private int value;
    private HashMap<String, List<T>> data;

    public Company(String nameCompany){
        this.nameCompany = nameCompany;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public void addDirector(T value){
        director = value;
    }

    public T getDirector(){
        return  director;
    }

    public void addPeople(T value){
        list.add(value);
    }

    public void add(String department, T value){
        if(data.containsKey(department)){
            data.get(department).add(value);
        }else{
            List<T> list = data.get(department);
            if(list==null){
                list = new ArrayList<T>();
            }
            list.add(value);
            data.put(department, list);
        }
    }

    public void getDepartment(String department){
        for(String key: data.keySet()){
            System.out.println("Сотрудники отдела " + department + data.get(key));
        }
    }

    public void getPeople(String department) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите фамилию сотрудника");
        String value = (String) scanner.nextLine();
        for (String key : data.keySet()) {
            if (data.get(key).equals(value)) {
                System.out.println("Сотрудник " + data.get(key) + " работает в отделе " + key);
            }
        }
    }

    public void remove(String department) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите фамилию сотрудника");
        String value = (String) scanner.nextLine();
        for (String key : data.keySet()) {
            if (data.get(key).equals(value)) {
                data.remove(data.get(key));
                System.out.println("Сотрудник отдела " + department + data.get(key) + " удален");
            }
        }
    }

    public void remove() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите фамилию сотрудника");
        String value = (String) scanner.nextLine();

        Set<Map.Entry<String, List<T>>> set = data.entrySet();
        for (Map.Entry<String, List<T>> e : set) {
            if (e.getValue().equals(value)) {
                data.remove(e.getValue());
                System.out.println("Сотрудник отдела " + e.getKey() + e.getValue() + " удален");
            }
        }
    }

    public void setList(ArrayList<T> list) {
        this.list = list;
    }


    public ArrayList<T> getList() {
        return list;
    }

    public HashMap<String, List<T>> getData() {
        return data;
    }

    public void setData(HashMap<String, List<T>> data) {
        this.data = data;
    }
}
