package demo1;

public class OuterClass2 {
    public int age;
    public int data1 = 1;
    static int data3 = 3;
    private int data4 = 4;

    public static class InnerClass{
        public int data2 = 2;
        public void test(){
            System.out.println("InnerClass的方法被调用");
            System.out.println(data2);
            System.out.println(new OuterClass2().data1);
            System.out.println(data3);
            OuterClass2 outerClass2 = new OuterClass2();
            System.out.println(outerClass2.data4);
            System.out.println(outerClass2.data1);
        }
    }
}
