
package FirstLesson;
import static java.lang.Math.*;
/**
 * Created by Sve on 24.05.2017.
 */
public class FirstLesson {


    public static void main(String[] args) {
        String first = "Это первое занятие";

        // Задание 1
        int firstlength = first.length();
        System.out.println("Длинна строки first = " + firstlength);


        String partOne = first.substring(0,8);
        String partTwo = first.substring(8,18);
        System.out.println("Строка partOne = " + partOne);
        System.out.println("Строка parTwo = " + partTwo);

        // Задание 2
        int random = (int) Math.random() * 100 + 1;
        if(random % 7 == 0)
         {
            System.out.println("Последняя цифра random = 7" );
         }
        else
        {
            System.out.println("Последняя цифра random = не равняется 7" );
        }

        // Задание 3
        int rectangleWidth = 5;
        int rectangleHeight = 8;
        int circleRadius = 4;

        if (circleRadius >= rectangleWidth && circleRadius >= rectangleHeight)
        {
            System.out.println("Прямоугольник можно закрыть картонкой" );
        }
        else
        {
            System.out.println("Прямоугольник нельзя закрыть картонкой" );
        }

        // Задание 4
        int summaRub = 384;
        String summastring = Integer.toString(summaRub);
        char last = summastring.charAt(summastring.length() - 1);
        int lastchar = Integer.parseInt(String.valueOf(last));


        if (lastchar == 1)
        {
            System.out.println("Сумма = " + summaRub + " рубль.");
        }
        else if (lastchar > 1 && lastchar < 5)
        {
            System.out.println("Сумма = " + summaRub + " рубля.");
        }
        else
        {
            System.out.println("Сумма = " + summaRub + " рублей.");
        }

        // Задание 5
        String wrong = "?# World!#";
        String right = wrong.replace("?", "Hello");
        String newright = right.replace("#", "");

        System.out.println("Новая строка: " + newright);


       // Задание 6
        double x = 30.0;
        int t = 1;
        double sinus = Math.sin((Math.pow(x,t)));
        int s = 2;
        double y = Math.pow(sinus,2) / Math.sqrt(1+(Math.pow(x,s)));

        System.out.println("y = " + y);



    }
}
