package demo1;

public class Computer implements Machine {
    public Computer() {
        super();
    }
    @Override
    public void test() {
        System.out.println("测试电脑");
    }
    @Override
    public void openDevice() {
        System.out.println("打开电脑");
    }

    @Override
    public void fun1() {
        System.out.println("正在运行电脑");
    }

    @Override
    public void closeDevice() {
        System.out.println("关闭电脑");
    }

    public void print(){
        System.out.println("打印Computer的图纸");
    }
}
