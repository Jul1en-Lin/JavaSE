package Book;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Book {
    private int bookId;//书的ID
    private String title;//书名
    private String author;//作者
    private String category; // 类别
    private int publishYear; // 出版年份
    private boolean isBorrowed; // 借阅状态
    private int borrowedCount; // 借阅次数
    private LocalDate shelfDate;//上架时间

    public Book(String title, String author, String category, int publishYear, LocalDate shelfDate) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.publishYear = publishYear;
        this.shelfDate = shelfDate;
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

    public void setBorrowCount(int borrowedCount) {
        this.borrowedCount = borrowedCount;
    }

    public LocalDate getShelfDate() {
        return shelfDate;
    }

    public void setShelfDate(LocalDate shelfDate) {
        this.shelfDate = shelfDate;
    }

    public void incrementBorrowCount(){
        this.borrowedCount++;
    }
    public void decrementBorrowCount(){
        this.borrowedCount--;
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
                ", shelfDate=" + shelfDate +
                '}';
    }

    public String toJson() {
        StringBuilder json = new StringBuilder();
        json.append(bookId).append(",");
        json.append(title).append(",");
        json.append(author).append(",");
        json.append(category).append(",");
        json.append(publishYear).append(",");
        json.append(isBorrowed).append(",");
        json.append(borrowedCount).append(",");
        json.append(shelfDate != null ? shelfDate.format(DateTimeFormatter.ISO_LOCAL_DATE) : null);
        return json.toString();
    }
}
