package demo1;

public class Fridge implements Machine {
    @Override
    public void test() {
        System.out.println("测试冰箱");
    }

    @Override
    public void fun1() {
        System.out.println("正在运行冰箱");
    }

    @Override
    public void openDevice() {
        System.out.println("打开冰箱");
    }
    @Override
    public void closeDevice() {
        System.out.println("关闭冰箱");
    }
}
