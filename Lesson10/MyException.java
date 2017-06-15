package Lesson10;

/**
 * Created by Sve on 14.06.2017.
 */
public class MyException extends Exception {

    private int code;
    private  String russianMessage;

    public void setCode(int code) {
        this.code = code;
    }

     public void setRussianMessage(String russianMessage) {
        this.russianMessage = russianMessage;
    }


    public String getRussianMessage(String russianMessage) {
        return russianMessage;
    }


    public int getCode() {
        return code;
    }

    public MyException(int code){
        this.code = code;
    }


}
