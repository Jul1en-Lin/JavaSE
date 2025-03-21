package demo2;

public class Test {
    public static void main(String[] args) {
        Student student1 = new Student("12345");
        Student student2 = new Student("12345");
        System.out.println(student1.equals(student2));
    }
}
