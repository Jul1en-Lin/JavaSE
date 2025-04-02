package Book;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Book {
    //书的ID-编号
    private int bookId;
    //书名
    private String title;
    //作者
    private String author;
    //类别
    private String category;
    //出版年份
    private int publishYear;
    //借阅状态
    private boolean isBorrowed;
    //借阅次数
    private int borrowedCount;
    //上架时间
    private LocalDateTime shelDate;

    public Book(String title, String author, String category, int publishYear, LocalDateTime shelDate) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.publishYear = publishYear;
        this.shelDate = shelDate;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    public int getBorrowedCount() {
        return borrowedCount;
    }

    public void setBorrowedCount(int borrowedCount) {
        this.borrowedCount = borrowedCount;
    }

    public LocalDateTime getShelDate() {
        return shelDate;
    }

    public void setShelDate(LocalDateTime shelDate) {
        this.shelDate = shelDate;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", category='" + category + '\'' +
                ", publishYear=" + publishYear +
                ", isBorrowed=" + isBorrowed +
                ", borrowedCount=" + borrowedCount +
                ", shelDate=" + shelDate +
                '}';
    }
    //更改toString方法
    public String toJSON() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(bookId).append(',');
        stringBuilder.append(title).append(',');
        stringBuilder.append(author).append(',');
        stringBuilder.append(category).append(',');
        stringBuilder.append(publishYear).append(',');
        stringBuilder.append(isBorrowed).append(',');
        stringBuilder.append(borrowedCount).append(',');
        stringBuilder.append(shelDate != null ? shelDate.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME):null);
        return stringBuilder.toString();
    }
}
