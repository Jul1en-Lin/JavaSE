package demo1;

import java.math.BigDecimal;

public class Test {


    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal("123.98");
        BigDecimal bigDecimal2 = new BigDecimal(123.98);
        System.out.println(bigDecimal);
        System.out.println(bigDecimal2);
    }
}
