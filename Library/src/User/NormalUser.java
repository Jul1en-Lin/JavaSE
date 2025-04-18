package User;

import Book.Book;
import Book.Library;
import Book.PairOfUidAndBookId;
import Constant.Constant;
import Utils.AnalyzingBorrowedBook;
import Utils.ScannerSingleton;

import java.io.IOException;
import java.util.Scanner;

public class NormalUser extends User{
    // 当前书籍的借阅量
    private int borrowedCount;

    public Scanner scanner;
    public AnalyzingBorrowedBook analyzingBorrowedBook = new AnalyzingBorrowedBook();
    //存储图书借阅信息

    private PairOfUidAndBookId[] pairOfUidAndBookIds;
    private Library library;

    public NormalUser(String name, int userID) {
        super(name, userID, "普通用户");
        loadBorrowedBook();
        scanner = ScannerSingleton.getScanner();
        library = Library.getLibrary();
    }
    private void loadBorrowedBook() {
        try {
            PairOfUidAndBookId[] allBorrowedBook = analyzingBorrowedBook.loadObject(Constant.BORROWED_BOOK_FILE_NAME);
            pairOfUidAndBookIds = new PairOfUidAndBookId[Constant.CAPACITY];
            if (allBorrowedBook == null) {
                borrowedCount = 0;
            }else {
                int allBorrowedBookLen = allBorrowedBook.length;
                if (allBorrowedBookLen > pairOfUidAndBookIds.length) {
                    pairOfUidAndBookIds = new PairOfUidAndBookId[allBorrowedBookLen];
                }
                for (int i = 0; i < allBorrowedBookLen; i++) {
                    pairOfUidAndBookIds[i] = allBorrowedBook[i];
                }
                borrowedCount = allBorrowedBookLen;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void storeBorrowedBook() {
        System.out.println("NormalUser类执行");
        try {
            analyzingBorrowedBook.storeObject(pairOfUidAndBookIds,Constant.BORROWED_BOOK_FILE_NAME);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int display() {
        System.out.println("普通用户 " + name + " 的操作菜单:");
        System.out.println("1. 查找图书");
        System.out.println("2. 打印所有的图书");
        System.out.println("3. 退出系统");
        System.out.println("4. 借阅图书");
        System.out.println("5. 归还图书");
        System.out.println("6. 查看当前个⼈借阅情况");
        System.out.println("请选择你的操作：");
        return scanner.nextInt();
    }
    //借阅图书
    public void borrowBook () {
        System.out.println("NormalUser类执行");
        scanner.nextLine();
        library.displayBooks();
        System.out.println("请输入你要借阅图书的Id");
        int bookId = scanner.nextInt();
        scanner.nextLine();
        if (library.bookCount == 0) {
            System.out.println("当前没有书可以借阅");
            return;
        }
        loadBorrowedBook();
        //判断借阅图书是否存在
        Book book = library.searchById(bookId);
        if (book == null) {
            System.out.println("没有你想要借阅的书籍");
            return;
        }
        //开始准备借阅图书
        for (int i = 0; i < borrowedCount; i++) {
            PairOfUidAndBookId pair = pairOfUidAndBookIds[i];
            if (pair.getBookId() == book.getBookId()) {

                if (pair.getUserId() == this.getUserID()) {
                    System.out.println("你已经借阅过这本书了");
                    return;
                }else {
                    System.out.println("别人已经借阅过这本书了");
                    return;
                }
            }
        }
        //修改allBooks文件本身
        library.borrowBook(bookId);

        //写入借阅书籍的txt
        PairOfUidAndBookId pairOfUidAndBookId = new PairOfUidAndBookId(getUserID(),book.getBookId());
        pairOfUidAndBookIds[borrowedCount] = pairOfUidAndBookId;
        borrowedCount++;
        storeBorrowedBook();
        System.out.println("借阅书籍"+book.getTitle()+"成功");
    }
    //归还图书
    public void returnBook () {
        System.out.println("NormalUser类执行");
        loadBorrowedBook();
        scanner.nextLine();
        System.out.println("输入你要归还的图书的Id");
        int bookId = scanner.nextInt();
        if (library.bookCount == 0) {
            System.out.println("当前没有书可以借阅");
            return;
        }

        Book book = library.searchById(bookId);
        if (book == null) {
            System.out.println("当前没有此书籍");
            return;
        }

        for (int i = 0; i < borrowedCount; i++) {
            PairOfUidAndBookId pairOfUidAndBookId = pairOfUidAndBookIds[i];
            if (pairOfUidAndBookId.getBookId() == bookId) {
                //确认这本书是本人的
                if (getUserID() == pairOfUidAndBookId.getUserId()) {
                    library.returnBook(bookId);
                    System.out.println("归还成功");
                    //用最后一本书来填已经归还的书
                    pairOfUidAndBookIds[i] = pairOfUidAndBookIds[borrowedCount-1];
                    pairOfUidAndBookIds[borrowedCount-1] = null;
                    borrowedCount--;
                    storeBorrowedBook();
                }else {
                    System.out.println("这本书不是你的书籍，不能归还");
                }
                return;
            }
        }

    }
    //查看个人借阅的图书情况
    public void viewBorrowBooks () {
        loadBorrowedBook();
        if (borrowedCount == 0) {
            System.out.println("目前没有借阅的记录");
            return;
        }else {
            boolean flg = false;
            System.out.println("你的借阅情况如下：");
            for (int i = 0; i < borrowedCount; i++) {
                if (pairOfUidAndBookIds[i].getUserId() == this.getUserID()) {
                    int bookId = pairOfUidAndBookIds[i].getBookId();
                    Book book = library.searchById(bookId);
                    System.out.println(book.getTitle());
                    flg = true;
                }
            }
            if (!flg){
                System.out.println("你没有借阅过书籍");
            }
        }

    }
}
