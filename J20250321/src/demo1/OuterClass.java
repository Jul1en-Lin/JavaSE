package demo1;

public class OuterClass {
    public int age;
    public int data1 = 1;
    class InnerClass{
        public int data1 = 100;
        public int data2 = 2;
        public void test(){
            System.out.println("InnerClass的方法被调用");
            System.out.println(data2);
            System.out.println(data1);
            System.out.println(OuterClass.this.data1);
            System.out.println(new OuterClass().data1);
        }
    }
}
