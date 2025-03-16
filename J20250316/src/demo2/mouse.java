package demo2;

public class mouse extends Animal{
    public String tail = "long";
    public mouse(String name, int age, String color) {
        super(name, age, color);
    }

    @Override//重写
    public void eat() {
        System.out.println(this.name+"正在下水道吃东西");
    }

}
