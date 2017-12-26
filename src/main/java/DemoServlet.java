import java.io.IOException;
import javax.servlet.annotation.WebServlet;
/**
 * Created by kaszy on 2017-12-26 23:08.
 */
@WebServlet("/doDemo")
public class DemoServlet extends javax.servlet.http.HttpServlet {
    @Override
    protected void doPost(javax.servlet.http.HttpServletRequest request,
                          javax.servlet.http.HttpServletResponse response)
        throws javax.servlet.ServletException, IOException {
        response.sendRedirect("http://www.baidu.com");
    }
    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
        throws javax.servlet.ServletException, IOException {
        doPost(request,response);
    }
}
