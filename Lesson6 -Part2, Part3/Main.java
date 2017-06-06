package Animal;

import java.sql.Array;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by Sve on 06.06.2017.
 */
public class Main {
    public static void main (String[] args) {

        Animal a;
        a = new Dog("Гав-гав");
        printVoice(a);
        a = new Cat("Мяу-мяу");
        printVoice(a);



        //Array-copy
        Number[] array1 = new Number[10];
        Number[] array2 = new Number[20];
        Random random = new Random();

        for (int i = 0; i <array1.length; i++){
            array1[i] = random.nextInt(10);

        }

        for (int i = 0; i <array2.length; i++){
            array2[i] = random.nextInt(20);

        }
        printNumber(array1);
        printNumber2(array2);

        System.arraycopy(array1, 0, array2,array2.length/2, array1.length);

        printNumber(array1);
        printNumber2(array2);


    }

    private static void printNumber(Number[] array1) {
        System.out.println(Arrays.toString(array1));
    }

    private static void printNumber2(Number[] array2) {

        System.out.println(Arrays.toString(array2));
    }


    private static void printVoice(Animal a){
        System.out.println(a.voice());

    }


}
