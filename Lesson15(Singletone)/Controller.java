package Lesson15;

/**
 * Created by Sve on 24.06.2017.
 */
public class Controller {


    // Первая реализация
    private static volatile Controller instance;

    private Controller() {
    }

    public static Controller getInstance() {
        if (instance == null) {
            synchronized (Controller.class) {
                if (instance == null) {
                    instance = new Controller();
                }
            }
        }
        return instance;
    }

    // Вторая реализация
 /* public final class Controller{
        private Controller(){
        }

        private static class ControllerInner{
            private final static Controller instance = new Controller();

        }

        public static Controller getInstance(){
            return ControllerInner.instance;
        }
    }*/

     //Третья реализация
   /* public enum Controller {
        INSTANCE;
    }*/
}



