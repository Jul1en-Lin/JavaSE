package User.Userfactory;
import User.AdminUser;
import User.User;

public class AdminUserFactory implements IUSerFactory{
    @Override
    public User creatUser(String name, int userID) {
        return new AdminUser(name,userID);
    }
}
