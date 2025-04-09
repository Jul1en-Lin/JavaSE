package User.Userfactory;
import User.NormalUser;
import User.User;

public class NormalUserFactory implements IUSerFactory{
    @Override
    public User creatUser(String name, int userID) {
        return new NormalUser(name,userID);
    }
}
