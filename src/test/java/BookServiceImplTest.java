import java.util.List;

import dto.AppointExecution;
import entity.Book;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import service.BookService;

/**
 * Created by kaszy on 2018/1/8.
 */
/*
* 因为查询图书的业务不复杂，所以这里只演示我们最重要的预约图书业务！！
* */
public class BookServiceImplTest extends BaseTest{
    @Autowired
    private BookService bookService;

    @Test
    public void testGetById() throws Exception{
        long bookId = 1001;
        Book book = bookService.getById(bookId);
        System.out.println(book);
    }

    @Test
    public void testGetList() throws Exception{
        List<Book> books = bookService.getList();
        for(Book book:books){
            System.out.println(book);
        }
    }
    @Test
    public void testAppoint() throws Exception{
        long bookId = 1000;
        long studentId = 01;
        AppointExecution execution = bookService.appoint(bookId,studentId);
        System.out.println(execution);
    }
}
