import java.util.Arrays;

/**
 * Created by Sve on 25.05.2017.
 */
public class LessonTwo {

    public static void main (String[] args) {


        // Задание 1
        int [] numbers = {1,5,8,4,6,7,4,89,3,4};

        //min value
        // max value
        int min = numbers[0];
        int max = numbers[0];
        for(int i = 0; i < numbers.length; i++){
            if (numbers[i] < min){
                min = numbers[i];
            }

            if (numbers[i] > max){
                max = numbers[i];

            }

        }
        System.out.println("min value = " + min);
        System.out.println("max value = " + max);


        // replace min max
        for(int i = 0; i < numbers.length; i++){
            if (numbers[i] == max){
                numbers[i] = 99;
                max = numbers[i];

            }
            if (numbers[i] == min){
                numbers[i] = 0;
                min = numbers[i];

            }

        }

        System.out.println("replace min value = " + min);
        System.out.println("replace max value = " + max);

        String intArrayString = Arrays.toString(numbers);

        System.out.println(intArrayString);


        // Задание 2
        float[] floatNumbers = new float[10];

        for(int i = 0; i < floatNumbers.length; i++){
            floatNumbers[i] = (float) Math.random()*2;

        }


        int count = 0;
        int countPosition = 0;
        for(int i = 0; i < floatNumbers.length; i++){
            countPosition++;

            for(int j = i + 1; j < floatNumbers.length; j++){


                if(floatNumbers[i] == floatNumbers[j]){
                    count ++;


                }
            }

            System.out.println("[" + countPosition + "]" + " повторений " + count);
        }


        // Задание 3 - Чего-то не совсем получилось как надо))
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        String arrayToString = Arrays.toString(array);
        System.out.println("Простой массив " + arrayToString);

        int arrayMiddle = array.length / 2;
        for(int i = 0; i < arrayMiddle; i++){
            for(int j = array.length - 1; j > arrayMiddle-1; j--){
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }

        }
        String newArray = Arrays.toString(array);
        System.out.println("Инвертированный массив: " + newArray);


        // Задание 4

        int sort[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for(int i = 0; i < sort.length; i++){
            int minSort = i;
            for(int j = i+1; j < sort.length; j++){
                if(sort[minSort] < sort[j])
                    minSort = j;
            }
            int temp = sort[minSort];
            sort[minSort] = sort[i];
            sort[i] = temp;
        }

        String newSort = Arrays.toString(sort);
        System.out.print("Отсортированный массив: " + newSort);








    }
}
