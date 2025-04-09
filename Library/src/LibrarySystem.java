import User.User;
import User.Userfactory.AdminUserFactory;
import User.Userfactory.IUSerFactory;
import User.Userfactory.NormalUserFactory;
import User.ProxyUser;

public class LibrarySystem {
    public static void main(String[] args) {
        IUSerFactory adminUserFactory = new AdminUserFactory();
        User adminUser = adminUserFactory.creatUser("猪猪侠", 1);
        IUSerFactory normalUserFactory = new NormalUserFactory();
        User normalUser1 = normalUserFactory.creatUser("超人强", 2);
        User normalUser2 = normalUserFactory.creatUser("小菲菲", 3);

        ProxyUser proxyUserAdmin = new ProxyUser(adminUser);
        ProxyUser proxyUserNormal1 = new ProxyUser(normalUser1);
        ProxyUser proxyUserNormal2 = new ProxyUser(normalUser2);
    }
}
