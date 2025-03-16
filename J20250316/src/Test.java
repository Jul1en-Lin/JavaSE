import demo1.Birds;
import demo1.Myvalue;

public class Test {
    //交换两个变量的值
    public static void main(String[] args) {
        Myvalue myvalue1 = new Myvalue();
        myvalue1.num = 10;
        Myvalue myvalue2 = new Myvalue();
        myvalue2.num = 20;
        System.out.println("交换前myvalue1: "+myvalue1.num+" myvalue2 = "+myvalue2.num);
        exchange(myvalue1,myvalue2);
        System.out.println("交换后myvalue1: "+myvalue1.num+" myvalue2 = "+myvalue2.num);
    }
    public static void exchange(Myvalue myvalue1, Myvalue myvalue2) {
        int tmp = myvalue1.num;
        myvalue1.num = myvalue2.num;
        myvalue2.num = tmp;
    }
    public static void main1(String[] args) {
        int a = 10;
        int b = 20;
        int[] arr = new int[2];
        System.out.println("交换前的a："+a+" b: "+b);
        fun1(arr,a,b);
        a = arr[0];
        b = arr [1];
        System.out.println("交换后的a："+a+" b: "+b);
    }
    public static void fun1(int[] arr,int x, int y){
        arr[0] = x;
        arr[1] = y;
        int tmp = arr[0];
        arr[0] = arr[1];
        arr[1] = tmp;
    }
}

