package Lesson10;

import java.util.Scanner;

/**
 * Created by Sve on 13.06.2017.
 */
public class Calculator {

    private int firstNumber;
    private int nextNumber;
    private int summa = 0;
    private double summ = 0;


    public int getFirstNumber() {
        return firstNumber;
    }

    public int getNextNumber() {
        return nextNumber;
    }

    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    public void setNextNumber(int nextNumber) {
        this.nextNumber = nextNumber;
    }

    public void addValue() throws MyException {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите данные");
            String calcBody = scanner.nextLine();
            String[] strArray = calcBody.split("\\ ");
            firstNumber = Integer.parseInt(strArray[0]);
            Character action = strArray[1].charAt(0);
            nextNumber = Integer.parseInt(strArray[2]);




        //char[] chArray = calcBody.toCharArray();

        //Character action = chArray[1];
        //firstNumber = Character.getNumericValue(chArray[0]);
        //nextNumber = Character.getNumericValue(chArray[2]);










        if (action=='+'){
            try {
                summa = firstNumber+nextNumber;
                System.out.print(firstNumber + "+" + nextNumber + "=" + summa);
            }catch (ArithmeticException e) {
                System.out.println("Произошла недопустимая арифметическая операция");
            }

         }
        else if (action.equals('-')) {
            try {
                summa = firstNumber-nextNumber;
                System.out.print(firstNumber + "-" + nextNumber + "=" + summa);
            }catch (ArithmeticException e) {
                System.out.println("Произошла недопустимая арифметическая операция");
            }

        }
        else if (action.equals('*')) {
            summa = firstNumber*nextNumber;
            System.out.print(firstNumber + "*" + nextNumber + "=" + summa);

        }
        else if (action.equals('/')) {
           if(nextNumber==0){
               throw new MyException(100);
           }else{
               summ = (double) firstNumber/nextNumber;
               System.out.print(firstNumber + "/" + nextNumber + "=" + summ);
           }

        }
        else{
            System.out.println("Неправильно введен оператор");
        }



    }


}
