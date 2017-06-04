import java.util.Scanner;

/**
 * Created by Sve on 02.06.2017.
 */
public class Money {
    private int amountOf20;
    private int amountOf50;
    private int amountOf100;
    private int summ;


    public void setAmountOf20(int amountOf20) {
        this.amountOf20 = amountOf20;
    }

    public void setAmountOf50(int amountOf50) {
        this.amountOf50 = amountOf50;
    }

    public void setAmountOf100(int amountOf100) {
        this.amountOf100 = amountOf100;
    }

    public int getAmountOf20() {
        return amountOf20;
    }

    public int getAmountOf50() {
        return amountOf50;
    }

    public int getAmountOf100() {
        return amountOf100;
    }

    public int getSumm() {
        summ = getAmountOf20()*20 + getAmountOf50()*50 + getAmountOf100()*100;
        return summ;
    }

    public void setSumm(int summ) {
        this.summ = summ;
    }



   public Money (int amountOf20, int amountOf50, int amountOf100){

       this.amountOf20 = amountOf20;
       this.amountOf50 = amountOf50;
       this.amountOf100 = amountOf100;

   }

    // Метод добавления денег в банкомат
    public void addMoney(Money money){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму денег, которую хотите добавить: ");
        int x = scanner.nextInt();
        if(x%100==0){
           amountOf100 +=  x/100;
        }
        else if(x%50==0){
            amountOf50 += (x%100)/50;
            amountOf100 += (x - amountOf50)/100;
        }
        else {
            amountOf20+= (x%100)/20;
            amountOf100 += (x - amountOf20)/100;
        }


    }




}
