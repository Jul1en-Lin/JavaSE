package Utils;


import Book.Book;
import Constant.Constant;
import com.bit.utils.FileUtils;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class AnalyzingBook {
    //存储数据
    public void storeObject(Book[] books, String filename) throws IOException {
        int bookUseLen = 0;//有效长度
        for (int i = 0; i < books.length; i++) {
            if (books != null) {
                bookUseLen++;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < bookUseLen; i++) {
            if (books[i] != null) {
                stringBuilder.append(books[i].toJson());
                //换行 一本书籍完成后以\n进行分割
                if (i != bookUseLen-1) {
                    stringBuilder.append("\n");
                }
            }
        }
        FileUtils fileUtils = new FileUtils();
        fileUtils.writeFile(stringBuilder.toString(),filename);
    }
    //从文件读取数据
    public Book[] loadObject(String filename)throws IOException{
        FileUtils fileUtils = new FileUtils();
        String content = fileUtils.readFile(filename);

        if (content == null || content.isEmpty()) {
            System.out.println("图书馆为空");
            return null;
        }
        String[] bookJsonStrings = content.split("\n");
        //把bookJsonString 字符串组装成一个个书籍对象（因为要把String[]字符串解析为Book对象）
        Book[] bookList = new Book[bookJsonStrings.length];
        for (int i = 0; i < bookList.length; i++) {
            bookList[i] = parseBookJson(bookJsonStrings[i]);
        }
        return bookList;
    }
    //解析
    public Book parseBookJson(String Json){
        String[] pairs = Json.split(",");
        int bookId = Integer.parseInt(pairs[0]);
        String title = pairs[1];
        String author = pairs[2];
        String category = pairs[3];
        int publishYear = Integer.parseInt(pairs[4]);
        boolean isBorrowed = Boolean.parseBoolean(pairs[5]);
        int borrowCount = Integer.parseInt(pairs[6]);
        LocalDate shelfDate = LocalDate.parse(pairs[7]);
        if (title != null && author != null && category != null && shelfDate != null){
            Book book = new Book(title, author, category, publishYear, shelfDate);
            book.setBorrowed(isBorrowed);
            book.setBorrowCount(borrowCount);
            book.setBookId(bookId);
            return book;
        }
        return null;
    }


    public static void main1(String[] args) {
        Book[] books = new Book[4];
        books[0] = new Book("java", "gaobo", "编程", 1994, LocalDate.of(2023, 9, 24));
        books[1] = new Book("mysql", "lisi", "编程", 1999, LocalDate.of(2024, 2, 10));
        books[2] = new Book("php", "gaobo", "编程", 2020, LocalDate.of(2023, 9, 23));
        books[3] = new Book("西游记", "吴承恩", "⼩说", 2024, LocalDate.of(2023, 9, 23));

        AnalyzingBook analyzingBook = new AnalyzingBook();
        try {
            analyzingBook.storeObject(books,Constant.ALL_BOOK_FILE_NAME);
            Book[] ret = analyzingBook.loadObject(Constant.ALL_BOOK_FILE_NAME);
            //读出来
            for (int i = 0; i < ret.length; i++) {
                System.out.println(ret[i]);
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
