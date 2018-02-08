package web;

import dto.AppointExecution;
import dto.Result;
import entity.Book;
import enums.AppointStateEnum;
import exception.NoNumberException;
import exception.RepeatAppointException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.BookService;

import java.util.List;

/**
 * Created by kaszy on 2018/1/8.
 */
/*
* controller测试，测试appoint方法可不必写jsp，用curl就行，比如
curl -H “Accept: application/json; charset=utf-8” -d “studentId=1234567890” localhost:8080/book/1003/appoint
* */
@Controller
@RequestMapping("/book") //url:/模块/资源/{id}/细分 /seckill/list,类级别注解，将一个特定请求或者请求模式映射到一个控制器之上
public class BookController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BookService bookService;
    //方法级别注解，指定到处理方法的映射关系
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    //list方法不是返回json的，故不用加@ResponseBody注解
    private String list(Model model){
        List<Book> list = bookService.getList();
        model.addAttribute("list",list);
        // list.jsp + model = ModelAndView
        return "list";// WEB-INF/jsp/"list".jsp
    }
    @RequestMapping(value = "/{bookId}/detail", method = RequestMethod.GET)
    //detail方法不是返回json的，故不用加@ResponseBody注解
    private String detail(@PathVariable("bookId")Long bookId,Model model){
        if(bookId == null){
            return "redirect:/book/list";
        }
        Book book = bookService.getById(bookId);
        if (book==null){
            return "forward:/book/list";
        }
        model.addAttribute("book",book);
        return "detail";
    }
//    ajax json
    @RequestMapping(value = "/{bookId}/appoint", method = RequestMethod.POST, produces = {
            "application/json; charset=utf-8" })
    @ResponseBody //appoint方法应该加上@ResponseBody注解
    private Result<AppointExecution> appoint(@PathVariable("bookId")Long bookId, @RequestParam("studentId")Long studentId){
        if(studentId == null ||studentId.equals(" ")){
            return new Result<>(false,"学号不能为空");
        }
        //AppointExecution execution = bookService.appoint(bookId, studentId);//错误写法，不能统一返回，要处理异常（失败）情况
        AppointExecution execution = null;
//        控制层根据捕获的异常返回相应信息给客户端，而不是业务层直接返回错误结果
        try {
            execution = bookService.appoint(bookId, studentId);
        } catch (NoNumberException e1) {
            execution = new AppointExecution(bookId, AppointStateEnum.NO_NUMBER);
        } catch (RepeatAppointException e2) {
            execution = new AppointExecution(bookId, AppointStateEnum.REPEAT_APPOINT);
        } catch (Exception e) {
            execution = new AppointExecution(bookId, AppointStateEnum.INNER_ERROR);
        }
        return new Result<AppointExecution>(true,execution);
    }
}
