import java.util.Scanner;

/**
 * Created by Sve on 02.06.2017.
 */
public class Bankomat {

    public static void main(String[] args) {

        Money money = new Money(10, 5,1);

        ptintMoney(money);

        addMoney(money);
        ptintMoney(money);

        takeMoney(money);


    }

    // Вывод на экран
    public static void ptintMoney(Money money){
        StringBuilder newString = new StringBuilder();
        newString.append("Купюр номиналом 20руб: ").append(money.getAmountOf20()).append(" Купюр номиналом 50руб: ").append(money.getAmountOf50()).append(" Купюр номиналом 100руб: ").append(money.getAmountOf100());

        System.out.println(newString);
        System.out.println("Итого: " + money.getSumm());

    }

    // Метод добавления денег в банкомат
    public static void addMoney(Money money){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму денег, которую хотите добавить: ");
        int x = scanner.nextInt();

        if(x%100==0){
            money.setAmountOf100(money.getAmountOf100() + x/100);
        }
        else if(x%50==0){
            money.setAmountOf50(money.getAmountOf50() + (x%100)/50);
            money.setAmountOf100(money.getAmountOf100() - (x + money.getAmountOf50())/100);
        }
        else {
            money.setAmountOf20(money.getAmountOf20() + (x%100)/20);
            money.setAmountOf100(money.getAmountOf100() - (x + money.getAmountOf20())/100);
        }
    }


    // Метод снятия денег в банкомате
    public static boolean takeMoney(Money money){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму денег, которую хотите снять: ");
        int x = scanner.nextInt();
        boolean isEnough;
        int count100 = 0;
        int count50 = 0;
        int count20 = 0;

        if(x < money.getSumm()) {

            if (x % 100 == 0) {
                if(money.getAmountOf100() >= x/100){
                    money.setAmountOf100(money.getAmountOf100() - x / 100);
                    count100 += x/100;
                }
                else{
                    money.setAmountOf50(money.getAmountOf50() - (x / 100)*2);
                    count50 = (x / 100)*2;
                }

            }
            else if (x % 50 == 0) {
                money.setAmountOf50(money.getAmountOf50() - (x % 100) / 50);
                count50 = (x % 100) / 50;
                if(money.getAmountOf100() >= x/100){
                    money.setAmountOf100((x - money.getAmountOf50()) / 100);
                    count100 += x/100;
                }
                else{
                    money.setAmountOf50(money.getAmountOf50() - (x / 100)*2);
                    count50 = (x / 100)*2;
                }

            }
            else {
                money.setAmountOf20(money.getAmountOf20() - (x % 100) / 20);

                count20 = (x % 100) / 20;
                if(money.getAmountOf100() >= x/100){
                    money.setAmountOf100((x - money.getAmountOf20()) / 100);
                    count100 += x/100;
                }
                else{
                    money.setAmountOf50(money.getAmountOf50() - (x / 100)*2);
                    count50 = (x / 100)*2;
                }
            }
            isEnough = true;
            System.out.println("Операция удалась!");
            System.out.println("Выдано банкнот: " + "Номиналом 100руб: " + count100 + " " + "Номиналом 50руб: " + count50 + " " + "Номиналом 20руб: " + count20);
        }

        else{
            System.out.println("В банкомате недостаточно средств!");
            isEnough = false;
        }

        return isEnough;

    }


}



