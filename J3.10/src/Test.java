import java.util.Scanner;

public class Test {
    //递归求解汉诺塔问题
    public static int countNum=0;
    public static void main(String[] args) {
        hanoi(3,'A','B','C');
        System.out.println("一共移动了"+countNum);
    }
    public static void hanoi(int n,char po1,char po2,char po3){
        if (n == 1) {
            //po1->po3
            move(po1,po3);
            //void方法中也能用return做退出
            return;
        }
        hanoi(n-1,po1,po3,po2);
        move(po1,po3);
        hanoi(n-1,po2,po1,po3);
    }
    public static void move(char posStr,char posDes){
        countNum++;
        System.out.println(posStr+"->"+posDes);
    }

    //递归求斐波那契数列的第 N 项 1 1 2 3 5 8 13 21...
    public static void main1(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        System.out.println( fibNum(n));
    }
    public static int fibNum(int n){
        if (n <=2) {
            return 1;
        }
        int tmp=fibNum(n-1)+fibNum(n-2);
        return tmp;
    }
}
