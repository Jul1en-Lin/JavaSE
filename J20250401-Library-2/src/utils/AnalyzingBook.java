package utils;

import Book.Book;
import com.bit.utils.FileUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class AnalyzingBook {
    //存储书籍
    public void storeBook(Book[] books, String name, String filename) throws Exception{
        //统计有效书籍
        int BooksUseLen = 0;
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null) {
                BooksUseLen++;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < BooksUseLen; i++) {
            if (books[i] != null) {
                //更改过的toString方法 原理相同
                stringBuilder.append(books[i].toJSON());
                if (i != BooksUseLen - 1) {
                    stringBuilder.append("\n");
                }
            }
        }
    }

    private Book parseBookJson(String json) {
        String[] pairs = json.split(",");
        int bookId = Integer.parseInt(pairs[0]);
        String title = pairs[1];
        String author = pairs[2];
        String category = pairs[3];
        int publishYear = Integer.parseInt(pairs[4]);
        boolean isBorrowed = Boolean.parseBoolean(pairs[5]);
        int borrowedCount = Integer.parseInt(pairs[6]);
        LocalDateTime shelDate = LocalDateTime.parse(pairs[7]);
        if (title != null && author != null && category != null) {
            Book book = new Book(title,author,category,publishYear,shelDate);
            book.setBookId(bookId);
            book.setBorrowedCount(borrowedCount);
            return book;
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println("test");
    }
}
