package demo2;

import demo1.AdminUser;
import demo1.ProxyUser;
import demo1.User;

public class Test {
    public static void main(String[] args) {
        AdminUserFactory adminUserFactory = new AdminUserFactory();
        User adminUser = adminUserFactory.creatUser("刘备", 3);
        NormalUserFactory normalUserFactory = new NormalUserFactory();
        User normalUser1 = normalUserFactory.creatUser("孙尚香",4);
        User normalUser2 = normalUserFactory.creatUser("刘禅",5);
        System.out.println("=======");
        ProxyUser ProxyUseradmin = new ProxyUser(adminUser);
        ProxyUser ProxyUsernormal1 = new ProxyUser(normalUser1);
        ProxyUser ProxyUsernormal2 = new ProxyUser(normalUser2);
    }
}
