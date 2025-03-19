package demo1;

public class Test {
    public static void main(String[] args) {
        Airconditioner airconditioner = new Airconditioner();
        airconditioner.printf();
        airconditioner.test();
    }
    public static void fun3(Machine machine){
        machine.test();
    }
    public static void main4(String[] args) {
        fun3(new Fridge());
        fun3(new Fan());
    }
    public static void fun2(){
        Machine[] machines = {new Computer(),new Fan(),new Fridge()};
        for (Machine machine:machines) {
            machine.test();
            machine.openDevice();
            machine.fun1();
            machine.closeDevice();
        }
    }
    public static void main3(String[] args) {
        fun2();
    }
    public static void main2(String[] args) {
        Machine machine = new Computer();
        Computer computer = (Computer) machine;
        computer.print();//向下转型 调用接口没有的方法
    }
    public static void fun1(Machine machine){
        machine.test();
        machine.openDevice();
        machine.fun1();
        machine.closeDevice();
    }
    public static void main1(String[] args) {
        fun1(new Computer());
        fun1(new Fan());
        fun1(new Fridge());
        Machine.print();
    }
}
