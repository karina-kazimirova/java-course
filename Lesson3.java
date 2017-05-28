import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Sve on 28.05.2017.
 */
public class Lesson3 {

    public static void main(String[] args) {

        // Создаем массив
        int[] array = new int[10];

        // Вызываем метод добавления значений
        addToArray(array);

        // Вызываем метод вывода на консоль
        printArray(array.length, array);

        // Сортируем способ1
        Arrays.sort(array);

        // Сортируем способ2
        sortArraySelection(array);

        // Сортируем способ3
        sortArrayBubble(array);

        // Выводим отсотртированный
        printArray(array.length, array);


    }


    // Заполняем массив элементами, введёнными с клавиатуры
    public static void addToArray(int[] array) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }

    }

    // Выводим на консоль
    public static void printArray(int x, int[] array){
        for (int i = 0; i < x; i++) {
            System.out.print("значение " + (i + 1) + ": " + array[i] + " | ");

        }
        System.out.println();
    }

    // Сортировка выбором
    public static void sortArraySelection(int[] array){

        for (int i = 0; i < array.length; i++) {

            int min = array[i];
            int min_i = i;

            for (int j = i+1; j < array.length; j++) {

                if (array[j] < min) {
                    min = array[j];
                    min_i = j;
                }
            }

            if (i != min_i) {
                int tmp = array[i];
                array[i] = array[min_i];
                array[min_i] = tmp;
            }
        }
    }

    // Сортировка пузырьком
    public static void sortArrayBubble(int[] array){
        for(int i = array.length-1 ; i > 0 ; i--){
            for(int j = 0 ; j < i ; j++){

            if( array[j] > array[j+1] ){
                int tmp = array[j];
                array[j] = array[j+1];
                array[j+1] = tmp;
                }
            }
        }
    }



}