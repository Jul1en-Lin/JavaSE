import java.math.BigDecimal;
import java.math.RoundingMode;

public class Test {

    public static int percentageLetter(String s, char letter) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == letter) {
                count++;
            }
        }
        return count * 100 / s.length() ;
    }
    public static void main1(String[] args) {
        System.out.println(percentageLetter("football", 'o'));
    }
}
