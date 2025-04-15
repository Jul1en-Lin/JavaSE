package Book;
import Constant.Constant;
import Utils.AnalyzingBook;
import java.io.IOException;

//整合文件存储和读取//
public class Library {
    private static Library library;
    public Book[] books;
    //有效书籍数量
    public int bookCount;
    public AnalyzingBook analyzingBook = new AnalyzingBook();//为loadAllBook准备对象

    private Library(){
        //读
        loadAllBook();
    }
    public static Library getLibrary (){
        if (library == null) {
            library= new Library();
        }
        return library;
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
    }
    public void displayBooks(){
        System.out.println("显示图书");
    }
    public void exit(){
        System.out.println("Library类执行");
        System.exit(0);

    }

    public void addBook() {
    }
}
