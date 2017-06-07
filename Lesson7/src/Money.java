import java.util.Scanner;

/**
 * Created by Sve on 02.06.2017.
 */
public class Money {
    private int amountOf20;
    private int amountOf50;
    private int amountOf100;
    private int summ;

    private OnLoadListener listenner;
    private OnGetMoneyListenner addlistenner;
    private OnFailureListenner failureListenner;

    public void setFailureListenner(OnFailureListenner failureListenner) {
        this.failureListenner = failureListenner;
    }

    public void setAddlistenner(OnGetMoneyListenner addlistenner) {
        this.addlistenner = addlistenner;
    }

    public void setListenner(OnLoadListener listenner) {
        this.listenner = listenner;
    }


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

        listenner.onLoad();

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
    public boolean takeMoney(Money money){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму денег, которую хотите снять: ");
        int x = scanner.nextInt();

        listenner.onLoad();

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

            addlistenner.onAddMoney(x);
            System.out.println("Выдано банкнот: " + "Номиналом 100руб: " + count100 + " " + "Номиналом 50руб: " + count50 + " " + "Номиналом 20руб: " + count20);
        }

        else{
            failureListenner.onFailure(money.getSumm());
            isEnough = false;
        }

        return isEnough;

    }




}
