import java.util.Random;
import java.util.Scanner;

public class Test {
    /**
     * 打印用“*”组成的X形图案
     * 多组输入，一个整数（2~20），表示输出的行数，也表示组成“X”的反斜线和正斜线的长度。
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        System.out.println("输入你想要的数字");
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int a = in.nextInt();
            for(int i=0;i<a;i++){
                for(int j=0;j<a;j++){
                    if(i==j){
                        System.out.print("*");
                    }else if(i+j==a-1){
                        System.out.print("*");
                    }else{
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }
    }
    /**
     * 猜数字
     * @param args
     */
    public static void main5(String[] args) {
        Random random=new Random();
        int num= random.nextInt(100);
        int count=5;
        while(count!=0){
            System.out.println("请输入你的数字");
            Scanner scanner=new Scanner(System.in);
            int input=scanner.nextInt();
            if(num>input){
                System.out.println("猜小了");
            }else if(num<input){
                System.out.println("猜大了");
            }else{
                System.out.println("猜对了");
                break;
            }
            count--;
            System.out.println("你还有"+count+"次机会");
        }
    }

    /**
     * 求1/1+1/2-1/3+...+1/100
     * @param args
     */
    public static void main4(String[] args) {
        double sum=0.0;
        double sign=1.0;
        for(int i=1;i<=100;i++){
            sum+=sign*(1.0/i);
            sign*=-1;
        }
        System.out.println("计算结果为："+sum);
    }

    /**
     * 求最大公约数
     * @param args
     */
    public static void main3(String[] args) {
            int x=24;
            int y=18;
            int min=Math.min(x,y);
            for(int i=min;i>=1;i--){
                if(x%i==0&&y%i==0){
                    System.out.println(i);
                    break;
                }
            }
    }

    /**
     * 求1-100中出现数字9的次数
     * @param args
     */
    public static void main2(String[] args) {
        int count=0;
        for (int i=1;i<=100;i++){

            int imp=i;
            while(imp!=0){
                int i1 = imp % 10;
                if(i1==9){
                    count++;
                }
                imp/=10;
            }
        }
        System.out.println(count);
    }

    /**
     * 求1000-2000年中的闰年
     * @param args
     */
    public static void main1(String[] args) {
        for (int year=1000;year<=2000;year++){
            if(year%4==0&&year%100!=0){
                System.out.println(year+"是普通闰年");
            } else if (year%400==0) {
                System.out.println(year+"是世纪闰年");
            }
        }
    }
}

