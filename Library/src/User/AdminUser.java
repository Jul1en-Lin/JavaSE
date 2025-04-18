package User;

import Book.Book;
import Book.Library;
import Utils.ScannerSingleton;

import java.time.LocalDate;
import java.util.Scanner;

public class AdminUser extends User{
    public Scanner scanner;
    public Library library;
    public AdminUser(String name, int userID) {
        super(name, userID, "管理员");
        scanner = ScannerSingleton.getScanner();
        library = Library.getLibrary();
    }

    //Scanner scanner = new Scanner(System.in);
    @Override
    public int display() {
        System.out.println("管理员 " + name + " 的操作菜单:");
        System.out.println("1. 查找图书");
        System.out.println("2. 打印所有的图书");
        System.out.println("3. 退出系统");
        System.out.println("4. 上架图书");
        System.out.println("5. 修改图书");
        System.out.println("6. 下架图书");
        System.out.println("7. 统计借阅次数");
        System.out.println("8. 查看最后欢迎的前K本书");
        System.out.println("9. 查看库存状态");
        System.out.println("10. 检查超过⼀年未下架的图书");
        System.out.println("请选择你的操作：");

        return scanner.nextInt();
    }
    //上架图书
    public void addBook() {
        System.out.println("AdminUser类执行");

        scanner.nextLine();//吞掉换行符
        System.out.println("请输入书名");
        String title = scanner.nextLine();
        System.out.println("请输入作者");
        String author = scanner.nextLine();
        System.out.println("请输入类别");
        String category = scanner.nextLine();
        System.out.println("请输入出版年份");
        int publishYear = scanner.nextInt();
        scanner.nextLine();//吞掉换行符

        LocalDate shelfDate = LocalDate.now();
        Book newBook = new Book(title,author,category,publishYear,shelfDate);
        library.addBook(newBook);
    }
    //图书修改 更新
    public void updateBook() {
        System.out.println("AdminUser类执行");
        library.displayBooks();
        System.out.println("选择你要更新图书的id");

        //判断是否有这本图书
        int bookId = scanner.nextInt();
        Book book = library.searchById(bookId);
        if (book == null) {
            System.out.println("没有你想要更新的图书: "+bookId);
            return;
        }
        scanner.nextLine();
        System.out.println("请输入书名");
        String title = scanner.nextLine();
        System.out.println("请输入作者");
        String author = scanner.nextLine();
        System.out.println("请输入类别");
        String category = scanner.nextLine();
        System.out.println("请输入出版年份");
        int publishYear = scanner.nextInt();
        scanner.nextLine();//吞掉换行符

        book.setTitle(title);
        book.setAuthor(author);
        book.setCategory(category);
        book.setPublishYear(publishYear);
        library.updateBook(book);
    }
    //删除书籍
    public void removeBook() {
        System.out.println("AdminUser类执行");
        library.displayBooks();
        System.out.println("输入你要删除的图书的Id");
        int bookId = scanner.nextInt();
        Book removeBook = library.searchById(bookId);
        if (removeBook == null) {
            System.out.println("没有你要删除的图书");
            return;
        }
        library.removeBook(bookId);
    }
    //统计借阅次数
    public void borrowBookCount() {
        System.out.println("AdminUser类执行");
        library.borrowBookCount();
    }
    //查询最受欢迎的前N本书
    public void generateBook() {
        System.out.println("AdminUser类执行");
        System.out.println("现在书籍有："+library.bookCount+"本,输入的值不要超过书籍本数");
        int imp = scanner.nextInt();
        //判断imp合法性
        while ( imp <= 0 || imp > library.bookCount) {
            System.out.println("输入错误，请重新输入合适的数字");
            imp = scanner.nextInt();
        }
        library.generateBook(imp);
    }
    //查看库存状态
    public void checkInventoryStatus() {
        System.out.println("AdminUser类执行");
        library.checkInventoryStatus();
    }
    //并移除上架超过⼀年的图书
    public void checkAndRemoveOldBooks() {
        System.out.println("AdminUser类执行");
        library.checkAndRemoveOldBooks();
    }
    //退出系统
    public void exit() {

    }
}
