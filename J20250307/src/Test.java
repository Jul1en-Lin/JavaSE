public class Test {
    //输入一个非负整数，返回组成它的数字之和
    public static void main(String[] args) {
        int n=10000;
        System.out.println(fac4(n));
    }
    public static int fac4(int n){
        if(n<=9){
            return n;
        }else{
            int tmp=n%10;
            return tmp+fac4(n/10);
        }
    }
    //递归打印数字的每一位
    public static void main3(String[] args) {
        int n=1234;
        fac3(n);
    }
    public static void fac3(int n){
        if(n<=9){
            System.out.println(n);
        }else {
            fac3(n / 10);
            System.out.println(n % 10);
        }
    }

    //递归求和
    public static void main2(String[] args) {
        int n=10;
        System.out.println(n+fac2(n-1));
    }
    public static int fac2(int n){
        if(n==1){
            return 1;
        }
        return n+fac2(n-1);
    }

    //递归求n！
    public static void main1(String[] args) {
        int n=6;
        System.out.println(n*fac1(n-1));
    }
    public static int fac1(int n){
        if(n==1){
            return 1;
        }
        return n*fac1(n-1);

    }
}
