import User.User;
import User.Userfactory.AdminUserFactory;
import User.Userfactory.IUSerFactory;
import User.Userfactory.NormalUserFactory;
import User.ProxyUser;
import Utils.ScannerSingleton;

import java.util.Scanner;

public class LibrarySystem {
    public Scanner scanner;
    public static void main(String[] args) {
        IUSerFactory adminUserFactory = new AdminUserFactory();
        User adminUser = adminUserFactory.creatUser("猪猪侠", 1);
        IUSerFactory normalUserFactory = new NormalUserFactory();
        User normalUser1 = normalUserFactory.creatUser("超人强", 2);
        User normalUser2 = normalUserFactory.creatUser("小菲菲", 3);

        ProxyUser proxyUserAdmin = new ProxyUser(adminUser);
        ProxyUser proxyUserNormal1 = new ProxyUser(normalUser1);
        ProxyUser proxyUserNormal2 = new ProxyUser(normalUser2);

        LibrarySystem librarySystem = new LibrarySystem();
        ProxyUser currentUser = librarySystem.selectProxyUser(proxyUserAdmin,proxyUserNormal1,proxyUserNormal2);
        //循环打印currentUser的菜单,执行再操作
        while (true) {
            int choice = currentUser.display();
            //执行currentUser的choice操作
            currentUser.handleOperation(choice);
        }
    }

    private ProxyUser selectProxyUser(ProxyUser proxyUserAdmin,ProxyUser proxyUserNormal1,ProxyUser proxyUserNormal2) {
        scanner = ScannerSingleton.getScanner();
        //Scanner in = new Scanner(System.in);
        ProxyUser currentUser = null;
        System.out.println("请选择你的用户");
        System.out.println("1.猪猪侠(管理员)");
        System.out.println("2.超人强(普通用户)");
        System.out.println("3.小菲菲(普通用户)");
        System.out.println("4.退出系统");
        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                currentUser = proxyUserAdmin;
                break;
            case 2:
                currentUser = proxyUserNormal1;
                break;
            case 3:
                currentUser = proxyUserNormal2;
                break;
            case 4:
                System.out.println("main方法中的系统退出");
                System.exit(0);
            default:
                break;
        }
        return currentUser;
    }
}
