package demo1;

import demo2.NormalUserFactory;

public class Test {
    public static void main(String[] args) {
        Principal master1 = Principal.getInstance();
        Principal master2 = Principal.getInstance();
        System.out.println(master1 == master2);
    }
}
