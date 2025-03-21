package demo1;

public class OuterClass2 {
    public int age;
    public int data1 = 1;

    public static class InnerClass{
        public int data2 = 2;
        public void test(){
            System.out.println("InnerClass的方法被调用");
        }
    }
}
