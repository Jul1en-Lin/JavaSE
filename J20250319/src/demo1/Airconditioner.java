package demo1;
//可以继承父类的同时继承应用接口 不过声明的顺序不能调转
//Airconditioner implements Machine extends Cold  //error
public class Airconditioner extends Cold implements Machine{
    @Override
    public void test() {
        System.out.println("测试空调");
    }

    @Override
    public void printf() {
        //super.printf();
        System.out.println("Cold方法被重写了");
    }

    @Override
    public void openDevice() {
        System.out.println("打开空调");
    }

    @Override
    public void fun1() {
        System.out.println("运行空调");
    }

    @Override
    public void closeDevice() {
        System.out.println("关闭空调");
    }

}
