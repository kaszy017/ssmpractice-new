package entity;

/**
 * Created by kaszy on 2017-12-27 00:06.
 */
public class Book {
    private long bookId;// 图书ID
    private String name;// 图书名称
    private int number;// 馆藏数量

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
