import java.util.Scanner;

public class Test {

    public static void main4(String[] args) {
        System.out.println(max(1.4,4.3,6.4));
    }
    public static int max(int a,int b){
        return a>b?a:b;
    }
    public static double max(double a,double b,double c){
        return (a>b?a:b)>c?(a>b?a:b):c;
    }
    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int j = scanner.nextInt();
        System.out.println("斐波那契数列的第" + j + "项：" + fib(j));
    }

    /**
     * 斐波那契数列 0 1 1 2 3 5 8 13 21....
     *
     * @param
     * @return
     */
    public static int fib(int n) {
        int x = 0;
        int y = 1;
        int sum = 0;
        if (n == 1) {
            return 0;
        } else if (n==2) {
            return 1;
        }
        for (int i = 3; i <= n; i++) {
            sum = x + y;
            x = y;
            y = sum;
        }
        return sum;
        /**
         * 计算1！+2！+3！+....+n!
         * @param args
         */
    /*public static void main1(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();
        int sum=0;
        for (int i = 1; i <=n ; i++) {
            sum+=fac(i);
        }
        System.out.println(sum);
    }
    *//**
         * 计算n！
         *//*
    public static int fac(int n) {
        int ret=1;
        for (int i = 1; i <= n; i++) {
            ret*=i;
        }
        return ret;
    }*/
    }
}
