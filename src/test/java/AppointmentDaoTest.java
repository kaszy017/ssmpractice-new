import dao.AppointmentDao;
import entity.Appointment;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by kaszy on 2018-01-08 13:00.
 */

public class AppointmentDaoTest extends BaseTest{
    @Autowired
    private AppointmentDao appointmentDao;

    @Test
    public void testInsertAppointment() throws Exception{
        long bookId = 1003;
        long studentId = 01;
        int insert = appointmentDao.insertAppointment(bookId,studentId);
        System.out.println("insert="+insert);
    }
    @Test
    public void testQueryByKeyWithBook() throws Exception{
        long bookId = 1003;
        long studentId = 01;
        Appointment appointment = appointmentDao.queryByKeyWithBook(bookId,studentId);
        System.out.println(appointment);
        System.out.println("\n"+"图书实体:"+ appointment.getBook());
    }
}
