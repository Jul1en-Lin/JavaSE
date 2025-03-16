package demo2;

final public class Test {
    public void main(String[] args) {
        //非静态的main方法
        Test test = new Test();
        test.fun2();
    }
    public static void main4(String[] args) {
        Animal animal = new bear("xiongda",12,"brown");
        animal.dead();
        bear bear = new bear("xiongda",12,"brown");
        bear.dead();
    }
    public static void fun2() {
        Animal[] arr = {new bear("xiongsan",2,"black"),
                new mouse("sd",1,"white")};
        for (Animal arr1 : arr) {
            arr1.eat();
        }

    }

    public static void main3(String[] args) {
        fun2();
    }
    public static void fun1(Animal animal){
        animal.eat();
    }
    public static void main2(String[] args) {
        bear bear = new bear("xiong er",10,"brown");
        fun1(bear);
    }
    public static void main1(String[] args) {
        Animal animal = new bear("xiongda",12,"brown");
        //向上转型
        animal.eat();//动态绑定
    }


}
