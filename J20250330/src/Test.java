import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        User user = new User("张三",1);
        System.out.println("请输入用户名密码");
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();

        try {
            if (i == user.Passcode){
                System.out.println("密码正确，进入系统");
                return;
            }else if (i != user.Passcode){
                throw new PasscodeErrorException();
            }
        }catch (PasscodeErrorException e){
            e.printStackTrace();
            System.out.println("用户名密码错误");
        }finally {
            scanner.close();
        }
    }
}
