import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int count=3;
        int code=12345;
        while(count!=0){
            System.out.println("请输入密码");
            int input= sc.nextInt();
            if(code==input){
                System.out.println("输入正确");
                break;
            }else{
                System.out.println("输入错误");
            }
            count--;
            System.out.println("还有"+count+"次机会");
        }
        sc.close();
    }
    /**
     * 输出一个整数的每一位，如：123的每一位是3，2，1
     * @param args
     */
    public static void main1(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int input=scanner.nextInt();
        while(input!=0){
            int y=input%10;
            input/=10;
            System.out.println(y);
        }
        scanner.close();
    }
}
