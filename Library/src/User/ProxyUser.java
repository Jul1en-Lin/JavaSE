package User;

import Book.Library;
import Utils.PermissionException;

public class ProxyUser {
    private User realUser;
    public Library library;
    public ProxyUser(User User) {
        this.realUser = User;
        library = Library.getLibrary();
    }

    public User getRealUser() {
        return realUser;
    }

    public void setRealUser(User realUser) {
        this.realUser = realUser;
    }

    public int display(User realUser){
        return this.realUser.display();
    }
    public int display(){
        return this.realUser.display();
    }



    //---------管理员的方法----------
    //检查权限
    private void weatherAdminUserCheck() throws PermissionException {
        if (!(this.realUser instanceof AdminUser)) {
            throw new PermissionException("普通用户没有权限");
        }
    }
    //上架图书
    public void addBook() {
        System.out.println("代理类addBook");
        try {
            weatherAdminUserCheck();
        }catch (PermissionException e){
            e.printStackTrace();
        }
        ((AdminUser)(this.realUser)).addBook();
    }
    //图书修改更新
    public void updateBook() {
        try {
            weatherAdminUserCheck();
        }catch (PermissionException e){
            e.printStackTrace();
        }
        ((AdminUser)(this.realUser)).updateBook();
    }
    //下架书籍
    public void removeBook() {
        try {
            weatherAdminUserCheck();
        }catch (PermissionException e){
            e.printStackTrace();
        }
        ((AdminUser)(this.realUser)).removeBook();
    }
    //统计借阅次数
    public void borrowBookCount() {
        try {
            weatherAdminUserCheck();
        }catch (PermissionException e){
            e.printStackTrace();
        }
        ((AdminUser)(this.realUser)).borrowBookCount();
    }
    //查询最受欢迎的前N本书
    public void generateBook() {
        try {
            weatherAdminUserCheck();
        }catch (PermissionException e){
            e.printStackTrace();
        }
        ((AdminUser)(this.realUser)).generateBook();
    }
    //查看库存状态
    public void checkInventoryStatus() {
        try {
            weatherAdminUserCheck();
        }catch (PermissionException e){
            e.printStackTrace();
        }
        ((AdminUser)(this.realUser)).checkInventoryStatus();
    }
    //并移除上架超过⼀年的图书
    public void checkAndRemoveOldBooks() {
        try {
            weatherAdminUserCheck();
        }catch (PermissionException e){
            e.printStackTrace();
        }
        ((AdminUser)(this.realUser)).checkAndRemoveOldBooks();
    }
    //退出系统
    public void exit() {
        System.out.println("代理的方法被执行了，系统退出");
        System.exit(0);

    }


    //---------普通用户的方法----------
    //检查普通用户权限
    private void weatherNormalUserCheck() throws PermissionException {
        if (!(this.realUser instanceof NormalUser)) {
            throw new PermissionException("管理员没有权限");
        }
    }
    //借阅图书
    public void borrowBook () {
        try {
            weatherNormalUserCheck();
        }catch (PermissionException e){
            e.printStackTrace();
        }
        ((NormalUser)(this.realUser)).borrowBook();
    }
    //归还图书
    public void returnBook () {
        try {
            weatherNormalUserCheck();
        }catch (PermissionException e){
            e.printStackTrace();
        }
        ((NormalUser)(this.realUser)).returnBook();
    }
    //查看个人借阅的图书情况
    public void viewBorrowBooks () {
        try {
            weatherNormalUserCheck();
        }catch (PermissionException e){
            e.printStackTrace();
        }
        ((NormalUser)(this.realUser)).viewBorrowBooks();
    }

    public void handleOperation(int choice) {
        if (this.realUser instanceof AdminUser) {
            switch (choice){
                case 1:
                    library.searchBook();
                    break;
                case 2:
                    library.displayBooks();
                    break;
                case 3:
                    library.exit();
                    break;
                case 4:
                    addBook();
                    break;
                case 5:
                    updateBook();
                    break;
                case 6:
                    removeBook();
                    break;
                case 7:
                    borrowBookCount();
                    break;
                case 8:
                     generateBook();
                    break;
                case 9:
                    checkInventoryStatus();
                    break;
                case 10:
                    checkAndRemoveOldBooks();
                    break;
                default:
                    break;
            }
        } else {
            switch (choice){
                case 1:
                    library.searchBook();
                    break;
                case 2:
                    library.displayBooks();
                    break;
                case 3:
                    library.exit();
                    break;
                case 4:
                    borrowBook ();
                    break;
                case 5:
                    returnBook ();
                    break;
                case 6:
                    viewBorrowBooks ();
                    break;
                default:
                    break;
            }
        }
    }
}
