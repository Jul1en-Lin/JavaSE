package User;

public class ProxyUser {
    private User realUser;

    public ProxyUser(User User) {
        this.realUser = User;
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

    //---------管理员的方法----------
    //上架图书
    public void addBook() {

    }
    //图书修改
    public void updateBook() {

    }
    //删除书籍
    public void removeBook() {

    }
    //统计借阅次数
    public void borrowBookCount() {

    }
    //查询最受欢迎的前N本书
    public void generateBook() {
    }
    //查看库存状态
    public void checkInventoryStatus() {
    }
    //并移除上架超过⼀年的图书
    public void checkAndRemoveOldBooks() {
    }
    //退出系统
    public void exit() {

    }
    //---------普通用户的方法----------
    //借阅图书
    public void borrowBook () {

    }
    //归还图书
    public void returnBook () {

    }
    //查看个人借阅的图书情况
    public void viewBorrowBooks () {

    }
}
