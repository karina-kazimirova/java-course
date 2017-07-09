package Monitoring;


public class MyException extends Exception {

    private int code;

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public MyException(int code){
        this.code = code;
    }


}
