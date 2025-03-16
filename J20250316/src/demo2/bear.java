package demo2;

public class bear extends Animal{
    public int numPow = 2;
    public bear(String name, int age, String color) {
        super(name, age, color);
    }

    @Override//重写

    public void eat() {
        System.out.println(this.name+"正在吃蜂蜜");
    }

}
