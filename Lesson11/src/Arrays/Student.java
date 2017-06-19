package Arrays;

/**
 * Created by Sve on 14.06.2017.
 */
public class Student implements Comparable<Student> {//Сортирует по типу указанному в скобках

    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public int compareTo(Student student2){// будет сортироваться по этому принципу
         // return name.compareTo(student2.getName());

         if(age==student2.getAge()){
             return 0;
         }

         if(age > student2.getAge()){
             return 1;
         }
        return -1; // вернет
    }
}
