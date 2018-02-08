package dto;

import entity.Appointment;
import enums.AppointStateEnum;

/**
 * Created by kaszy on 2018-01-08 13:30.
 * 封装预约执行后结果
 */
public class AppointExecution {
//    图书ID
    private long bookId;
//    秒杀预约结果状态
    private int state;
//    标识状态
    private String stateInfo;
//    预约成功对象
    private Appointment appointment;

    public AppointExecution(){

    }
//    预约失败的构造器
    public AppointExecution(long bookId, AppointStateEnum stateEnum){
        this.bookId=bookId;
        this.state=stateEnum.getState();
        this.stateInfo=stateEnum.getStateInfo();
    }
//    预约成功的构造器
    public AppointExecution(long bookId,AppointStateEnum stateEnum,Appointment appointment){
        this.bookId=bookId;
        this.state=stateEnum.getState();
        this.stateInfo=stateEnum.getStateInfo();
        this.appointment=appointment;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getSteteInfo() {
        return stateInfo;
    }

    public void setSteteInfo(String steteInfo) {
        this.stateInfo = steteInfo;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    @Override
    public String toString() {
        return "AppointExecution{" +
                "bookId=" + bookId +
                ", state=" + state +
                ", steteInfo='" + stateInfo + '\'' +
                ", appointment=" + appointment +
                '}';
    }
}
