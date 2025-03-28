import java.math.BigDecimal;
import java.math.RoundingMode;

public class Test {
    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal(0.2);
        System.out.println(bigDecimal);
        BigDecimal bigDecimal1 = new BigDecimal("0.2");
        System.out.println(bigDecimal1);
        BigDecimal bigDecimal2 = new BigDecimal("0.1");
        BigDecimal bigDecimal3 = new BigDecimal("0.5");
        BigDecimal ret = bigDecimal2.add(bigDecimal3);
        System.out.println(ret);
        BigDecimal ret1 = bigDecimal1.pow(3);
        BigDecimal ret2 = bigDecimal2.divide(bigDecimal3);
        System.out.println(ret2);
        BigDecimal ret3 = bigDecimal2.divide(bigDecimal3,3, RoundingMode.DOWN);
        System.out.println(ret3);
    }
}
