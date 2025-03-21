package demo1;


public class Test {
    public static void main(String[] args) {
        OuterClass2.InnerClass innerClass = new OuterClass2.InnerClass();
        innerClass.test();
    }
    public static void main1(String[] args) {
        OuterClass outerClass = new OuterClass();
        OuterClass.InnerClass innerClass = outerClass.new InnerClass();
        innerClass.test();
    }
}
