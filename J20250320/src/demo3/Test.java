package demo3;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person person1 = new Person("博哥",18);
        Person person2 = (Person) person1.clone();
        System.out.println(person1.m.money);
        System.out.println(person2.m.money);
        System.out.println("=======");
    }
    public static void main1(String[] args) throws CloneNotSupportedException {
        Person person1 = new Person("博哥",18);
        Person person2 = (Person) person1.clone();
        System.out.println(person2);

    }
}
