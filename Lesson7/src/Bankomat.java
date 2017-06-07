/**
 * Created by Sve on 02.06.2017.
 */
public class Bankomat implements OnLoadListener, OnGetMoneyListenner, OnFailureListenner {

    public static void main(String[] args) {

        Bankomat bank = new Bankomat();

        Money money = new Money(10, 5,1);

        money.setListenner(bank);
        money.setAddlistenner(bank);
        money.setFailureListenner(bank);

        ptintMoney(money);

        money.addMoney(money);
        ptintMoney(money);

        money.takeMoney(money);


    }

    // Вывод на экран
    public static void ptintMoney(Money money){
        StringBuilder newString = new StringBuilder();
        newString.append("Купюр номиналом 20руб: ").append(money.getAmountOf20()).append(" Купюр номиналом 50руб: ").append(money.getAmountOf50()).append(" Купюр номиналом 100руб: ").append(money.getAmountOf100());

        System.out.println(newString);
        System.out.println("Итого: " + money.getSumm());

    }


    @Override
    public void onLoad() {
        System.out.println("Подождите, ваш запрос обрабатывается...");
    }


    @Override
    public void onAddMoney(int x) {
        System.out.println("Возьмите деньги..." + x + " рублей");
    }

    @Override
    public void onFailure(int y) {
        System.out.println("Операция не выполнена, попробуйте еще раз." + "В банкомате: " + y + " рублей.");
    }
}
