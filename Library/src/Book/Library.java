package Book;
import Constant.Constant;
import Utils.AnalyzingBook;
import Utils.ScannerSingleton;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Scanner;

//整合文件存储和读取//
public class Library {
    private static Library library;
    public Book[] books;
    //有效书籍数量
    public int bookCount;
    public Scanner scanner;
    public AnalyzingBook analyzingBook = new AnalyzingBook();//为loadAllBook准备对象

    private Library(){
        //读
        loadAllBook();
        scanner = ScannerSingleton.getScanner();
    }
    public static Library getLibrary (){
        if (library == null) {
            library= new Library();
        }
        return library;
    }

    public Book searchById(int bookId) {
        loadAllBook();
        for (int i = 0; i < bookCount; i++) {
            Book thisBook = books[i];
            if (thisBook.getBookId() == bookId){
                return thisBook;
            }
        }
        return null;
    }

    //实时更新书籍
    private void loadAllBook() {
        try {
            Book[] allBook = analyzingBook.loadObject(Constant.ALL_BOOK_FILE_NAME);
            books = new Book[Constant.CAPACITY];
            if (allBook == null) {
                bookCount =0;
            } else {
                int allBookLen = allBook.length;
                if (allBookLen > books.length) {
                    books = new Book[allBookLen];
                }
                //else 的情况可以省略 因为不影响下面的for循环
                for (int i = 0; i < allBookLen; i++) {
                    books[i] = allBook[i];
                }
                bookCount = allBookLen;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //存储书籍到文件
    private void storeBook(){
        try {
            analyzingBook.storeObject(books,Constant.ALL_BOOK_FILE_NAME);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //管理员与普通用户的共同方法
    public void searchBook(){
        System.out.println("查找图书");
        scanner.nextLine();
        System.out.println("输入你想要查找的书籍的名称");
        String title = scanner.nextLine();
        Book book = search(title);
        if (book == null) {
            System.out.println("没有你想要找的书籍");
            return;
        }else {
            System.out.println("找到了，详细信息如下");
            System.out.println(book);
        }
    }
    private Book search(String title) {
        for (int i = 0; i < bookCount; i++) {
            Book book = books[i];
            if (book.getTitle().contains(title)) {
                return book;
            }
        }
        return null;
    }
    public void displayBooks(){
        loadAllBook();
        for (int i = 0; i < bookCount; i++) {
            System.out.println(books[i]);
        }
    }
    public void exit(){
        System.out.println("Library类执行");
        System.exit(0);

    }

    public void addBook(Book newBook) {
        System.out.println("Library类执行");
        if (books.length >= bookCount) {
            //扩容
            books = Arrays.copyOf(books, 2 * books.length);
        }
        /*books[bookCount++] = newBook;
        //bookCount++;
        newBook.setBookId(bookCount);*/  //这有ID bug
        //修改如下
        books[bookCount] = newBook;
        Book bookLast = books[bookCount-1];
        newBook.setBookId(bookLast.getBookId()+1);
        bookCount++;
        storeBook();
        System.out.println("图书添加成功："+newBook.getTitle());
    }

    public void updateBook(Book book) {
        System.out.println("Library类执行");
        int bookId = book.getBookId();
        int index = searchBookIdReturnIndex(bookId);
        if (index == -1) {
            System.out.println("没有你想要找的图书");
            return;
        }
        books[index] = book;
        storeBook();
        System.out.println("更新成功");
        library.displayBooks();
    }

    private int searchBookIdReturnIndex(int bookId) {
        loadAllBook();
        for (int i = 0; i < bookCount; i++) {
            Book book = books[i];
            if (book.getBookId() == bookId) {
                return i;
            }
        }
        return -1;
    }

    public void removeBook(int bookId) {
        System.out.println("Library类执行");
        loadAllBook();
        int index = searchBookIdReturnIndex(bookId);
        //覆盖即删除
        for (int i = index; i < bookCount-1; i++) {
            books[i] = books[i+1];//必须是bookCount-1 否则books[i+1]越界
        }
        //将最后一位清空
        books[bookCount-1] = null;
        bookCount--;
        storeBook();
        System.out.println("删除成功");
    }

    public void borrowBookCount() {
        System.out.println("Library类执行");
        loadAllBook();
        for (int i = 0; i < bookCount; i++) {
           Book book = books[i];
            System.out.println("书籍："+book.getTitle()+"总共借阅了："+book.getBorrowedCount()+"次");
        }
    }

    public void generateBook(int imp) {
        System.out.println("Library类执行");
        loadAllBook();
        Book[] tmp = new Book[bookCount];
        for (int i = 0; i < bookCount; i++) {
            tmp[i] = books[i];
        }
        Arrays.sort(tmp);

        Book[] generateBook = new Book[imp];
        System.out.println("最受欢迎的前"+imp+"本书如下：");
        for (int i = 0; i < imp; i++) {
            generateBook[i] = tmp[i];
            Book book = generateBook[i];
            System.out.println("书籍Id：" + book.getBookId()+"|书名："+book.getTitle()+"|借阅了：" + book.getBorrowedCount()+"次");
        }
    }

    public void checkInventoryStatus() {
        System.out.println("Library类执行");
        loadAllBook();
        String msg = "在馆未借出";
        for (int i = 0; i < bookCount; i++) {
            Book book = books[i];
            if (book.isBorrowed()) {
                msg = "已借出";
            }
            System.out.println("书籍："+book.getTitle()+"的借阅状态为："+msg);
        }
    }

    public void checkAndRemoveOldBooks() {
        loadAllBook();
        //获取当前时间戳
        long currentTimestamp = System.currentTimeMillis();
        //将当前时间戳转换为LocalDate
        LocalDate currentDate = Instant.ofEpochMilli(currentTimestamp)
                .atZone(ZoneId.systemDefault()).toLocalDate();

        boolean flg = false;
        for (int i = 0; i < bookCount; i++) {
            Book book = books[i];
            LocalDate specifiedDate = book.getShelfDate();

            //计算两个日期之间的差值
            long yearsBetween = ChronoUnit.YEARS.between(specifiedDate,currentDate);
            if (yearsBetween >= 1) {
                System.out.println("图书" + book.getTitle()+"已经上架超过一年，是否移除？(yes/no)");
                scanner.nextLine();
                String response = scanner.nextLine();
                if (response.equalsIgnoreCase("yes")) {
                    //删除图书
                    removeBook(book.getBookId());
                    //因为后面的书已经向前移动，所以要重新检查当前索引位置
                    i--;
                }
                flg = true;
            }
        }
        if (! flg) {
            System.out.println("没有上架超过一年的图书");
            return;
        }
        storeBook();
        displayBooks();
    }

    public void borrowBook(int bookId) {
        loadAllBook();
        Book book = searchById(bookId);
        book.setBorrowed(true);
        book.incrementBorrowCount();
        storeBook();
    }

    public void returnBook(int bookId) {
        loadAllBook();
        Book book = searchById(bookId);
        book.setBorrowed(false);
        book.decrementBorrowCount();
        storeBook();
    }

}
