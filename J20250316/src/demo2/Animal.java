package demo2;

public class Animal {
    public String name;
    public int age;
    String color = "white";
    final int NUM = 10;
    //final 修饰的常量不能被赋值,且一般为大写,而且要初始化

    public Animal(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }
    //子类当前方法的访问修饰符必须 >= 父类的权限
    //父类为protected 子类可以为protected或者public
    public void eat(){
        System.out.println(this.name+"正在吃饭");
    }
    //final 修饰的方法不能被重写
    //static 修饰的方法不能被重写
    //private 修饰的方法不能被重写
    final public void dead(){
        System.out.println("dead方法被调用");
    }
}
