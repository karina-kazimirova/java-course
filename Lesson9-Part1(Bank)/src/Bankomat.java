/**
 * Created by Sve on 02.06.2017.
 */
public class Bankomat{

    /* Создаем переменную Интерфейса(анооним класс)
    private BankListener listener = new BankListener() {
        @Override
        public void onLoad() {

        }

        @Override
        public void onGetMoney(boolean result, int x) {

        }
    };  */



    public static void main(String[] args) {

        Bankomat bank = new Bankomat();

        Money money = new Money(10, 5,1);

        money.setListener(new BankListener() {
                              @Override
                              public void onLoad() {
                                  System.out.println("Подождите, ваш запрос обрабатывается...");
                              }

                              @Override
                              public void onGetMoney(boolean result, int x) {
                                  if (result == true) {
                                      System.out.println("Возьмите деньги..." + x + " рублей");
                                  } else {
                                      System.out.println("Операция не выполнена, попробуйте еще раз.");
                                  }
                              }

                              });

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


  }
