package Monitoring;

public class RefreshState implements State {


    @Override
    public void writeState(UI ui) {
        System.out.println("Подождите, идет обновление данных ...");

    }

    @Override
    public void run(UI ui) {
        ui.downloadFile("http://kiparo.ru/t/rad.json", ui);
        //ui.downloadFile("http://kiparo.ru/t/rad.xml");
        ui.changeState(new ReadyState());
    }

}
