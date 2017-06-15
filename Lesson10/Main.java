package Lesson10;

/**
 * Created by Sve on 13.06.2017.
 */
public class Main {


    public static void main(String[] args) {

        Calculator calculator = new Calculator();

        try {
            calculator.addValue();
        } catch (MyException e) {
            if (e.getCode() == 100) {
                System.out.println(e.getRussianMessage("На ноль делить нельзя!"));
            }


        }


    }
}