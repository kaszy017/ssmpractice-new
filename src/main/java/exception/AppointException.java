package exception;

/**
 * Created by kaszy on 2018/1/8.
 * 预约业务异常
 */
public class AppointException extends RuntimeException{
    public AppointException(String message){
        super(message);
    }
    public AppointException(String message,Throwable cause){
        super(message,cause);
    }
}
