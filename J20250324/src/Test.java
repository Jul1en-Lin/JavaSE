import java.util.Locale;

public class Test {
    public static boolean isAdmin(String userId){
        return userId.toLowerCase()=="admin";
    }
    public static void main(String[] args) {
        /*String str = "LOVELY";
        System.out.println(str.toLowerCase());*/
        System.out.println(isAdmin("Admin"));

    }
}
