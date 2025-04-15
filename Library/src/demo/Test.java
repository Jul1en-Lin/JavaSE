package demo;

public class Test {
    public static void main(String[] args) {
        Integer a = -128;
        Integer b = -128;
        System.out.println(a == b);
    }
    public static void main3(String[] args) {
        Integer a = 128;
        Integer b = 128;
        System.out.println(a == b);
    }
    public static void main2(String[] args) {
        Integer a = 127;
        Integer b = 127;
        System.out.println(a == b);
    }

    public static void main1(String[] args) {
        Integer a = 100;
        Integer b = 100;
        System.out.println(a == b);
    }
}
