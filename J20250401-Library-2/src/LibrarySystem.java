import user.ProxyUser;
import user.User;
import user.factory.AdminUserFactory;
import user.factory.IUserFactory;
import user.factory.NormalUserFactory;

public class LibrarySystem {
    public static void main(String[] args) {
        IUserFactory userFactory = new AdminUserFactory();
        User adminUser1 = userFactory.createUser("刘备", 1);
        IUserFactory userFactory1 = new NormalUserFactory();
        User normalUser1 = userFactory1.createUser("张飞", 2);
        User normalUser2 = userFactory1.createUser("关羽", 3);

        ProxyUser proxyUserAdmin = new ProxyUser(adminUser1);
        ProxyUser proxyUserNormal1 = new ProxyUser(normalUser1);
        ProxyUser proxyUserNormal2 = new ProxyUser(normalUser2);


        /*public ProxyUser selectProxyRole() {

        }*/
    }
}
