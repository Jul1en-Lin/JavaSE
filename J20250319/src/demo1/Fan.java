package demo1;

public class Fan implements Machine{
    @Override
    public void test() {
        System.out.println("测试风扇");
    }

    @Override
    public void fun1() {
        System.out.println("正在运行风扇");
    }

    @Override
    public void openDevice() {
        System.out.println("打开风扇");
    }
    @Override
    public void closeDevice() {
        System.out.println("关闭风扇");
    }
}
