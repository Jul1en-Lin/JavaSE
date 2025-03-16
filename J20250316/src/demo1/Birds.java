package demo1;

public class Birds {
    protected int rank;
    public String name;
    public int age;
    static String color = "black and white";

    public Birds(int rank, String name, int age) {
        this.rank = rank;
        this.name = name;
        this.age = age;
        System.out.println("父类构造代码块被执行");
    }

    @Override
    public String toString() {
        return "Birds{" +
                "rank=" + rank +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    static {
        System.out.println("父类的静态代码块被执行");
    }
    {
        System.out.println("父类的实例代码块被执行");
    }
}
