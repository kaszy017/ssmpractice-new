package dao;

import entity.Appointment;
import org.apache.ibatis.annotations.Param;

/**
 * Created by kaszy on 2017-12-27 00:13.
 */
public interface AppointmentDao {
    /**
     * 插入预约图书记录
     *
     * @param bookId
     * @param studentId
     * @return 插入的行数
     */
    int insertAppointment(@Param("bookId") long bookId, @Param("studentId") long studentId);

    /**
     * 通过主键查询预约图书记录，并且携带图书实体
     *
     * @param bookId
     * @param studentId
     * @return
     */
    Appointment queryByKeyWithBook(@Param("bookId") long bookId, @Param("studentId") long studentId);

}
