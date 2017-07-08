package ReflectionAPI;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Created by Sve on 28.06.2017.
 */
public class Main {

    public static void main(String[] args) {

        MyTest test = new MyTest();

        Class clas = test.getClass();
        System.out.println(clas.getSimpleName());
        System.out.println(clas.getName());

        int mod = clas.getModifiers();

        if (Modifier.isPublic(mod)) {
            System.out.println("класс публичный");

        }
        if (Modifier.isAbstract(mod)) {
            System.out.println("класс абстрактный");

        }


        Field[] fields = clas.getDeclaredFields();

        for(Field f: fields){

            f.setAccessible(true);
            System.out.println("field :" + f.getName());
            System.out.println("type :" + f.getType());


            try {
                Object o = f.get(test);

                if (o instanceof String) {
                    System.out.println((String) o);
                    f.set(test, "text1");
                    System.out.println((String) f.get(test));
                }

                if (o instanceof Integer) {
                    System.out.println((Integer) o);
                    f.set(test, 10);
                    System.out.println((Integer) f.get(test));
                }

                if (o instanceof Float) {
                    System.out.println((Float) o);
                    f.set(test, 5.7);
                    System.out.println((Float) f.get(test));
                }

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }


        }





    }
}
