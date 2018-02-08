package exception;

/**
 * Created by kaszy on 2018/1/8.
 * 库存不足异常
 */
public class NoNumberException extends RuntimeException{
    public NoNumberException(String message){
        super(message);
    }
    public NoNumberException(String message,Throwable cause){
        super(message,cause);
    }
}
