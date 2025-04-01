package user;
import utils.PermissionException;

public class ProxyUser {
    private User realuser;

    public ProxyUser(User realuser) {
        this.realuser = realuser;
    }

    public User getRealuser() {
        return realuser;
    }
    public int display(){
        return this.realuser.display();
    }

    //----管理员相关方法----//

    //添加书籍
    public void addBook() {
    }

    //图书修改 支持修改书名 作者 类别
    public void updateBook() {

    }

    //删除书籍
    public void removeBook() {

    }

    //统计每本书的借阅次数
    public void borrowCount() {

    }

    //查询最受欢迎的前n本书
    public void generateBook() {

    }

    //查看库存状态
    public void checkInventoryStatus() {

    }

    //并移除上架超过一年的图书
    public void checkAndRemoveOldBooks() {

    }

    public void exit() {
        //业务代码的实现
    }

    //----普通用户相关方法----//

    //普通用户其他操作方法
    //借阅图书
    public void borrowBook() {

    }


    //归还图书
    public void returnBook() {

    }

    // 查看个人借阅情况
    public void viewBorrowBooks() {

    }
    public void checkRealUserWhetherAdminUser(String msg) {
        if (!(this.realuser instanceof AdminUser)) {
            throw new PermissionException(msg);
        }
    }

    public void checkRealUserWhetherNormalminUser(String msg) {
        if (this.realuser instanceof AdminUser) {
            throw new PermissionException(msg);
        }
    }



}
