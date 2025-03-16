package demo1;

public class Eagel extends Birds {
    public int rank;
    public Eagel(int rank, String name, int age) {
        super(rank, name, age);//放首行 且不能与this同用
        System.out.println("子类的构造代码块被执行");
        System.out.println("protecte对象被更改为"+rank);
        super.rank = 8;
        System.out.println("rank被更改了");
    }
    static {
        System.out.println("子类的静态代码块被执行");
    }
    {
        System.out.println("子类的实例代码块被执行");
    }
    public static String shout(){
        System.out.println("静态的方法被调用了");
        return "shout";
    }
    public void main1(Eagel eagel){
        Eagel eagel2 = new Eagel(6,"xixi",1);
        eagel2.shout();//方法的调用依赖对象，方法内部调用了不依赖对象的内容，所以编译通过
        //相反，当方法的调用不依赖对象，但方法的内部依赖对象的内容，此时编译错误

    }

    public static void main1(String[] args) {
        Eagel eagel1 = new Eagel(7,"USA",4);
        System.out.println("变化前rank: "+eagel1);
        eagel1.rank = 5;
        System.out.println("变化后rank: "+eagel1);
        System.out.println(Birds.color+"被访问了");
    }
}
