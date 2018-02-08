package exception;

/**
 * Created by kaszy on 2018/1/8.
 * 重复预约异常
 */
public class RepeatAppointException extends RuntimeException{
    public RepeatAppointException(String message){
        super(message);
    }
    public RepeatAppointException(String message,Throwable cause){
        super(message,cause);
    }
}
