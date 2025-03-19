package demo1;

public interface Machine {
    //成员方法默认是public abstract 且不能有主体
    public void test();
    abstract void openDevice();
    public abstract void fun1();
    void closeDevice();
    public static void print(){
        System.out.println("这是Machine的方法");
    }
}
